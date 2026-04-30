# MockupBrowser

Browser window mockup frame. Renders `<div class="mockup-browser ...">`.

```kotlin
fun FlowContent.daisyMockupBrowser(
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```

```kotlin
fun FlowContent.daisyMockupBrowserToolbar(
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```
