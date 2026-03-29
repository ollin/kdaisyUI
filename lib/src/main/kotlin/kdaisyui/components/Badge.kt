package kdaisyui.components

import kdaisyui.core.addClassNames
import kotlinx.html.FlowContent
import kotlinx.html.SPAN
import kotlinx.html.span

enum class BadgeVariant(internal val className: String) {
    Neutral("badge-neutral"),
    Primary("badge-primary"),
    Secondary("badge-secondary"),
    Accent("badge-accent"),
    Ghost("badge-ghost"),
    Info("badge-info"),
    Success("badge-success"),
    Warning("badge-warning"),
    Error("badge-error"),
}

enum class BadgeSize(internal val className: String) {
    Xs("badge-xs"),
    Sm("badge-sm"),
    Md("badge-md"),
    Lg("badge-lg"),
}

fun FlowContent.daisyBadge(
    text: String? = null,
    variant: BadgeVariant? = null,
    size: BadgeSize? = null,
    outline: Boolean = false,
    extraClasses: String? = null,
    attrs: (SPAN.() -> Unit)? = null,
    content: (SPAN.() -> Unit)? = null,
) {
    span {
        addClassNames("badge")
        if (variant != null) addClassNames(variant.className)
        if (size != null) addClassNames(size.className)
        if (outline) addClassNames("badge-outline")
        addClassNames(extraClasses)

        if (attrs != null) attrs()

        when {
            content != null -> content()
            text != null -> +text
        }
    }
}
