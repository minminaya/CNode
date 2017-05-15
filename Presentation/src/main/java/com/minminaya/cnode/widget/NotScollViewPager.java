package com.minminaya.cnode.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/** 屏蔽ViewPager的滑动
 * Created by Niwa on 2017/5/15.
 */

public class NotScollViewPager extends ViewPager {
    public NotScollViewPager(Context context) {
        super(context);
    }

    public NotScollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
}
