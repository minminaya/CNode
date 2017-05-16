package com.minminaya.cnode.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/** 格式化时间的格式
 * Created by Niwa on 2017/5/16.
 */

public class FormatTimeUtils {
    public static String convertTime(String srcTime){
        String outputTime = null;
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = inputFormat.parse(srcTime);
            outputTime = outputDateFormat.format(date);

        } catch (ParseException e) {
            e.printStackTrace();
            outputTime = "未知时间";
        }
        return outputTime;
    }

}
