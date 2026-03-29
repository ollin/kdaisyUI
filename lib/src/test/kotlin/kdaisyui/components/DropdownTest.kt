package kdaisyui.components

import kotlinx.html.a
import kotlinx.html.div
import kotlinx.html.li
import kotlinx.html.stream.createHTML
import kotlinx.html.tabIndex
import kotlin.test.Test
import kotlin.test.assertEquals

class DropdownTest {
    @Test
    fun rendersDropdown() {
        val html = createHTML(prettyPrint = false).div {
            daisyDropdown(end = true) {
                div {
                    attributes["tabindex"] = "0"
                    +"Trigger"
                }
                daisyDropdownContent(extraClasses = "rounded-box bg-base-100") {
                    attributes["tabindex"] = "0"
                    li { a { +"Item" } }
                }
            }
        }
        assertEquals(
            expected = """<div><div class="dropdown dropdown-end"><div tabindex="0">Trigger</div><ul class="menu dropdown-content rounded-box bg-base-100" tabindex="0"><li><a>Item</a></li></ul></div></div>""",
            actual = html.trim(),
        )
    }
}
