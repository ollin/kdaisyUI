package kdaisyui.components

import kotlinx.html.div
import kotlinx.html.stream.createHTML
import kotlinx.html.tbody
import kotlinx.html.td
import kotlinx.html.tr
import kotlin.test.Test
import kotlin.test.assertEquals

class TableTest {
    @Test
    fun rendersBaseTable() {
        val html = createHTML(prettyPrint = false).div {
            daisyTable {
                tbody {
                    tr { td { +"Hello" } }
                }
            }
        }
        assertEquals(
            expected = """<div><table class="table"><tbody><tr><td>Hello</td></tr></tbody></table></div>""",
            actual = html.trim(),
        )
    }

    @Test
    fun rendersZebraTable() {
        val html = createHTML(prettyPrint = false).div {
            daisyTable(zebra = true) {
                tbody {
                    tr { td { +"Row" } }
                }
            }
        }
        assertEquals(
            expected = """<div><table class="table table-zebra"><tbody><tr><td>Row</td></tr></tbody></table></div>""",
            actual = html.trim(),
        )
    }
}
