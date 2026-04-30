# Toggle

[DaisyUI documentation →](https://daisyui.com/components/toggle/)

Switch-style boolean input. Renders `<input class="toggle ...">`.

```kotlin
// ToggleVariant: Primary | Secondary | Accent | Neutral | Success | Warning | Info | Error, ToggleSize: Xs | Sm | Md | Lg | Xl
fun FlowContent.daisyToggle(
    variant: ToggleVariant? = null,
    size: ToggleSize? = null,
    checked: Boolean = false,
    disabled: Boolean = false,
    extraClasses: String? = null,
    attrs: (INPUT.() -> Unit)? = null,
)
```
