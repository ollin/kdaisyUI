# Skeleton

Content placeholder loading indicator. Renders `<div class="skeleton ...">`.

```kotlin
fun FlowContent.daisySkeleton(
    text: Boolean = false,
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```
