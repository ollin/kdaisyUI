package kdaisyui.components

import kdaisyui.core.addClassNames
import kotlinx.html.FlowContent
import kotlinx.html.TABLE
import kotlinx.html.table

fun FlowContent.daisyTable(
    zebra: Boolean = false,
    pin: Boolean = false,
    extraClasses: String? = null,
    attrs: (TABLE.() -> Unit)? = null,
    content: (TABLE.() -> Unit),
) {
    table {
        addClassNames("table")
        if (zebra) addClassNames("table-zebra")
        if (pin) addClassNames("table-pin-rows")
        addClassNames(extraClasses)
        if (attrs != null) attrs()
        content()
    }
}
