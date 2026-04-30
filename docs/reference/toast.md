# Toast

[DaisyUI documentation →](https://daisyui.com/components/toast/)

Toast notification container. Renders `<div class="toast ...">`.

```kotlin
fun FlowContent.daisyToast(
    bottom: Boolean = false,
    center: Boolean = false,
    end: Boolean = false,
    middle: Boolean = false,
    start: Boolean = false,
    top: Boolean = false,
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```
