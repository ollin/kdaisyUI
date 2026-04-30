# Progress

Progress bar indicator. Renders `<progress class="progress ...">`.

```kotlin
// ProgressVariant: Neutral | Primary | Secondary | Accent | Info | Success | Warning | Error
fun FlowContent.daisyProgress(
    variant: ProgressVariant? = null,
    extraClasses: String? = null,
    attrs: (PROGRESS.() -> Unit)? = null,
    content: (PROGRESS.() -> Unit),
)
```
