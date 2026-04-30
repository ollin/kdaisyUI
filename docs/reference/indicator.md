# Indicator

Overlays badges on elements. Renders `<div class="indicator ...">`.

```kotlin
fun FlowContent.daisyIndicator(
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

```kotlin
fun FlowContent.daisyIndicatorItem(
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```
