# Table

Structured data in rows and columns. Renders `<table class="table ...">`.

```kotlin
// TableSize: Xs | Sm | Md | Lg | Xl
fun FlowContent.daisyTable(
    size: TableSize? = null,
    pinCols: Boolean = false,
    pinRows: Boolean = false,
    zebra: Boolean = false,
    extraClasses: String? = null,
    attrs: (TABLE.() -> Unit)? = null,
    content: (TABLE.() -> Unit),
)
```
