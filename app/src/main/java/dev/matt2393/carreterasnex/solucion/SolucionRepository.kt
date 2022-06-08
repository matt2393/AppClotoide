package dev.matt2393.carreterasnex.solucion

import dev.matt2393.carreterasnex.model.Prog
import kotlin.math.*

class SolucionRepository {
    fun sol1(a: Float, rc: Float) = a.pow(2) / rc
    fun sol2(le: Float, rc: Float) = (90/ PI * le/rc)
    fun sol3(angle: Float, thetaE: Float) = angle - 2f * thetaE
    fun sol4_1(cu: Float, rc: Float) = 2f * asin(cu/(2*rc))
    fun sol4_2(angle: Float, cu: Float, gc: Float) = cu * (angle*PI/180).toFloat() / gc
    fun sol5_1(thetaE: Float, le: Float) = le * (1-(thetaE* PI/180f).toFloat().pow(2)/10+(thetaE* PI/180f).toFloat().pow(4)/216-(thetaE* PI/180f).toFloat().pow(6)/9360)
    fun sol5_2(thetaE: Float, le: Float) = le * ((thetaE* PI/180f).toFloat()/3-(thetaE* PI/180f).toFloat().pow(3)/42+(thetaE* PI/180f).toFloat().pow(5)/1320-(thetaE* PI/180f).toFloat().pow(7)/75600)
    fun sol6_1(xc: Float, rc: Float, thetaE: Float) = xc - rc * sin((thetaE* PI/180f).toFloat())
    fun sol6_2(yc: Float, rc: Float, thetaE: Float) = yc - rc * (1- cos((thetaE* PI/180f).toFloat()))
    fun sol7(k: Float, rc: Float, p: Float, angle: Float) = k+(rc+p)* tan((angle* PI/180f).toFloat()/2)
    fun sol8_1(xc: Float, yc: Float, thetaE: Float) = xc - (yc/ tan((thetaE* PI/180f).toFloat()))
    fun sol8_2(yc: Float, thetaE: Float) = yc/ sin((thetaE* PI/180f).toFloat())
    fun sol9(rc: Float, p: Float, angle: Float) = (rc+p)/ cos((angle* PI/180f).toFloat()/2) - rc
    fun sol10(xc: Float, yc: Float) = sqrt(xc.pow(2)+yc.pow(2))
    fun sol11(xc: Float, yc: Float) = atan(yc/xc)

    fun sol12_1TE(progPI: Prog, te: Float) = progSolAux(progPI, te)
    fun sol12_2EC(progTE: Prog, le: Float) = progSolAux(progTE, le, true)
    fun sol12_3CE(progEC: Prog, lc: Float) = progSolAux(progEC, lc, true)
    fun sol12_4ET(progCE: Prog, le: Float) = progSolAux(progCE, le, true)

    private fun progSolAux(progAux: Prog, value: Float, isSum: Boolean = false): Prog {
        val progAux2 = Prog()
        progAux2.p1 = progAux.p1
        progAux2.p2 = if(isSum) progAux.p2 + value else progAux.p2 - value
        if(progAux2.p2 < 0) {
            progAux2.p1-=1
            progAux2.p2 += 1000f
        }
        if(progAux2.p2 >= 1000f) {
            progAux2.p1+=1
            progAux2.p2 -= 1000f
        }
        return progAux2
    }


    fun getA(r: Float, n: Int, a: Float, v: Float): Float {
        return maxOf(aCrit1(r), aCrit2(r), aCrit3(r, n, a, v), aCrit4(v, r, a))
    }
    private fun aCrit1(r: Float): Float = r - r/3
    private fun aCrit2(r: Float): Float = (12f * r.pow(3f)).pow(0.25f)
    private fun aCrit3(r: Float, n: Int, a: Float, v: Float): Float {
        return sqrt((n*a/2*a*r)/getM(v, n))
    }
    private fun aCrit4(v: Float, r: Float, a: Float): Float {
        val j = if(r<120) {
            when(v) {
                in 40f..60f -> 1.5f
                70f -> 1.4f
                80f -> 1f/0.5f
                90f -> 0.9f
                100f -> 0.8f
                110f -> 0.4f
                else -> 0f
            }
        } else {
            if(v < 80f) {
                0.5f
            } else {
                0.4f
            }
        }

        return sqrt(((v*r)/(46.606f*j))*(v.pow(2)/r - 1.27f*a))
    }

    private fun getM(v: Float, n: Int): Float {
        return when(v) {
            in 30f..50f -> 1.5f
            in 51f..70f -> 1.3f
            in 71f..90f -> 0.9f
            in 91f..120f-> 0.8f
            else -> 0f
        }
    }
}