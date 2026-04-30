# Footer

[DaisyUI documentation →](https://daisyui.com/components/footer/)

Page footer layout. Renders `<footer class="footer ...">`.

```kotlin
fun FlowContent.daisyFooter(
    center: Boolean = false,
    horizontal: Boolean = false,
    vertical: Boolean = false,
    extraClasses: String? = null,
    attrs: (FOOTER.() -> Unit)? = null,
    content: (FOOTER.() -> Unit),
)
```

```kotlin
fun FlowContent.daisyFooterTitle(
    text: String? = null,
    extraClasses: String? = null,
    attrs: (H2.() -> Unit)? = null,
    content: (H2.() -> Unit)? = null,
)
```
