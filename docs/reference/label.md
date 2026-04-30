# Label

Field labels and helper text. Renders `<span class="label ...">`.

```kotlin
fun FlowContent.daisyLabel(
    text: String? = null,
    extraClasses: String? = null,
    attrs: (SPAN.() -> Unit)? = null,
    content: (SPAN.() -> Unit)? = null,
)
```
