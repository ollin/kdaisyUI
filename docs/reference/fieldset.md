# Fieldset

Groups related form controls. Renders `<fieldset class="fieldset ...">`.

```kotlin
fun FlowContent.daisyFieldset(
    extraClasses: String? = null,
    attrs: (FIELDSET.() -> Unit)? = null,
    content: (FIELDSET.() -> Unit),
)
```

```kotlin
fun FlowContent.daisyFieldsetLegend(
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```
