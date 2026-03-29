package kdaisyui.components

import kdaisyui.core.addClassNames
import kotlinx.html.FlowContent
import kotlinx.html.UL
import kotlinx.html.ul

fun FlowContent.daisyMenu(
    extraClasses: String? = null,
    attrs: (UL.() -> Unit)? = null,
    content: (UL.() -> Unit),
) {
    ul {
        addClassNames("menu")
        addClassNames(extraClasses)
        if (attrs != null) attrs()
        content()
    }
}
