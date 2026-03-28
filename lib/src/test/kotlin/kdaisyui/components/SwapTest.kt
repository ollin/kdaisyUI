package kdaisyui.components

import kotlinx.html.div
import kotlinx.html.span
import kotlinx.html.stream.createHTML
import kotlin.test.Test
import kotlin.test.assertEquals

class SwapTest {
    @Test
    fun rendersSwapRotate() {
        val html = createHTML(prettyPrint = false).div {
            daisySwap(rotate = true) {
                span("swap-on") { +"ON" }
                span("swap-off") { +"OFF" }
            }
        }
        assertEquals(
            expected = """<div><label class="swap swap-rotate"><span class="swap-on">ON</span><span class="swap-off">OFF</span></label></div>""",
            actual = html.trim(),
        )
    }
}
