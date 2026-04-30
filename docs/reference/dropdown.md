# Dropdown

Context menus and action lists. Renders `<details class="dropdown ...">`.

```kotlin
fun FlowContent.daisyDropdown(
    close: Boolean = false,
    hover: Boolean = false,
    open: Boolean = false,
    end: Boolean = false,
    start: Boolean = false,
    top: Boolean = false,
    bottom: Boolean = false,
    left: Boolean = false,
    right: Boolean = false,
    center: Boolean = false,
    extraClasses: String? = null,
    attrs: (DETAILS.() -> Unit)? = null,
    content: (DETAILS.() -> Unit),
)
```

```kotlin
fun FlowContent.daisyDropdownContent(
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```
