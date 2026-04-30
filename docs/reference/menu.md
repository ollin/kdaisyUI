# Menu

[DaisyUI documentation →](https://daisyui.com/components/menu/)

Navigation lists with submenus. Renders `<ul class="menu ...">`.

```kotlin
// MenuSize: Xs | Sm | Md | Lg | Xl
fun FlowContent.daisyMenu(
    size: MenuSize? = null,
    active: Boolean = false,
    disabled: Boolean = false,
    dropdownShow: Boolean = false,
    focus: Boolean = false,
    horizontal: Boolean = false,
    vertical: Boolean = false,
    extraClasses: String? = null,
    attrs: (UL.() -> Unit)? = null,
    content: (UL.() -> Unit),
)
```

```kotlin
fun FlowContent.daisyMenuTitle(
    text: String? = null,
    extraClasses: String? = null,
    attrs: (H2.() -> Unit)? = null,
    content: (H2.() -> Unit)? = null,
)
```

```kotlin
fun FlowContent.daisyMenuDropdown(
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```

```kotlin
fun FlowContent.daisyMenuDropdownToggle(
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```
