package kdaisyui.example.fragments

import kdaisyui.components.*
import kdaisyui.core.addClassNames
import kotlinx.html.*

fun TagConsumer<*>.cardsRow2Fragment() {
    sourcesCard()
    downloadsCard()
    visitorsCard()
}

private fun TagConsumer<*>.sourcesCard() {
    section {
        addClassNames("card bg-base-100 col-span-12 shadow-xs xl:col-span-4")
        daisyCardBody {
            daisyCardTitle("Sources")
            div("flex items-center gap-10") {
                div("grow") {
                    for ((color, label) in listOf(
                        "#19D6BF" to "Direct",
                        "#A838FF" to "Social",
                        "#3C37FF" to "Search",
                        "#FFBD3C" to "Email",
                    )) {
                        div("flex items-center gap-2") {
                            daisyBadge(size = BadgeSize.Xs, extraClasses = "bg-[$color]")
                            +label
                        }
                    }
                }
                div("h-32 w-32 shrink-0") { +"[Pie chart]" }
            }
        }
    }
}

private fun TagConsumer<*>.downloadsCard() {
    section {
        addClassNames("card bg-base-100 col-span-12 shadow-xs xl:col-span-4")
        daisyCardBody(extraClasses = "pb-0") {
            daisyCardTitle("19,000")
            p { +"Downloads" }
        }
        div("rounded-box h-full w-full p-4") { +"[Line chart]" }
    }
}

private fun TagConsumer<*>.visitorsCard() {
    section {
        addClassNames("card bg-base-100 col-span-12 shadow-xs xl:col-span-4")
        daisyCardBody(extraClasses = "pb-0") {
            daisyCardTitle("32,800")
            p { +"Unique visitors" }
        }
        div("rounded-box h-full w-full p-4") { +"[Line chart]" }
    }
}
