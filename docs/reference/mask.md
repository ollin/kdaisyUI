# Mask

[DaisyUI documentation →](https://daisyui.com/components/mask/)

CSS masks for cropping images to shapes. Renders `<img class="mask ...">`.

```kotlin
fun FlowContent.daisyMask(
    circle: Boolean = false,
    decagon: Boolean = false,
    diamond: Boolean = false,
    half1: Boolean = false,
    half2: Boolean = false,
    heart: Boolean = false,
    hexagon: Boolean = false,
    hexagon2: Boolean = false,
    pentagon: Boolean = false,
    square: Boolean = false,
    squircle: Boolean = false,
    star: Boolean = false,
    star2: Boolean = false,
    triangle: Boolean = false,
    triangle2: Boolean = false,
    triangle3: Boolean = false,
    triangle4: Boolean = false,
    extraClasses: String? = null,
    attrs: (IMG.() -> Unit)? = null,
    content: (IMG.() -> Unit),
)
```
