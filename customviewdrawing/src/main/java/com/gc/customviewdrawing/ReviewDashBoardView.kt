package com.gc.customviewdrawing

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.gc.ktx.dp2px
import kotlin.math.cos
import kotlin.math.sin

private val STROKE_WIDTH = 3.dp2px()
private val RADIUS = 150.dp2px()
private val POINTER_LENGTH = 120.dp2px()
private const val OPEN_ANGLE = 120f
private val DASH_WIDTH = 3.dp2px()
private val DASH_LENGTH = 10.dp2px()

class ReviewDashBoardView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        strokeWidth = STROKE_WIDTH
        style = Paint.Style.STROKE
    }

    private var path = Path()

    private val dash = Path().apply {
        addRect(0f, 0f, DASH_WIDTH, DASH_LENGTH, Path.Direction.CCW)
    }

    private lateinit var pathEffect: PathDashPathEffect

    var mark = 5
        set(value) {
            field = value
            invalidate()
        }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        path.reset()
        path.addArc(w / 2 - RADIUS, h / 2 - RADIUS, w / 2 + RADIUS,
            h / 2 + RADIUS, 90 + OPEN_ANGLE / 2, 360 - OPEN_ANGLE)
        val pathMeasure = PathMeasure(path, false)
        pathEffect =
            PathDashPathEffect(dash, (pathMeasure.length - DASH_WIDTH) / 20, 0f, PathDashPathEffect.Style.ROTATE)
    }


    override fun onDraw(canvas: Canvas) {
        canvas.drawPath(path, paint)
        paint.pathEffect = pathEffect
        canvas.drawPath(path, paint)
        paint.pathEffect = null
        canvas.drawLine(width / 2f, height / 2f, (width / 2 + POINTER_LENGTH * cos(mark2Radians(mark))).toFloat(),
            (height / 2 + POINTER_LENGTH * sin(mark2Radians(mark))).toFloat(), paint)
    }

    private fun mark2Radians(mark: Int) =
        Math.toRadians((90 + OPEN_ANGLE / 2f + (360 - OPEN_ANGLE) / 20f * mark).toDouble())

}