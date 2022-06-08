package dev.matt2393.carreterasnex

import kotlin.math.PI
import kotlin.math.ceil
import kotlin.math.round


fun Float.toFormatSexadecimal(): String {
    val aux1 = this.toInt()
    val aux2 = ((this - aux1) * 60f).toInt()
    val aux3 = ceil((((this - aux1) * 60f)-aux2)*60).toInt()
    val saux2 = if(aux2<10) "0$aux2" else aux2.toString()
    val saux3 = if(aux3<10) "0$aux3" else aux3.toString()
    return "${aux1}º${saux2}'${saux3}\""
}

fun Float.toSexadecimal(): Float = (this * 180f / PI).toFloat()
fun Float.toRad(): Float = (this * PI / 180f).toFloat()

fun Float.toRoundMill(): Float = round(this * 1000f) / 1000f
fun Float.toRoundMillMetherString(): String = "${this.toRoundMill()} [m]"