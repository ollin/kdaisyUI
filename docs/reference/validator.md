# Validator

Form validation wrapper. Renders `<input class="validator ...">`.

```kotlin
fun FlowContent.daisyValidator(
    extraClasses: String? = null,
    attrs: (INPUT.() -> Unit)? = null,
    content: (INPUT.() -> Unit),
)
```

```kotlin
fun FlowContent.daisyValidatorHint(
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```
