# Steps

[DaisyUI documentation →](https://daisyui.com/components/steps/)

Step-by-step progress indicator. Renders `<ul class="steps ...">`.

```kotlin
// StepsVariant: StepNeutral | StepPrimary | StepSecondary | StepAccent | StepInfo | StepSuccess | StepWarning | StepError
fun FlowContent.daisySteps(
    variant: StepsVariant? = null,
    horizontal: Boolean = false,
    vertical: Boolean = false,
    extraClasses: String? = null,
    attrs: (UL.() -> Unit)? = null,
    content: (UL.() -> Unit),
)
```

```kotlin
fun FlowContent.daisyStepsStep(
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```

```kotlin
fun FlowContent.daisyStepsStepIcon(
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```
