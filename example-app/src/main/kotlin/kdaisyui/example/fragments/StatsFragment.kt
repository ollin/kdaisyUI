package kdaisyui.example.fragments

import kdaisyui.components.*
import kdaisyui.core.addClassNames
import kotlinx.html.TagConsumer
import kotlinx.html.section

fun TagConsumer<*>.statsFragment() {
    section {
        addClassNames("stats stats-vertical xl:stats-horizontal bg-base-100 col-span-12 w-full shadow-xs")
        repeat(4) {
            daisyStat {
                daisyStatTitle("Total Page Views")
                daisyStatValue("89,400")
                daisyStatDesc("21% more than last month")
            }
        }
    }
}
