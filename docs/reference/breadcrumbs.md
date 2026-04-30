# Breadcrumbs

Navigation trail showing current location. Renders `<div class="breadcrumbs ...">`.

```kotlin
fun FlowContent.daisyBreadcrumbs(
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```
