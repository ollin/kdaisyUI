# Card

[DaisyUI documentation →](https://daisyui.com/components/card/)

Content containers with body and title. Renders `<div class="card ...">`.

```kotlin
// CardSize: Xs | Sm | Md | Lg | Xl
fun FlowContent.daisyCard(
    size: CardSize? = null,
    border: Boolean = false,
    dash: Boolean = false,
    imageFull: Boolean = false,
    side: Boolean = false,
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```

```kotlin
fun FlowContent.daisyCardTitle(
    text: String? = null,
    extraClasses: String? = null,
    attrs: (H2.() -> Unit)? = null,
    content: (H2.() -> Unit)? = null,
)
```

```kotlin
fun FlowContent.daisyCardBody(
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```

```kotlin
fun FlowContent.daisyCardActions(
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```
