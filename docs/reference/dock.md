# Dock

macOS-style dock navigation. Renders `<div class="dock ...">`.

```kotlin
// DockSize: Xs | Sm | Md | Lg | Xl
fun FlowContent.daisyDock(
    size: DockSize? = null,
    active: Boolean = false,
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```

```kotlin
fun FlowContent.daisyDockLabel(
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```
