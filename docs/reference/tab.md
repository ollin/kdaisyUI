# Tab

[DaisyUI documentation →](https://daisyui.com/components/tab/)

Tabbed navigation. Renders `<button class="tab ...">`.

```kotlin
// TabSize: Xs | Sm | Md | Lg | Xl
fun FlowContent.daisyTab(
    size: TabSize? = null,
    border: Boolean = false,
    bottom: Boolean = false,
    box: Boolean = false,
    lift: Boolean = false,
    tabActive: Boolean = false,
    tabDisabled: Boolean = false,
    top: Boolean = false,
    extraClasses: String? = null,
    attrs: (BUTTON.() -> Unit)? = null,
    content: (BUTTON.() -> Unit),
)
```

```kotlin
fun FlowContent.daisyTabTab(
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```

```kotlin
fun FlowContent.daisyTabTabContent(
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```
