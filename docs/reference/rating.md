# Rating

[DaisyUI documentation →](https://daisyui.com/components/rating/)

Star rating input. Renders `<div class="rating ...">`.

```kotlin
// RatingSize: Xs | Sm | Md | Lg | Xl
fun FlowContent.daisyRating(
    size: RatingSize? = null,
    half: Boolean = false,
    hidden: Boolean = false,
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```
