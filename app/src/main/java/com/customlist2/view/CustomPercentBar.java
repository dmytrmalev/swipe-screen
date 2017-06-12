package com.customlist2.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.customlist2.R;

import org.w3c.dom.Attr;

/**
 * Created by Admin on 3/26/2016.
 */
public class CustomPercentBar extends View {

    Paint   paint;
    int     nStartAngle;
    int     nEndAngle;
    int     nValueAngle;
    int     nPercentBarColor;
    int     nBackBarColor;
    int     nBackgroundColor;

    int     nBackBarWidth;
    int     nPercentBarWidth;

    boolean isSemiBar;

    public CustomPercentBar(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs, defStyle);
        init(attrs);
    }

    public CustomPercentBar(Context context, AttributeSet attrs){
        super(context, attrs);
        init(attrs);
    }

    public void init(AttributeSet attrs){
        paint = new Paint();

        if (attrs != null) {
            TypedArray styled = getContext().obtainStyledAttributes(attrs, R.styleable.CustomPercentBar);

            nStartAngle = styled.getInt(R.styleable.CustomPercentBar_startAngle, 0);
            nEndAngle = styled.getInt(R.styleable.CustomPercentBar_endAngle, 360);
            nValueAngle = styled.getInt(R.styleable.CustomPercentBar_valueAngle, 0);
            nPercentBarColor = styled.getColor(R.styleable.CustomPercentBar_percentBarColor, 0);
            nBackBarColor = styled.getColor(R.styleable.CustomPercentBar_backBarColor, 0);
            nBackgroundColor = styled.getColor(R.styleable.CustomPercentBar_backgroundColor, 0);
            nBackBarWidth = styled.getColor(R.styleable.CustomPercentBar_backBarWidth, 0);
            nPercentBarWidth = styled.getColor(R.styleable.CustomPercentBar_percentBarWidth, 0);

            isSemiBar = styled.getBoolean(R.styleable.CustomPercentBar_isSemiBar, false);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {

        int width = getWidth();
        int height = getHeight();

        paint.setColor(nBackgroundColor);
        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);

        paint.setColor(nBackBarColor);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2 - (nPercentBarWidth - nBackBarWidth) / 2, paint);

        paint.setColor(nBackgroundColor);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2 - (nPercentBarWidth + nBackBarWidth) / 2, paint);

        paint.setColor(nPercentBarColor);
        canvas.drawArc(new RectF(0, 0, getWidth(), getHeight()), nStartAngle, nEndAngle - nStartAngle, true, paint);

        paint.setColor(nBackgroundColor);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2 - nPercentBarWidth, paint);

        if (isSemiBar == true)
        {
            canvas.drawArc(new RectF(0, 0, getWidth(), getHeight()), 150, -120, true, paint);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        this.setMeasuredDimension(widthMeasureSpec ,widthMeasureSpec);
    }
}
