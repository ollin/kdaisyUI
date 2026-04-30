# Fab

[DaisyUI documentation →](https://daisyui.com/components/fab/)

Floating action button with expandable actions. Renders `<div class="fab ...">`.

```kotlin
fun FlowContent.daisyFab(
    flower: Boolean = false,
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```

```kotlin
fun FlowContent.daisyFabClose(
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```

```kotlin
fun FlowContent.daisyFabMainAction(
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```
