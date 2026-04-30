# Status

Small status indicator dot. Renders `<span class="status ...">`.

```kotlin
// StatusVariant: Neutral | Primary | Secondary | Accent | Info | Success | Warning | Error, StatusSize: Xs | Sm | Md | Lg | Xl
fun FlowContent.daisyStatus(
    variant: StatusVariant? = null,
    size: StatusSize? = null,
    extraClasses: String? = null,
    attrs: (SPAN.() -> Unit)? = null,
    content: (SPAN.() -> Unit),
)
```
