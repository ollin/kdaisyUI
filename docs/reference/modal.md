# Modal

[DaisyUI documentation →](https://daisyui.com/components/modal/)

Modal dialogs. Renders `<dialog class="modal ...">`.

```kotlin
fun FlowContent.daisyModal(
    bottom: Boolean = false,
    end: Boolean = false,
    middle: Boolean = false,
    open: Boolean = false,
    start: Boolean = false,
    top: Boolean = false,
    extraClasses: String? = null,
    attrs: (DIALOG.() -> Unit)? = null,
    content: (DIALOG.() -> Unit),
)
```

```kotlin
fun FlowContent.daisyModalBox(
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```

```kotlin
fun FlowContent.daisyModalAction(
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```

```kotlin
fun FlowContent.daisyModalBackdrop(
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```

```kotlin
fun FlowContent.daisyModalToggle(
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```
