package kdaisyui.components

import kotlinx.html.div
import kotlinx.html.stream.createHTML
import kotlin.test.Test
import kotlin.test.assertEquals

class BadgeTest {
    @Test
    fun rendersBaseBadge() {
        val html = createHTML(prettyPrint = false).div {
            daisyBadge("New")
        }
        assertEquals(
            expected = """<div><span class="badge">New</span></div>""",
            actual = html.trim(),
        )
    }

    @Test
    fun rendersVariantAndSize() {
        val html = createHTML(prettyPrint = false).div {
            daisyBadge("12", variant = BadgeVariant.Success, size = BadgeSize.Sm)
        }
        assertEquals(
            expected = """<div><span class="badge badge-success badge-sm">12</span></div>""",
            actual = html.trim(),
        )
    }

    @Test
    fun rendersEmptyBadgeWithVariantAndSize() {
        val html = createHTML(prettyPrint = false).div {
            daisyBadge(variant = BadgeVariant.Error, size = BadgeSize.Xs)
        }
        assertEquals(
            expected = """<div><span class="badge badge-error badge-xs"></span></div>""",
            actual = html.trim(),
        )
    }
}
