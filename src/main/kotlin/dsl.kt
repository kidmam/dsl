package dsl

import kotlinx.html.stream.createHTML
import kotlinx.html.table
import kotlinx.html.td
import kotlinx.html.tr

import java.time.Period
import java.time.LocalDate

fun main(args: Array<String>) {
    println(createAnotherTable())

    val s = buildString {
//        it.append("Hello, ")
//        it.append("World!")
        append("Hello, ")
        append("World!")
    }
    println(s)

    println(1.days.ago)
    println(1.days.fromNow)
}

val Int.days: Period
    get() = Period.ofDays(this)

val Period.ago: LocalDate
    get() = LocalDate.now() - this

val Period.fromNow: LocalDate
    get() = LocalDate.now() + this

fun buildString(
        //builderAction: (StringBuilder) -> Unit
        builderAction:StringBuilder.() -> Unit
): String {
    val sb = StringBuilder()
    //builderAction(sb)
    sb.builderAction()
    return sb.toString()
}

fun crateSimpleTable() = createHTML().
        table {
            tr {
                td { + "cell"}
            }
        }

fun createAnotherTable() = createHTML().table {
    val numbers = mapOf( 1 to "one", 2 to "two")
    for ( (num, string) in numbers ) {
        tr {
            td { + "$num"}
            td {
                + string
            }
        }

    }
}