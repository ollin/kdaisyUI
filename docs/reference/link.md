# Link

[DaisyUI documentation →](https://daisyui.com/components/link/)

Styled anchor elements. Renders `<a class="link ...">`.

```kotlin
// LinkVariant: Neutral | Primary | Secondary | Accent | Success | Info | Warning | Error
fun FlowContent.daisyLink(
    text: String? = null,
    variant: LinkVariant? = null,
    hover: Boolean = false,
    extraClasses: String? = null,
    attrs: (A.() -> Unit)? = null,
    content: (A.() -> Unit)? = null,
)
```
