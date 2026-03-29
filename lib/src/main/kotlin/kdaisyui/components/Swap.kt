package kdaisyui.components

import kdaisyui.core.addClassNames
import kotlinx.html.LABEL
import kotlinx.html.FlowContent
import kotlinx.html.label

fun FlowContent.daisySwap(
    rotate: Boolean = false,
    flip: Boolean = false,
    extraClasses: String? = null,
    attrs: (LABEL.() -> Unit)? = null,
    content: (LABEL.() -> Unit),
) {
    label {
        addClassNames("swap")
        if (rotate) addClassNames("swap-rotate")
        if (flip) addClassNames("swap-flip")
        addClassNames(extraClasses)
        if (attrs != null) attrs()
        content()
    }
}
