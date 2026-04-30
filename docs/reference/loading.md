# Loading

Loading spinners and indicators. Renders `<span class="loading ...">`.

```kotlin
// LoadingSize: Xs | Sm | Md | Lg | Xl
fun FlowContent.daisyLoading(
    size: LoadingSize? = null,
    ball: Boolean = false,
    bars: Boolean = false,
    dots: Boolean = false,
    infinity: Boolean = false,
    ring: Boolean = false,
    spinner: Boolean = false,
    extraClasses: String? = null,
    attrs: (SPAN.() -> Unit)? = null,
    content: (SPAN.() -> Unit),
)
```
