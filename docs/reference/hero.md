# Hero

[DaisyUI documentation →](https://daisyui.com/components/hero/)

Hero banner with overlay. Renders `<div class="hero ...">`.

```kotlin
fun FlowContent.daisyHero(
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```

```kotlin
fun FlowContent.daisyHeroContent(
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```

```kotlin
fun FlowContent.daisyHeroOverlay(
    extraClasses: String? = null,
    attrs: (LABEL.() -> Unit)? = null,
    content: (LABEL.() -> Unit),
)
```
