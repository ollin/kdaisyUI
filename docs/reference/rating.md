# Rating

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
