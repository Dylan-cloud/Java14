package com.cskaoyan.converter;



import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: TXJ
 * @Date: 2019/6/28 19:07
 * @Version 1.0
 */
public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return simpleDateFormat.parse(s);
        }catch (ParseException e){
            throw new RuntimeException(e);
        }

    }
    public DateConverter() {
        System.out.println("DateConverter init");
    }

}
