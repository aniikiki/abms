package com.aniikiki.abms.utils;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class DateUtil {

    public static final String DATE_FORMAT_FULL = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_FORMAT_YMD = "yyyy-MM-dd";

    public static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";

    public static String format(String sformat,Date currentTime) {
        if(currentTime == null){
            currentTime = new Date();
        }
        SimpleDateFormat formatter = new SimpleDateFormat(sformat);
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    public static Date parse(String date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            if (null != date) {
                return sdf.parse(date);
            } else {
                return null;
            }
        } catch (Exception e) {
            log.error("字符串转换为制定格式日期异常：{}", e);
            return null;
        }
    }

    public static String currentDateTimeStr() {
        return format(DATE_FORMAT_FULL, new Date());
    }

}
