package com.minminaya.library.utils;

import android.content.Context;

/**
 * Created by Niwa on 2017/5/15.
 */

public class DipConvertUtils {
    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     *
     * @param context 上下文
     * @param dpValue 要转换的dp
     * @return 返回装换后的px值
     */
    public static int dip2px(Context context, float dpValue) {
        final float scacle = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scacle + 0.5f);
    }
}
