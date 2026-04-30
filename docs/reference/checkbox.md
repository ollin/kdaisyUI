# Checkbox

Boolean toggles for forms. Renders `<input class="checkbox ...">`.

```kotlin
// CheckboxVariant: Primary | Secondary | Accent | Neutral | Success | Warning | Info | Error, CheckboxSize: Xs | Sm | Md | Lg | Xl
fun FlowContent.daisyCheckbox(
    variant: CheckboxVariant? = null,
    size: CheckboxSize? = null,
    checked: Boolean = false,
    disabled: Boolean = false,
    extraClasses: String? = null,
    attrs: (INPUT.() -> Unit)? = null,
)
```
