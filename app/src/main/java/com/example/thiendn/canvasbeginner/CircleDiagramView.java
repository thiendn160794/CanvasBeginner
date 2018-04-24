package com.example.thiendn.canvasbeginner;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

public class CircleDiagramView extends View {

    Paint mCirclePaint;
    float mRadius;
    Point mCenterPoint;
    ValueAnimator mAnimator;

    double cungTron = 0.5;

    public CircleDiagramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mCirclePaint = new Paint();
        mCirclePaint.setColor(ContextCompat.getColor(context, R.color.colorAccent));
        mCirclePaint.setStrokeWidth(2);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mRadius = w / 2;
        mCenterPoint = new Point(w / 2, w / 2);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for (double i = 0; i < cungTron; i++){
            canvas.drawLine(mRadius, mRadius, mRadius, 0, mCirclePaint);
//            canvas.save();
            canvas.rotate((float) cungTron, mRadius, mRadius);
//            canvas.restore();
        }
    }

    public void startAnimation(){

//        cungTron = 0.5;
        mAnimator = ValueAnimator.ofInt(0, 358);
        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Log.d("TAGGG", animation.getValues() + " cungTron: " + cungTron);
                cungTron += 0.5;
                invalidate();
            }
        });
        mAnimator.setDuration(10000);
        mAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        mAnimator.start();
    }
}
