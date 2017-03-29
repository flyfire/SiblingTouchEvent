package org.solarex.siblingtouchevent;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by houruhou on 29/03/2017.
 */

public class CustomLinearLayout extends LinearLayout {
    public CustomLinearLayout(Context context) {
        super(context);
    }

    public CustomLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("solarex", "layout--dispatch--" + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d("solarex", "layout--onIntercept--" + ev.getAction());
        return true;
    }

    @Override
    public boolean onTouchEvent(final MotionEvent event) {
        Log.d("solarex", "layout--onTouchEvent--" + event.getAction());
        final View child1 = getChildAt(0);
        final View child2 = getChildAt(1);
//        Log.d("solarex", "motionevent:(x = " + event.getX() + ",y = " + event.getY());
//        Log.d("solarex", "child1:[" + child1.getLeft() + "," + child1.getTop() + "," +
//                child1.getRight() + "," + child1.getBottom() + "]");
//        Log.d("solarex", "child2:[" + child2.getLeft() + "," + child2.getTop() + "," +
//                child2.getRight() + "," + child2.getBottom() + "]");
        super.onTouchEvent(event);
        if (child1.getTop() < event.getY() && event.getY() < child1.getBottom()) {
            MotionEvent ev = MotionEvent.obtain(event.getDownTime(),
                    event.getEventTime(), event
                    .getAction(), child2.getTop(),
                    child2.getRight(), 0);
            child2.dispatchTouchEvent(ev);
        }
        if (child2.getTop() < event.getY() && event.getY() < child2.getBottom()) {
            MotionEvent ev = MotionEvent.obtain(event.getDownTime(),
                    event.getEventTime(), event
                            .getAction(), child1.getTop(),
                    child1.getRight(), 0);
            child1.dispatchTouchEvent(event);
        }
        return true;
    }
}
