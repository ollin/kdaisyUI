# Countdown

Timer countdown display. Renders `<span class="countdown ...">`.

```kotlin
fun FlowContent.daisyCountdown(
    extraClasses: String? = null,
    attrs: (SPAN.() -> Unit)? = null,
    content: (SPAN.() -> Unit),
)
```
