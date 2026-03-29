# Component reference

All components live in `kdaisyui.components` and are extension functions on `FlowContent`.

```kotlin
import kdaisyui.components.*
```

## Common parameters

Every component supports these escape-hatch parameters:

| Parameter | Type | Description |
|---|---|---|
| `extraClasses` | `String?` | Additional CSS classes (merged safely, no duplicates) |
| `attrs` | `(TAG.() -> Unit)?` | Raw kotlinx.html attribute access |
| `content` | `(TAG.() -> Unit)?` | Nested HTML content |

## Modules

| Module | Artifact | Description |
|---|---|---|
| `:lib` | `kdaisyui` | Core DSL library |
| `:example-app` | — | Ktor + htmx demo dashboard |

## Requirements

- JDK: **21** (auto-downloaded via Gradle toolchain — see [`buildSrc/src/main/kotlin/kdaisyui.kotlin-library-conventions.gradle.kts`](../buildSrc/src/main/kotlin/kdaisyui.kotlin-library-conventions.gradle.kts))
- Kotlin: see [`gradle.properties`](../gradle.properties) → `versions.kotlin`
- kotlinx-html: see [`gradle.properties`](../gradle.properties) → `versions.kotlinx-html`

---

## Alert

```kotlin
fun FlowContent.daisyAlert(
    variant: AlertVariant? = null,
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```

Renders `<div role="alert" class="alert ...">`. Variants: `Info`, `Success`, `Warning`, `Error`.

```kotlin
daisyAlert(variant = AlertVariant.Success) {
    span { +"Operation complete" }
}
```

## Avatar

```kotlin
fun FlowContent.daisyAvatar(
    extraClasses: String? = null,
    attrs: (DIV.() -> Unit)? = null,
    content: (DIV.() -> Unit),
)
```

Renders `<div class="avatar">`. Add inner structure for shape/size:

```kotlin
daisyAvatar {
    div("w-10 rounded-full") { img(src = "/photo.jpg") }
}
```

## Badge

```kotlin
fun FlowContent.daisyBadge(
    text: String? = null,
    variant: BadgeVariant? = null,
    size: BadgeSize? = null,
    outline: Boolean = false,
    extraClasses: String? = null,
    attrs: (SPAN.() -> Unit)? = null,
    content: (SPAN.() -> Unit)? = null,
)
```

Renders `<span class="badge ...">`. Variants: `Neutral`, `Primary`, `Secondary`, `Accent`, `Ghost`, `Info`, `Success`, `Warning`, `Error`. Sizes: `Xs`, `Sm`, `Md`, `Lg`.

```kotlin
daisyBadge("New", variant = BadgeVariant.Success, size = BadgeSize.Sm)
```

## Button

```kotlin
fun FlowContent.daisyButton(
    text: String? = null,
    variant: ButtonVariant? = null,
    size: ButtonSize? = null,
    outline: Boolean = false,
    wide: Boolean = false,
    block: Boolean = false,
    circle: Boolean = false,
    square: Boolean = false,
    disabled: Boolean = false,
    type: ButtonType? = null,
    extraClasses: String? = null,
    attrs: (BUTTON.() -> Unit)? = null,
    content: (BUTTON.() -> Unit)? = null,
)
```

Renders `<button class="btn ...">`. Variants: `Neutral`, `Primary`, `Secondary`, `Accent`, `Ghost`, `Link`, `Info`, `Success`, `Warning`, `Error`. Sizes: `Xs`, `Sm`, `Md`, `Lg`.

```kotlin
daisyButton("Save", variant = ButtonVariant.Primary, size = ButtonSize.Lg)
```

## Card

```kotlin
fun FlowContent.daisyCard(extraClasses, attrs, content: (DIV.() -> Unit))
fun FlowContent.daisyCardBody(extraClasses, attrs, content: (DIV.() -> Unit))
fun FlowContent.daisyCardTitle(text?, extraClasses, attrs, content: (H2.() -> Unit)?)
```

Renders `<div class="card">`, `<div class="card-body">`, `<h2 class="card-title">`.

```kotlin
daisyCard(extraClasses = "bg-base-100 shadow-xs") {
    daisyCardBody {
        daisyCardTitle("Revenue")
        p { +"Monthly report" }
    }
}
```

## Checkbox

