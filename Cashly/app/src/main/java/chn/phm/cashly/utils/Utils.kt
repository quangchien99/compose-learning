package chn.phm.cashly.utils

import java.text.DecimalFormat

internal val AccountDecimalFormat = DecimalFormat("####")
internal val AmountDecimalFormat = DecimalFormat("#,###.##")

fun formatAmount(amount: Float): String {
    return AmountDecimalFormat.format(amount)
}

/**
 * Used with accounts and bills to create the animated circle.
 */
fun <E> List<E>.extractProportions(selector: (E) -> Float): List<Float> {
    val total = this.sumOf { selector(it).toDouble() }
    return this.map { (selector(it) / total).toFloat() }
}