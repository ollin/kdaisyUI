# Alert

[DaisyUI documentation →](https://daisyui.com/components/alert/)

Status messages and notifications. Renders `<div class="alert ...">`.

```kotlin
// AlertVariant: Info | Success | Warning | Error
fun FlowContent.daisyAlert(
    variant: AlertVariant? = null,
    dash: Boolean = false,
    horizontal: Boolean = false,
    outline: Boolean = false,
    soft: Boolean = false,
    vertical: Boolean = false,
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```
