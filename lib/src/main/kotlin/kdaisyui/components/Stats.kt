package kdaisyui.components

import kdaisyui.core.addClassNames
import kotlinx.html.DIV
import kotlinx.html.FlowContent
import kotlinx.html.div

fun FlowContent.daisyStats(
    vertical: Boolean = false,
    horizontal: Boolean = false,
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
) {
    div {
        addClassNames("stats")
        if (vertical) addClassNames("stats-vertical")
        if (horizontal) addClassNames("stats-horizontal")
        addClassNames(extraClasses)
        if (attrs != null) attrs()
        content()
    }
}

fun FlowContent.daisyStat(
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
) {
    div {
        addClassNames("stat")
        addClassNames(extraClasses)
        if (attrs != null) attrs()
        content()
    }
}

fun FlowContent.daisyStatTitle(
    text: String,
    extraClasses: String? = null,
) {
    div {
        addClassNames("stat-title")
        addClassNames(extraClasses)
        +text
    }
}

fun FlowContent.daisyStatValue(
    text: String,
    extraClasses: String? = null,
) {
    div {
        addClassNames("stat-value")
        addClassNames(extraClasses)
        +text
    }
}

fun FlowContent.daisyStatDesc(
    text: String,
    extraClasses: String? = null,
) {
    div {
        addClassNames("stat-desc")
        addClassNames(extraClasses)
        +text
    }
}