```kotlin
fun FlowContent.daisyCheckbox(
    size: CheckboxSize? = null,
    checked: Boolean = false,
    disabled: Boolean = false,
    extraClasses: String? = null,
    attrs: (INPUT.() -> Unit)? = null,
)
```

Renders `<input type="checkbox" class="checkbox ...">`. Sizes: `Xs`, `Sm`, `Md`, `Lg`.

```kotlin
daisyCheckbox(size = CheckboxSize.Sm, checked = true)
```

## Drawer

```kotlin
fun FlowContent.daisyDrawer(drawerId = "my-drawer", extraClasses, attrs, content: (DIV.() -> Unit))
fun FlowContent.daisyDrawerContent(extraClasses, attrs, content: (DIV.() -> Unit))
fun FlowContent.daisyDrawerSide(extraClasses, attrs, content: (DIV.() -> Unit))
fun FlowContent.daisyDrawerOverlay(drawerId = "my-drawer", extraClasses, attrs)
fun FlowContent.daisyDrawerButton(drawerId = "my-drawer", extraClasses, attrs, content)
```

`daisyDrawer` renders `<div class="drawer">` with a hidden `<input type="checkbox">` toggle. Use `daisyDrawerContent` for the main area and `daisyDrawerSide` for the sidebar.

## Dropdown

```kotlin
fun FlowContent.daisyDropdown(
    end: Boolean = false,
    top: Boolean = false,
    left: Boolean = false,
    right: Boolean = false,
    hover: Boolean = false,
    open: Boolean = false,
    extraClasses, attrs, content: (DIV.() -> Unit),
)
fun FlowContent.daisyDropdownContent(extraClasses, attrs, content: (UL.() -> Unit))
```

Renders `<div class="dropdown ...">`. `daisyDropdownContent` renders `<ul class="menu dropdown-content">`.

```kotlin
daisyDropdown(end = true) {
    div { attributes["tabindex"] = "0"; classes = setOf("btn"); +"Open" }
    daisyDropdownContent(extraClasses = "rounded-box bg-base-100 p-2 shadow-xl") {
        attributes["tabindex"] = "0"
        li { a { +"Item 1" } }
    }
}
```

## Fieldset

```kotlin
fun FlowContent.daisyFieldset(extraClasses, attrs, content: (FIELDSET.() -> Unit))
```

Renders `<fieldset class="fieldset">`.

## Indicator

```kotlin
fun FlowContent.daisyIndicator(extraClasses, attrs, content: (DIV.() -> Unit))
```

Renders `<div class="indicator">`. Combine with a badge using `extraClasses = "indicator-item"`.

## Input

```kotlin
fun FlowContent.daisyInput(
    type: InputType = InputType.text,
    size: InputSize? = null,
    ghost: Boolean = false,
    bordered: Boolean = false,
    placeholder: String? = null,
    disabled: Boolean = false,
    extraClasses: String? = null,
    attrs: (INPUT.() -> Unit)? = null,
)
```

Renders `<input class="input ...">`. Sizes: `Xs`, `Sm`, `Md`, `Lg`.

```kotlin
daisyInput(size = InputSize.Sm, placeholder = "Search", extraClasses = "w-full")
```

## Join

```kotlin
fun FlowContent.daisyJoin(vertical: Boolean = false, extraClasses, attrs, content: (DIV.() -> Unit))
```

Renders `<div class="join">`. Add `join-item` via `extraClasses` to child elements.

```kotlin
daisyJoin {
    daisyButton("A", extraClasses = "join-item")
    daisyButton("B", extraClasses = "join-item")
}
```

## Label

```kotlin
fun FlowContent.daisyLabel(text?, extraClasses, attrs, content: (LABEL.() -> Unit)?)
fun FlowContent.daisyLabelText(text: String, extraClasses?)
```

`daisyLabel` renders `<label class="label">`. `daisyLabelText` renders `<span class="label-text">`.

## Link

```kotlin
fun FlowContent.daisyLink(
    text: String? = null,
    href: String? = null,
    hover: Boolean = false,
    extraClasses, attrs, content: (A.() -> Unit)?,
)
```

Renders `<a class="link ...">`.

```kotlin
daisyLink("View report", hover = true, href = "/reports")
```

## Menu

