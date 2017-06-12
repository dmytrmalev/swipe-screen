package com.customlist2.view;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

import com.customlist2.R;
import com.customlist2.activity.MainActivity;

/**
 * Created by Admin on 3/28/2016.
 */
public class MyViewPager extends ViewPager {

    public MyViewPager(Context context)
    {
        super(context);
    }

    public MyViewPager(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        View view = getChildAt(this.getCurrentItem());
        if (view != null) {
            view.measure(widthMeasureSpec, heightMeasureSpec);
        }

        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);

        //setMinimumHeight(displaymetrics.heightPixels);
        setMeasuredDimension(getMeasuredWidth(), displaymetrics.heightPixels);
    }

    private int measureHeight(int measureSpec, View view) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            // set the height from the base view if available
            if (view != null) {
                result = view.getMeasuredHeight();
            }
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }
}
