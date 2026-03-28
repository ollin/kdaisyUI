package kdaisyui.example.fragments

import kdaisyui.components.*
import kdaisyui.core.addClassNames
import kotlinx.html.*

fun TagConsumer<*>.formsFragment() {
    formsHeader()
    formInputsSection()
    worldMapCard()
    recentEventsCard()
}

private fun TagConsumer<*>.formsHeader() {
    header {
        addClassNames("col-span-12 flex items-center gap-2 lg:gap-4")
        div("grow") { h1("font-light lg:text-2xl") { +"Forms and inputs" } }
    }
}

private fun TagConsumer<*>.formInputsSection() {
    section {
        addClassNames("col-span-12 xl:col-span-4")
        daisyFieldset {
            daisyLabel("Product name")
            daisyInput(placeholder = "Type here", extraClasses = "w-full")
        }
        daisyFieldset {
            daisyLabel("Category")
            daisySelect(extraClasses = "w-full") {
                option { disabled = true; selected = true; +"Pick" }
                option { +"T-shirts" }
                option { +"Dresses" }
                option { +"Hats" }
                option { +"Accessories" }
            }
        }
        daisyFieldset {
            daisyLabel("Size (cm)")
            div("flex items-center gap-2") {
                daisyInput(placeholder = "Width", extraClasses = "w-1/2")
                +"×"
                daisyInput(placeholder = "Height", extraClasses = "w-1/2")
            }
        }
        hr("border-base-content/5 my-6 border-t-2") {}
        daisyFieldset {
            label("flex cursor-pointer justify-between py-2") {
                span("label") { +"Visible only for managers" }
                daisyRadio(name = "visibility", size = RadioSize.Sm, checked = true)
            }
            label("flex cursor-pointer justify-between py-2") {
                span("label") { +"Visible for all users" }
                daisyRadio(name = "visibility", size = RadioSize.Sm)
            }
        }
    }
}

private fun TagConsumer<*>.worldMapCard() {
    section {
        addClassNames("card bg-base-100 col-span-12 shadow-xs xl:col-span-5")
        daisyCardBody(extraClasses = "pb-0") {
            daisyCardTitle("32,800")
            p { +"From 84 countries" }
        }
        div("fill-base-content/80 m-4 flex items-center justify-center h-48") { +"[World map]" }
    }
}

private fun TagConsumer<*>.recentEventsCard() {
    section {
        addClassNames("card bg-base-100 col-span-12 shadow-xs xl:col-span-3")
        div("text-base-content/60 p-6 pb-0 text-center text-xs font-bold") { +"Recent events" }
        daisyMenu(extraClasses = "w-full") {
            for ((idx, event) in listOf(
                "New User" to "2 minutes ago",
                "New product added" to "1 hour ago",
                "Database update" to "1 hour ago",
                "Newsletter sent" to "2 hour ago",
                "New User" to "2 hours ago",
            ).withIndex()) {
                li {
                    a("gap-4") {
                        daisyAvatar {
                            div("w-6 rounded-full") {
                                img(src = "https://picsum.photos/80/80?${idx + 6}")
                            }
                        }
                        span("text-xs") { b { +event.first }; br; +event.second }
                    }
                }
            }
        }
    }
}
