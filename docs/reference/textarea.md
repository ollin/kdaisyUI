# Textarea

Multi-line text input. Renders `<textarea class="textarea ...">`.

```kotlin
// TextareaVariant: Neutral | Primary | Secondary | Accent | Info | Success | Warning | Error, TextareaSize: Xs | Sm | Md | Lg | Xl
fun FlowContent.daisyTextarea(
    variant: TextareaVariant? = null,
    size: TextareaSize? = null,
    ghost: Boolean = false,
    extraClasses: String? = null,
    attrs: (TEXTAREA.() -> Unit)? = null,
    content: (TEXTAREA.() -> Unit),
)
```
