package fvioz.simpleline;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class SimpleLineView extends View {

    float prevX, prevY, newX, newY = 0;

    Paint paint = new Paint();

    public SimpleLineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawLine(prevX, prevY, newX, newY, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                prevX = event.getX();
                prevY = event.getY();
                newX = event.getX();
                newY = event.getY();
                break;

            case MotionEvent.ACTION_UP:
                newX = event.getX();
                newY = event.getY();
                break;
        }

        this.invalidate();

        return true;
    }

}