package kdaisyui.components

import kotlinx.html.div
import kotlinx.html.stream.createHTML
import kotlin.test.Test
import kotlin.test.assertEquals

class CardTest {
    @Test
    fun rendersBaseCard() {
        val html = createHTML(prettyPrint = false).div {
            daisyCard {
                daisyCardBody {
                    daisyCardTitle("Hello")
                }
            }
        }
        assertEquals(
            expected = """<div><div class="card"><div class="card-body"><h2 class="card-title">Hello</h2></div></div></div>""",
            actual = html.trim(),
        )
    }

    @Test
    fun rendersCardWithExtraClasses() {
        val html = createHTML(prettyPrint = false).div {
            daisyCard(extraClasses = "bg-base-100 shadow-xs") {
                daisyCardBody {
                    daisyCardTitle("Title")
                }
            }
        }
        assertEquals(
            expected = """<div><div class="card bg-base-100 shadow-xs"><div class="card-body"><h2 class="card-title">Title</h2></div></div></div>""",
            actual = html.trim(),
        )
    }
}
