# Divider

Visual separator between sections. Renders `<div class="divider ...">`.

```kotlin
// DividerVariant: Neutral | Primary | Secondary | Accent | Success | Warning | Info | Error
fun FlowContent.daisyDivider(
    variant: DividerVariant? = null,
    end: Boolean = false,
    horizontal: Boolean = false,
    start: Boolean = false,
    vertical: Boolean = false,
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```
