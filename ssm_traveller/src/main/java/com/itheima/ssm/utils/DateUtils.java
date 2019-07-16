package com.itheima.ssm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    //日期装换成字符串
    public static String dateToString(Date date, String pat){
        SimpleDateFormat sdf=new SimpleDateFormat(pat);
        String format=sdf.format(date);
        return format;
    }

    //日期装换成字符串
    public static Date stringToDate(String str, String pat) throws Exception{
        SimpleDateFormat sdf=new SimpleDateFormat(pat);
        Date format=sdf.parse(str);
        return format;
    }
}
