# Badge

Labels, counts, and status tags. Renders `<span class="badge ...">`.

```kotlin
// BadgeVariant: Neutral | Primary | Secondary | Accent | Info | Success | Warning | Error, BadgeSize: Xs | Sm | Md | Lg | Xl
fun FlowContent.daisyBadge(
    text: String? = null,
    variant: BadgeVariant? = null,
    size: BadgeSize? = null,
    dash: Boolean = false,
    ghost: Boolean = false,
    outline: Boolean = false,
    soft: Boolean = false,
    extraClasses: String? = null,
    attrs: (SPAN.() -> Unit)? = null,
    content: (SPAN.() -> Unit)? = null,
)
```
