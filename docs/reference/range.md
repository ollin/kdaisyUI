# Range

Slider for numeric ranges. Renders `<input class="range ...">`.

```kotlin
// RangeVariant: Neutral | Primary | Secondary | Accent | Success | Warning | Info | Error, RangeSize: Xs | Sm | Md | Lg | Xl
fun FlowContent.daisyRange(
    variant: RangeVariant? = null,
    size: RangeSize? = null,
    min: String? = null,
    max: String? = null,
    value: String? = null,
    step: String? = null,
    disabled: Boolean = false,
    extraClasses: String? = null,
    attrs: (INPUT.() -> Unit)? = null,
)
```
