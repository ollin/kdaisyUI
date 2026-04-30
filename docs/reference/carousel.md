# Carousel

[DaisyUI documentation →](https://daisyui.com/components/carousel/)

Slideshow of images or content. Renders `<div class="carousel ...">`.

```kotlin
fun FlowContent.daisyCarousel(
    center: Boolean = false,
    end: Boolean = false,
    horizontal: Boolean = false,
    start: Boolean = false,
    vertical: Boolean = false,
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```

```kotlin
fun FlowContent.daisyCarouselItem(
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```
