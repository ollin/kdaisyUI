# Filter

Filter reset for search and forms. Renders `<form class="filter ...">`.

```kotlin
fun FlowContent.daisyFilter(
    extraClasses: String? = null,
    attrs: (FORM.() -> Unit)? = null,
    content: (FORM.() -> Unit),
)
```

```kotlin
fun FlowContent.daisyFilterReset(
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```
