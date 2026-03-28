package kdaisyui.example.fragments

import kdaisyui.components.*
import kdaisyui.core.addClassNames
import kotlinx.html.*

fun TagConsumer<*>.formSectionsFragment() {
    formSectionsHeader()
    productManagement()
    productForm()
    sizeAndRange()
}

private fun TagConsumer<*>.formSectionsHeader() {
    header {
        addClassNames("col-span-12 flex items-center gap-2 lg:gap-4")
        div("grow") { h1("font-light lg:text-2xl") { +"Form sections" } }
    }
}

private fun TagConsumer<*>.productManagement() {
    section {
        addClassNames("col-span-12 xl:col-span-4")
        daisyLabel { span("label-text") { +"Product management" } }
        ul("flex flex-col gap-4 p-1") {
            for ((id, name, color, price) in listOf(
                Item(1, "Portable fidget spinner", "Space Gray", "$299"),
                Item(2, "Wooden VR holder", "Casual Red", "$199"),
                Item(3, "Portable keychain", "Normal Yellow", "$299"),
            )) {
                li("flex items-start gap-4") {
                    img(classes = "rounded-field h-14 w-14 shrink-0", src = "https://picsum.photos/80/80?id=$id", alt = "Product") {
                        width = "56"; height = "56"
                    }
                    div("flex grow flex-col gap-1") {
                        div("text-sm") { +name }
                        div("text-base-content/50 text-xs") { +color }
                        div("text-base-content/50 font-mono text-xs") { +price }
                    }
                    daisyJoin(extraClasses = "bg-base-100 justify-self-end") {
                        daisyButton("–", variant = ButtonVariant.Ghost, size = ButtonSize.Xs, extraClasses = "join-item")
                        daisyInput(ghost = true, size = InputSize.Xs, extraClasses = "join-item w-10 text-center") { value = "1" }
                        daisyButton("+", variant = ButtonVariant.Ghost, size = ButtonSize.Xs, extraClasses = "join-item")
                    }
                }
            }
        }
    }
}

private fun TagConsumer<*>.productForm() {
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
            label("flex cursor-pointer justify-between py-2") {
                span("label") { +"Public" }
                daisyToggle(size = ToggleSize.Sm, checked = true)
            }
        }
        daisyFieldset {
            label("flex cursor-pointer justify-between py-2") {
                span("label") { +"Featured product" }
                daisyToggle(size = ToggleSize.Sm, checked = true)
            }
        }
    }
}

private fun TagConsumer<*>.sizeAndRange() {
    section {
        addClassNames("col-span-12 xl:col-span-4")
        daisyFieldset {
            daisyLabel("Size (cm)")
            div("flex items-center gap-2") {
                daisyInput(placeholder = "Width", extraClasses = "w-1/2")
                +"×"
                daisyInput(placeholder = "Height", extraClasses = "w-1/2")
            }
        }
        daisyFieldset {
            div("text-base-content/70 py-4 text-xs") {
                +"Set a audience range for this product."
                br
                +"This is optional"
            }
            daisyRange(size = RangeSize.Xs, min = "0", max = "100", value = "25", step = "25")
            div("flex w-full justify-between px-2 py-2 text-xs") {
                for (v in listOf("0", "25", "50", "75", "100")) { span { +v } }
            }
        }
        daisyFieldset {
            div("flex gap-4 py-4") {
                daisyButton("Save draft", outline = true)
                daisyButton("Save and publish", variant = ButtonVariant.Primary, extraClasses = "grow")
            }
        }
    }
}

private data class Item(val id: Int, val name: String, val color: String, val price: String)
