package kdaisyui.components

import kdaisyui.core.addClassNames
import kotlinx.html.DIV
import kotlinx.html.FlowContent
import kotlinx.html.UL
import kotlinx.html.div
import kotlinx.html.ul

fun FlowContent.daisyDropdown(
    end: Boolean = false,
    top: Boolean = false,
    left: Boolean = false,
    right: Boolean = false,
    hover: Boolean = false,
    open: Boolean = false,
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
) {
    div {
        addClassNames("dropdown")
        if (end) addClassNames("dropdown-end")
        if (top) addClassNames("dropdown-top")
        if (left) addClassNames("dropdown-left")
        if (right) addClassNames("dropdown-right")
        if (hover) addClassNames("dropdown-hover")
        if (open) addClassNames("dropdown-open")
        addClassNames(extraClasses)
        if (attrs != null) attrs()
        content()
    }
}

fun FlowContent.daisyDropdownContent(
    extraClasses: String? = null,
    attrs: (UL.() -> Unit)? = null,
    content: (UL.() -> Unit),
) {
    ul {
        addClassNames("menu dropdown-content")
        addClassNames(extraClasses)
        if (attrs != null) attrs()
        content()
    }
}
