package kdaisyui.components

import kdaisyui.core.addClassNames
import kotlinx.html.DIV
import kotlinx.html.FlowContent
import kotlinx.html.H2
import kotlinx.html.div
import kotlinx.html.h2

fun FlowContent.daisyCard(
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
) {
    div {
        addClassNames("card")
        addClassNames(extraClasses)
        if (attrs != null) attrs()
        content()
    }
}

fun FlowContent.daisyCardBody(
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
) {
    div {
        addClassNames("card-body")
        addClassNames(extraClasses)
        if (attrs != null) attrs()
        content()
    }
}

fun FlowContent.daisyCardTitle(
    text: String? = null,
    extraClasses: String? = null,
    attrs: (H2.() -> Unit)? = null,
    content: (H2.() -> Unit)? = null,
) {
    h2 {
        addClassNames("card-title")
        addClassNames(extraClasses)
        if (attrs != null) attrs()

        when {
            content != null -> content()
            text != null -> +text
        }
    }
}
