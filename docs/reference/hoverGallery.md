# HoverGallery

Gallery with hover effects. Renders `<figure class="hover-gallery ...">`.

```kotlin
fun FlowContent.daisyHoverGallery(
    extraClasses: String? = null,
    attrs: (FIGURE.() -> Unit)? = null,
    content: (FIGURE.() -> Unit),
)
```
