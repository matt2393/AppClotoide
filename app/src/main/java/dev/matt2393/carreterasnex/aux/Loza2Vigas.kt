package dev.matt2393.carreterasnex.aux

import android.content.Context
import android.graphics.Paint
import com.aghajari.graphview.AXGraphCanvas
import com.aghajari.graphview.AXGraphFormula


class Loza2Vigas(val context: Context,
                 var A: Float,
                 var e: Float,
                 var a1: Float,
                 var f: Float,
                 var s: Float,
                 var b: Float,
                 var c: Float): AXGraphFormula() {
    var paint: Paint? = null
    init {
        paint = Paint()
        paint?.strokeWidth = 5f

        graphPaint.style = Paint.Style.STROKE
        pointPaint.color = graphPaint.color
        pointCircleRadius *= 1.2f

        /*
        addCustomPoint(0f, r)
        addCustomPoint(0f, -r)
        addCustomPoint(r, 0f)
        addCustomPoint(-r, 0f)
         */
    }
    override fun onDraw(canvas: AXGraphCanvas?): Boolean {
        canvas?.drawLine(-(A/2f), e, (A/2f), e, paint)
        val aux = a1 + b + (s/2f)
        canvas?.drawLine(-aux, 0f, -aux+a1, 0f, paint)
        canvas?.drawLine(aux, 0f, aux-a1, 0f, paint)
        canvas?.drawLine(-(s/2f), 0f, (s/2f), 0f, paint)
        //viga1
        canvas?.drawLine(-aux+a1, 0f, -(s/2f+b), -f, paint)
        canvas?.drawLine(-aux+a1+b, 0f, -(s/2f), -f, paint)
        canvas?.drawLine(-(s/2f+b), -f, -(s/2f), -f, paint)
        //viga2
        canvas?.drawLine((s/2f), 0f, (s/2f), -f, paint)
        canvas?.drawLine( (s/2f+b), 0f,  (s/2f+b), -f, paint)
        canvas?.drawLine((s/2f), -f, (s/2f+b), -f, paint)
        ///
        canvas?.drawLine(-aux, 0f, -aux, e, paint)
        canvas?.drawLine(aux, 0f, aux, e, paint)
        //
        canvas?.drawLine(-aux, e, -(aux+c/2f), e, paint)
        canvas?.drawLine(aux, e, (aux+c/2f), e, paint)
        //
        canvas?.drawLine(-(aux+c/2f), e, -(aux+c/2f), e+e, paint)
        canvas?.drawLine((aux+c/2f), e, (aux+c/2f), e+e, paint)
        //
        canvas?.drawLine(-(aux+c/2f), e+e, -(aux+c/2f)+c, e+e, paint)
        canvas?.drawLine((aux+c/2f), e+e, (aux+c/2f)-c, e+e, paint)
        //
        canvas?.drawLine(-(aux+c/2f)+c, e+e, -(A/2f), e, paint)
        canvas?.drawLine((aux+c/2f)-c, e+e, (A/2f), e, paint)


        /*
        canvas!!.setRadiusFromAxis(true)
        canvas!!.drawCircle(0f, 0f, r, graphPaint)

        if (angle != 0) {
            val angleR = Math.toRadians(angle.toDouble()).toFloat()
            val text = "$angle°"
            paint!!.color = Color.parseColor("#03DAC5")
            paint!!.strokeWidth = graphPaint.strokeWidth
            val x = Math.cos(angleR.toDouble()).toFloat() * r
            val y = Math.sin(angleR.toDouble()).toFloat() * r
            val r2 = r / 5
            paint!!.style = Paint.Style.STROKE
            canvas!!.drawArc(-r2, -r2, r2, r2, (-angle).toFloat(), angle.toFloat(), true, paint)
            paint!!.style = Paint.Style.FILL
            paint!!.textSize = canvas!!.findGraphX(r) / 10
            canvas!!.drawText(text, r2, r2 / 1.5f, Gravity.CENTER_VERTICAL or Gravity.LEFT, paint)
            canvas!!.drawLine(0f, 0f, x, 0f, paint)
            paint!!.pathEffect = DashPathEffect(
                floatArrayOf(20f / canvas!!.graphScale, 20f / canvas!!.graphScale),
                0f
            )
            canvas!!.drawLine(x, y, x, 0f, paint)
            canvas!!.drawLine(0f, y, x, y, paint)
            paint!!.pathEffect = null
            paint!!.color = canvas!!.graphView.context.resources.getColor(R.color.purple_500)
            canvas!!.drawLine(0f, 0f, x, y, paint)
            val savedColor = pointPaint.color
            pointPaint.color = paint!!.color
            drawPoint(canvas, x, y, AXGraphPointType.CUSTOM)
            pointPaint.color = savedColor
        }*/
        return true
    }
    override fun function(x: Float): Float {
        return Float.MAX_VALUE
    }
}