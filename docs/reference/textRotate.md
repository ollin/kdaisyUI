# TextRotate

Rotated text display. Renders `<span class="text-rotate ...">`.

```kotlin
fun FlowContent.daisyTextRotate(
    extraClasses: String? = null,
    attrs: (SPAN.() -> Unit)? = null,
    content: (SPAN.() -> Unit),
)
```
