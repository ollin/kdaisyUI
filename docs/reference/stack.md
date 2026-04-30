# Stack

[DaisyUI documentation →](https://daisyui.com/components/stack/)

Stack overlapping elements. Renders `<div class="stack ...">`.

```kotlin
fun FlowContent.daisyStack(
    bottom: Boolean = false,
    end: Boolean = false,
    start: Boolean = false,
    top: Boolean = false,
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```
