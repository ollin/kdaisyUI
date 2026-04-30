# ThemeController

DaisyUI theme controller toggle. Renders `<input class="theme-controller ...">`.

```kotlin
fun FlowContent.daisyThemeController(
    extraClasses: String? = null,
    attrs: (INPUT.() -> Unit)? = null,
    content: (INPUT.() -> Unit),
)
```
