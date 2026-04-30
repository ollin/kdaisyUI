# Button

[DaisyUI documentation →](https://daisyui.com/components/button/)

Actions and triggers. Renders `<button class="button ...">`.

```kotlin
// ButtonVariant: Neutral | Primary | Secondary | Accent | Info | Success | Warning | Error, ButtonSize: Xs | Sm | Md | Lg | Xl
fun FlowContent.daisyButton(
    text: String? = null,
    variant: ButtonVariant? = null,
    size: ButtonSize? = null,
    active: Boolean = false,
    block: Boolean = false,
    circle: Boolean = false,
    dash: Boolean = false,
    ghost: Boolean = false,
    link: Boolean = false,
    outline: Boolean = false,
    soft: Boolean = false,
    square: Boolean = false,
    wide: Boolean = false,
    disabled: Boolean = false,
    type: ButtonType? = null,
    extraClasses: String? = null,
    attrs: (BUTTON.() -> Unit)? = null,
    content: (BUTTON.() -> Unit)? = null,
)
```
