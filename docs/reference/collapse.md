# Collapse

[DaisyUI documentation →](https://daisyui.com/components/collapse/)

Collapsible content sections. Renders `<div class="collapse ...">`.

```kotlin
fun FlowContent.daisyCollapse(
    arrow: Boolean = false,
    close: Boolean = false,
    open: Boolean = false,
    plus: Boolean = false,
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```

```kotlin
fun FlowContent.daisyCollapseTitle(
    text: String? = null,
    extraClasses: String? = null,
    attrs: (H2.() -> Unit)? = null,
    content: (H2.() -> Unit)? = null,
)
```

```kotlin
fun FlowContent.daisyCollapseContent(
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```