```kotlin
fun FlowContent.daisyMenu(extraClasses, attrs, content: (UL.() -> Unit))
```

Renders `<ul class="menu">`. Items are standard `li { a { } }`.

```kotlin
daisyMenu(extraClasses = "w-full") {
    li { a("menu-active") { +"Home" } }
    li { a { +"About" } }
}
```

## Radio

```kotlin
fun FlowContent.daisyRadio(
    name: String? = null,
    size: RadioSize? = null,
    checked: Boolean = false,
    disabled: Boolean = false,
    extraClasses, attrs,
)
```

Renders `<input type="radio" class="radio ...">`. Sizes: `Xs`, `Sm`, `Md`, `Lg`.

## Range

```kotlin
fun FlowContent.daisyRange(
    size: RangeSize? = null,
    min: String? = null,
    max: String? = null,
    value: String? = null,
    step: String? = null,
    disabled: Boolean = false,
    extraClasses, attrs,
)
```

Renders `<input type="range" class="range ...">`. Sizes: `Xs`, `Sm`, `Md`, `Lg`.

## Select

```kotlin
fun FlowContent.daisySelect(
    size: SelectSize? = null,
    ghost: Boolean = false,
    bordered: Boolean = false,
    disabled: Boolean = false,
    extraClasses, attrs,
    content: (SELECT.() -> Unit),
)
```

Renders `<select class="select ...">`. Sizes: `Xs`, `Sm`, `Md`, `Lg`.

```kotlin
daisySelect(extraClasses = "w-full") {
    option { +"Option A" }
    option { +"Option B" }
}
```

## Stats

```kotlin
fun FlowContent.daisyStats(vertical?, horizontal?, extraClasses, attrs, content: (DIV.() -> Unit))
fun FlowContent.daisyStat(extraClasses, attrs, content: (DIV.() -> Unit))
fun FlowContent.daisyStatTitle(text: String, extraClasses?)
fun FlowContent.daisyStatValue(text: String, extraClasses?)
fun FlowContent.daisyStatDesc(text: String, extraClasses?)
```

`daisyStats` renders `<div class="stats">`. Each `daisyStat` renders `<div class="stat">` with title/value/desc sub-components.

```kotlin
daisyStats(horizontal = true) {
    daisyStat {
        daisyStatTitle("Revenue")
        daisyStatValue("$34,000")
        daisyStatDesc("8% increase")
    }
}
```

## Swap

```kotlin
fun FlowContent.daisySwap(
    rotate: Boolean = false,
    flip: Boolean = false,
    extraClasses, attrs,
    content: (LABEL.() -> Unit),
)
```

Renders `<label class="swap ...">`. Add `swap-on` / `swap-off` children.

```kotlin
daisySwap(rotate = true) {
    span("swap-on") { +"ON" }
    span("swap-off") { +"OFF" }
}
```

## Table

```kotlin
fun FlowContent.daisyTable(
    zebra: Boolean = false,
    pin: Boolean = false,
    extraClasses, attrs,
    content: (TABLE.() -> Unit),
)
```

Renders `<table class="table ...">`. Use standard kotlinx.html `thead`, `tbody`, `tr`, `td`.

```kotlin
daisyTable(zebra = true) {
    tbody {
        tr { td { +"Alice" }; td { +"$200" } }
        tr { td { +"Bob" }; td { +"$150" } }
    }
}
```

## Toggle

```kotlin
fun FlowContent.daisyToggle(
    size: ToggleSize? = null,
    checked: Boolean = false,
    disabled: Boolean = false,
    extraClasses, attrs,
)
```

Renders `<input type="checkbox" class="toggle ...">`. Sizes: `Xs`, `Sm`, `Md`, `Lg`.

```kotlin
label("flex cursor-pointer justify-between") {
    span("label") { +"Dark mode" }
    daisyToggle(size = ToggleSize.Sm)
}
```

---

## Core utilities

### `addClassNames` (`kdaisyui.core`)

```kotlin
fun Tag.addClassNames(vararg classNames: String)
fun Tag.addClassNames(classNames: String?)
```

Safely merges CSS class tokens into the `class` attribute. Handles null, blank, whitespace, and deduplication. Used internally by all components. Available for use in raw kotlinx.html:

```kotlin
div {
    addClassNames("flex", "items-center", "gap-2")
}
```
