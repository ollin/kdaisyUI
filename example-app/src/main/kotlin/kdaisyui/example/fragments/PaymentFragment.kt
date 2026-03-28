package kdaisyui.example.fragments

import kdaisyui.components.*
import kdaisyui.core.addClassNames
import kotlinx.html.*

fun TagConsumer<*>.paymentFragment() {
    paymentHeader()
    paymentForm()
    userTransactionsTable()
}

private fun TagConsumer<*>.paymentHeader() {
    header {
        addClassNames("col-span-12 flex items-center gap-2 lg:gap-4")
        div("grow") { h1("font-light lg:text-2xl") { +"Payment information" } }
    }
}

private fun TagConsumer<*>.paymentForm() {
    section {
        addClassNames("card bg-base-100 col-span-12 xl:col-span-5")
        form(classes = "card-body") {
            action = ""
            daisyAlert(variant = AlertVariant.Success) {
                span { +"Your payment was successful" }
            }
            daisyFieldset {
                daisyLabel { daisyLabelText("Card Number") }
                daisyInput(extraClasses = "w-full font-mono") {
                    attributes["pattern"] = """\d{16}"""
                    attributes["title"] = "16 digits card number"
                    minLength = "16"; maxLength = "16"; required = true
                }
            }
            div("grid grid-cols-2 gap-2") {
                daisyFieldset {
                    daisyLabel { daisyLabelText("CVV") }
                    daisyInput(placeholder = "XXX", extraClasses = "text-center font-mono") {
                        attributes["pattern"] = """\d{3,4}"""
                        minLength = "3"; maxLength = "4"; required = true
                    }
                }
                daisyFieldset {
                    daisyLabel { daisyLabelText("Expiration date") }
                    div("input grid grid-cols-2 gap-2") {
                        input { placeholder = "MM"; type = InputType.text; classes = setOf("text-center", "font-mono"); minLength = "2"; maxLength = "2"; required = true }
                        input { placeholder = "YY"; type = InputType.text; classes = setOf("text-center", "font-mono"); minLength = "2"; maxLength = "2"; required = true }
                    }
                }
            }
            daisyFieldset {
                daisyLabel { daisyLabelText("Name") }
                daisyInput(extraClasses = "w-full")
            }
            daisyFieldset {
                label("flex cursor-pointer gap-4") {
                    daisyCheckbox(size = CheckboxSize.Sm, checked = true)
                    span("label-text") { +"Save my card information for future payments" }
                }
                label("flex cursor-pointer gap-4") {
                    daisyCheckbox(size = CheckboxSize.Sm, checked = true) { required = true }
                    span("label-text") { +"Accept terms of use and privacy policy" }
                }
            }
            daisyFieldset {
                div("flex items-end py-4") {
                    daisyButton("Confirm Payment", variant = ButtonVariant.Primary, extraClasses = "grow")
                }
            }
        }
    }
}

private fun TagConsumer<*>.userTransactionsTable() {
    section {
        addClassNames("card bg-base-100 col-span-12 overflow-hidden shadow-xs xl:col-span-7")
        daisyCardBody(extraClasses = "grow-0") {
            div("flex justify-between gap-2") {
                daisyCardTitle(extraClasses = "grow") { daisyLink("Recent user transactions", hover = true) }
                daisyButton("See all users", size = ButtonSize.Sm)
                daisyButton("Settings", size = ButtonSize.Sm)
            }
        }
        div("overflow-x-auto") {
            daisyTable(zebra = true) {
                tbody {
                    for ((imgId, name, country, date, amount, positive) in listOf(
                        Tx(1, "Hart Hagerty", "United States", "Feb 2nd", "180 USD", true),
                        Tx(2, "Brice Swyre", "China", "Sep 2nd", "250 USD", true),
                        Tx(3, "Marjy Ferencz", "Russia", "Sep 2nd", "250 USD", true),
                        Tx(4, "Yancy Tear", "Brazil", "Sep 2nd", "250 USD", false),
                        Tx(5, "Marjy Ferencz", "Russia", "Sep 2nd", "250 USD", false),
                        Tx(6, "Hart Hagerty", "United States", "Jul 2nd", "320 USD", true),
                    )) {
                        tr {
                            td("w-0") { daisyCheckbox() }
                            td {
                                div("flex items-center gap-4") {
                                    daisyAvatar {
                                        div("mask mask-squircle h-10 w-10") {
                                            img(src = "https://picsum.photos/80/80?$imgId", alt = "Avatar")
                                        }
                                    }
                                    div {
                                        div("text-sm font-bold") { +name }
                                        div("text-xs opacity-50") { +country }
                                    }
                                }
                            }
                            td { +date }
                            td {
                                span(if (positive) "text-success" else "text-error") { +if (positive) "↑" else "↓" }
                                +" $amount"
                            }
                        }
                    }
                }
            }
        }
    }
}

private data class Tx(val imgId: Int, val name: String, val country: String, val date: String, val amount: String, val positive: Boolean)
