# MockupWindow

Desktop window mockup frame. Renders `<div class="mockup-window ...">`.

```kotlin
fun FlowContent.daisyMockupWindow(
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```
