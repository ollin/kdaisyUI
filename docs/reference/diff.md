# Diff

[DaisyUI documentation →](https://daisyui.com/components/diff/)

Side-by-side diff viewer. Renders `<figure class="diff ...">`.

```kotlin
fun FlowContent.daisyDiff(
    extraClasses: String? = null,
    attrs: (FIGURE.() -> Unit)? = null,
    content: (FIGURE.() -> Unit),
)
```

```kotlin
fun FlowContent.daisyDiffItem1(
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```

```kotlin
fun FlowContent.daisyDiffItem2(
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```

```kotlin
fun FlowContent.daisyDiffResizer(
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```
