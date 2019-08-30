package com.tomlettuces.base.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.tomlettuces.base.dip2px

class ArcProgressView @JvmOverloads constructor(
    context: Context?, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var mTextPaint: Paint? = null
    private var mArcPaint: Paint? = null
    private var mProgressPaint: Paint? = null
    private var mCurrentProgress: Float = 0.toFloat()
    private var mDegress = 0 //度数
    private var strokeWidth: Int = 0 //宽度
    private val mTextBound = Rect()
    private var mRectF: RectF? = null

    init {
        initPaint()
    }

    private fun initPaint() {
        strokeWidth = dip2px(4)
        mArcPaint = Paint()
        mArcPaint!!.isAntiAlias = true
        mArcPaint!!.style = Paint.Style.STROKE
        mArcPaint!!.strokeWidth = strokeWidth.toFloat()
        mArcPaint!!.color = Color.parseColor("#e4e8eb")

        mProgressPaint = Paint()
        mProgressPaint!!.isAntiAlias = true
        mProgressPaint!!.style = Paint.Style.STROKE
        mProgressPaint!!.strokeWidth = strokeWidth.toFloat()
        mProgressPaint!!.color = Color.parseColor("#52acff")

        mTextPaint = Paint()
        mTextPaint!!.isAntiAlias = true
        mTextPaint!!.color = Color.parseColor("#52acff")
        mTextPaint!!.textSize = dip2px(14).toFloat()

        mRectF = RectF()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        mRectF?.set(
            (0 + strokeWidth).toFloat(),
            (0 + strokeWidth).toFloat(),
            (measuredWidth - strokeWidth).toFloat(),
            (measuredHeight - strokeWidth).toFloat()
        )
    }

    protected override fun onDraw(canvas: Canvas) {
        canvas.drawOval(mRectF!!, mArcPaint!!)
        canvas.drawArc(mRectF!!, -90f, mDegress.toFloat(), false, mProgressPaint!!)

        val textlen = mTextPaint!!.measureText("$mCurrentProgress%").toInt()
        val fm = mTextPaint!!.fontMetrics
        mTextPaint!!.getTextBounds("$mCurrentProgress%", 0, "$mCurrentProgress%".length, mTextBound)
        canvas.drawText(
            "$mCurrentProgress%",
            (getWidth() / 2 - textlen / 2).toFloat(),
            (getHeight() / 2 + mTextBound.height() / 2).toFloat(),
            mTextPaint!!
        )
    }

    fun setProgress(progresss: Float) {
        mCurrentProgress = if (progresss >= 100f) 100f else progresss
        mDegress = if ((progresss * 3.6f + 0.5f).toInt() >= 360) 360 else (progresss * 3.6f + 0.5f).toInt()
        invalidate()
    }

}