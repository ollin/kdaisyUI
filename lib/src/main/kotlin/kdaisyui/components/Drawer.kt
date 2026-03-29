package kdaisyui.components

import kdaisyui.core.addClassNames
import kotlinx.html.DIV
import kotlinx.html.FlowContent
import kotlinx.html.InputType
import kotlinx.html.LABEL
import kotlinx.html.div
import kotlinx.html.id
import kotlinx.html.input
import kotlinx.html.label

fun FlowContent.daisyDrawer(
    drawerId: String = "my-drawer",
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
) {
    div {
        addClassNames("drawer")
        addClassNames(extraClasses)
        if (attrs != null) attrs()
        input {
            this.id = drawerId
            type = InputType.checkBox
            addClassNames("drawer-toggle")
        }
        content()
    }
}

fun FlowContent.daisyDrawerContent(
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
) {
    div {
        addClassNames("drawer-content")
        addClassNames(extraClasses)
        if (attrs != null) attrs()
        content()
    }
}

fun FlowContent.daisyDrawerSide(
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
) {
    div {
        addClassNames("drawer-side")
        addClassNames(extraClasses)
        if (attrs != null) attrs()
        content()
    }
}

fun FlowContent.daisyDrawerOverlay(
    drawerId: String = "my-drawer",
    extraClasses: String? = null,
    attrs: (LABEL.() -> Unit)? = null,
) {
    label {
        attributes["for"] = drawerId
        addClassNames("drawer-overlay")
        addClassNames(extraClasses)
        if (attrs != null) attrs()
    }
}

fun FlowContent.daisyDrawerButton(
    drawerId: String = "my-drawer",
    extraClasses: String? = null,
    attrs: (LABEL.() -> Unit)? = null,
    content: (LABEL.() -> Unit)? = null,
) {
    label {
        attributes["for"] = drawerId
        addClassNames("btn btn-square btn-ghost drawer-button")
        addClassNames(extraClasses)
        if (attrs != null) attrs()
        if (content != null) content()
    }
}
