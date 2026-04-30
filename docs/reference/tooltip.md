# Tooltip

Hover tooltip on elements. Renders `<div class="tooltip ...">`.

```kotlin
// TooltipVariant: Neutral | Primary | Secondary | Accent | Info | Success | Warning | Error
fun FlowContent.daisyTooltip(
    variant: TooltipVariant? = null,
    bottom: Boolean = false,
    left: Boolean = false,
    open: Boolean = false,
    right: Boolean = false,
    top: Boolean = false,
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```

```kotlin
fun FlowContent.daisyTooltipContent(
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```
