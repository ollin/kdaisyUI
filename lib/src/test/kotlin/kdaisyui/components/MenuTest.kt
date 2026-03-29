package kdaisyui.components

import kotlinx.html.a
import kotlinx.html.div
import kotlinx.html.li
import kotlinx.html.stream.createHTML
import kotlin.test.Test
import kotlin.test.assertEquals

class MenuTest {
    @Test
    fun rendersBaseMenu() {
        val html = createHTML(prettyPrint = false).div {
            daisyMenu {
                li { a { +"Dashboard" } }
                li { a { +"Users" } }
            }
        }
        assertEquals(
            expected = """<div><ul class="menu"><li><a>Dashboard</a></li><li><a>Users</a></li></ul></div>""",
            actual = html.trim(),
        )
    }
}
