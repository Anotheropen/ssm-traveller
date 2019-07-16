package com.itheima.ssm.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

public class StringToDateConverter implements Converter<String,Date>{
    @Override
    public Date convert(String source) {
        if(source==null){
            throw new RuntimeException("请传入数据");
        }
        DateFormat format=new SimpleDateFormat("yyyy-mm-dd hh:mm");

        try{
            return format.parse(source);
        }catch (Exception e){
            throw new RuntimeException("数据类型转换错误");
        }


    }
}
