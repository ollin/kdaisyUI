package kdaisyui.example.fragments

import kdaisyui.components.*
import kdaisyui.core.addClassNames
import kotlinx.html.*

fun TagConsumer<*>.cardsRow1Fragment() {
    transactionsCard()
    revenueCard()
}

private fun TagConsumer<*>.transactionsCard() {
    section {
        addClassNames("card bg-base-100 col-span-12 overflow-hidden shadow-xs xl:col-span-6")
        daisyCardBody(extraClasses = "grow-0") {
            daisyCardTitle { daisyLink("Transactions", hover = true) }
        }
        div("overflow-x-auto") {
            daisyTable(zebra = true) {
                tbody {
                    txRow("Cy Ganderton", "Feb 2nd", "180 USD", true)
                    txRow("Hart Hagerty", "Sep 2nd", "250 USD", true)
                    txRow("Jim Hagerty", "Sep 2nd", "250 USD", true)
                    txRow("Hart Hagerty", "Sep 2nd", "250 USD", false)
                    txRow("Hart Hagerty", "Sep 2nd", "250 USD", false)
                    txRow("Brice Swyre", "Jul 2nd", "320 USD", true)
                }
            }
        }
    }
}

private fun TBODY.txRow(name: String, date: String, amount: String, positive: Boolean) {
    tr {
        td { +name }
        td { +date }
        td {
            span(if (positive) "text-success" else "text-error") { +if (positive) "↑" else "↓" }
            +" $amount"
        }
    }
}

private fun TagConsumer<*>.revenueCard() {
    section {
        addClassNames("card bg-primary text-primary-content col-span-12 shadow-xs xl:col-span-6")
        daisyCardBody(extraClasses = "pb-0") {
            daisyCardTitle("21,500 USD")
            daisyLink("Revenue report →", hover = true, extraClasses = "text-xs")
        }
        div("h-full w-full p-4 pt-0") { +"[Revenue chart placeholder]" }
    }
}
