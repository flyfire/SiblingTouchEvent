package org.solarex.siblingtouchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * Created by houruhou on 29/03/2017.
 */

public class CustomButton1 extends Button {
    public CustomButton1(Context context) {
        super(context);
    }

    public CustomButton1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomButton1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d("solarex", "btn1--dispatch--"+event.getAction());
        return super.dispatchTouchEvent(event);
//        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("solarex", "btn1--onTouchEvent--"+event.getAction());
        return super.onTouchEvent(event);
//        return false;
    }
}
