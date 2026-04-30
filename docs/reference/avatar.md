# Avatar

User and entity representations. Renders `<div class="avatar ...">`.

```kotlin
fun FlowContent.daisyAvatar(
    offline: Boolean = false,
    online: Boolean = false,
    placeholder: Boolean = false,
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```
