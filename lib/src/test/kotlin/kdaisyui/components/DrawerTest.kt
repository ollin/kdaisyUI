package kdaisyui.components

import kotlinx.html.div
import kotlinx.html.stream.createHTML
import kotlin.test.Test
import kotlin.test.assertEquals

class DrawerTest {
    @Test
    fun rendersDrawerStructure() {
        val html = createHTML(prettyPrint = false).div {
            daisyDrawer(drawerId = "my-drawer") {
                daisyDrawerContent {
                    +"Main content"
                }
                daisyDrawerSide {
                    daisyDrawerOverlay()
                    +"Sidebar"
                }
            }
        }
        assertEquals(
            expected = """<div><div class="drawer"><input id="my-drawer" type="checkbox" class="drawer-toggle"><div class="drawer-content">Main content</div><div class="drawer-side"><label for="my-drawer" class="drawer-overlay"></label>Sidebar</div></div></div>""",
            actual = html.trim(),
        )
    }
}
