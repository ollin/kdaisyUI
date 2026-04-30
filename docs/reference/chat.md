# Chat

Chat bubble layout for conversations. Renders `<div class="chat ...">`.

```kotlin
// ChatVariant: BubbleNeutral | BubblePrimary | BubbleSecondary | BubbleAccent | BubbleInfo | BubbleSuccess | BubbleWarning | BubbleError
fun FlowContent.daisyChat(
    variant: ChatVariant? = null,
    end: Boolean = false,
    start: Boolean = false,
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```

```kotlin
fun FlowContent.daisyChatImage(
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```

```kotlin
fun FlowContent.daisyChatHeader(
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```

```kotlin
fun FlowContent.daisyChatFooter(
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```

```kotlin
fun FlowContent.daisyChatBubble(
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```
