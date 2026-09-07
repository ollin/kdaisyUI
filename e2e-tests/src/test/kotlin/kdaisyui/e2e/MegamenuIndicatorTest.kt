package kdaisyui.e2e

import com.microsoft.playwright.Locator
import com.microsoft.playwright.Page.GetByRoleOptions
import com.microsoft.playwright.options.AriaRole
import com.microsoft.playwright.options.BoundingBox
import io.kotest.matchers.doubles.shouldBeGreaterThan
import io.kotest.matchers.doubles.shouldBeLessThan
import io.kotest.matchers.shouldBe

/**
 * `megamenu-active` is the indicator that slides under the trigger whose panel is open.
 *
 * DaisyUI calls the `<span>` mandatory. The reason is not the indicator's own styling — it is
 * `position: absolute` and styled by class alone, so a `span` and a `div` compute the same box.
 * The reason is its SIBLINGS: `megamenu.css` selects the open panel with
 * `[popover]:nth-of-type(N)`, and `:nth-of-type` counts among siblings of the same tag name. A
 * `<div>` indicator takes div index 1 and shifts every `<div popover>` panel by one, so the
 * indicator anchors to the trigger after the one whose panel is open.
 *
 * Every other assertion in this suite compares class strings, and this defect changes no class
 * on any element. Geometry is the only thing that can see it.
 */
class MegamenuIndicatorTest : PlaywrightSpec() {

    init {
        test("the indicator sits under the trigger whose panel is open") {
            page.navigate("/megamenu-reference")

            val trigger = page.getByRole(AriaRole.BUTTON, GetByRoleOptions().setName("Components").setExact(true))
            trigger.click()
            page.locator("#megamenu-panel-one:popover-open").waitFor()

            // Anchor positioning is what moves the indicator at all. Without it the indicator
            // would rest at its static position and this test would be measuring nothing while
            // still passing or failing by coincidence.
            page.evaluate("() => CSS.supports('anchor-name: --x')") shouldBe true

            val indicator = page.locator(".megamenu-active").settledBoundingBox()
            val target = trigger.boundingBox()

            val indicatorCentre = indicator.x + indicator.width / 2
            indicatorCentre shouldBeGreaterThan target.x
            indicatorCentre shouldBeLessThan target.x + target.width
        }
    }
}

/**
 * The indicator's `inset` transitions over 300ms, so a bounding box read straight after the click
 * is a frame of the animation rather than the result. Read too early the indicator is still near
 * where it started, which reads as "anchored correctly" no matter where it is heading — the
 * failure mode that made this test pass and fail on the same code depending only on how many
 * diagnostic calls preceded the measurement.
 */
private fun Locator.settledBoundingBox(): BoundingBox {
    var previous = boundingBox()
    repeat(20) {
        page().waitForTimeout(50.0)
        val current = boundingBox()
        if (current.x == previous.x && current.width == previous.width) return current
        previous = current
    }
    return previous
}
