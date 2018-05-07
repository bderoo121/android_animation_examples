package com.example.bdero.animationexercises;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

class CirclePathView extends View {

    Paint red_paint_fill = new Paint(), blue_paint_fill, green_paint_stroke, gray_paint_stroke;
    private float mRadius;

    public CirclePathView(Context context) {
        super(context);
        init();
    }

    public CirclePathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CirclePathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        mRadius = 190;

        red_paint_fill = new Paint();
        red_paint_fill.setColor(Color.RED);
        red_paint_fill.setStyle(Paint.Style.FILL);

        blue_paint_fill = new Paint();
        blue_paint_fill.setColor(Color.BLUE);
        blue_paint_fill.setStyle(Paint.Style.FILL);

        green_paint_stroke = new Paint();
        green_paint_stroke.setColor(Color.GREEN);
        green_paint_stroke.setStyle(Paint.Style.STROKE);
        green_paint_stroke.setStrokeWidth(10);

        gray_paint_stroke = new Paint();
        gray_paint_stroke.setColor(Color.rgb(220, 220, 220));
        gray_paint_stroke.setStyle(Paint.Style.STROKE);
        gray_paint_stroke.setStrokeWidth(40);
    }

    public void setRadius(float radius) {
        mRadius = radius;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(380, 360, mRadius, gray_paint_stroke);

    }
}
