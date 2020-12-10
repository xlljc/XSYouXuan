package com.xsyx.utils;

import org.springframework.core.convert.converter.Converter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {

        //yyyy-MM-dd
        //yyyy-MM-dd hh:mm
        //yyyy-MM-dd hh:mm:ss
        SimpleDateFormat dateFormat=null;
        if(s.length()<=10){
            dateFormat =new SimpleDateFormat("yyyy-MM-dd");
        }else if(s.length()<=16){
            dateFormat =new SimpleDateFormat("yyyy-MM-dd hh:mm");
        }else{
            dateFormat =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        }
        System.out.println("装换时间 : " + s);
        try {
            return dateFormat.parse(s);
        } catch (ParseException e) {
            return null;
        }
    }
}
