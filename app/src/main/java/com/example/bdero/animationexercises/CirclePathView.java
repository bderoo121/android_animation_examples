package com.example.bdero.animationexercises;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

class CirclePathView extends View {

    float viewWidth;
    float viewHeight;
    float radius;
    Paint paint;
    Path path;

    public CirclePathView(Context context) {
        super(context);
        paint = new Paint();
        path = new Path();

        viewWidth = getWidth();
        viewHeight = getHeight();
        radius = Math.min(viewWidth, viewHeight);
    }

    public CirclePathView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        path = new Path();

        viewWidth = getWidth();
        viewHeight = getHeight();
        radius = Math.min(viewWidth, viewHeight);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColor(Color.GRAY);
        paint.setStrokeWidth(3);

        canvas.drawCircle(viewWidth, viewHeight, radius, paint);
    }
}
