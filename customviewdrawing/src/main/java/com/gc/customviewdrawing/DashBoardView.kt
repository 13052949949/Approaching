package com.gc.customviewdrawing

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.gc.ktx.dp2px
import kotlin.math.cos
import kotlin.math.sin

private const val OPEN_ANGLE = 120f
private val DASH_WIDTH = 2.dp2px()
private val DASH_LENGTH = 10.dp2px()
private const val MARK = 10
private val LENGTH = 120.dp2px()
private val RADIUS = 150f.dp2px()

class DashBoardView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val path = Path()

    private val dash = Path().apply {
        addRect(0f, 0f, DASH_WIDTH, DASH_LENGTH, Path.Direction.CCW)
    }

    private lateinit var pathEffect: PathDashPathEffect


    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        strokeWidth = 3.dp2px()
        style = Paint.Style.STROKE
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        path.reset()
        path.addArc(width / 2 - RADIUS,
            height / 2 - RADIUS,
            width / 2 + RADIUS,
            height / 2 + RADIUS,
            90 + OPEN_ANGLE / 2,
            360 - OPEN_ANGLE)
        val pathMeasure = PathMeasure(path, false)
        pathEffect =
            PathDashPathEffect(dash, (pathMeasure.length - DASH_WIDTH) / 20, 0f, PathDashPathEffect.Style.ROTATE)
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawPath(path, paint)
        paint.pathEffect = pathEffect
        canvas.drawPath(path, paint)
        paint.pathEffect = null
        canvas.drawLine(width / 2f, height / 2f, (LENGTH * cos(mark2Radians(MARK)) + width / 2f).toFloat(), (LENGTH * sin(mark2Radians(MARK)) + height / 2f).toFloat(), paint)
    }

    private fun mark2Radians(mark: Int): Double {
        return Math.toRadians(((360 - OPEN_ANGLE) / 20 * mark + (90 + OPEN_ANGLE / 2)).toDouble())
    }

}