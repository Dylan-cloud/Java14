package com.cskaoyan.exception;

/**
 * @Author: TXJ
 * @Date: 2019/6/28 10:18
 * @Version 1.0
 */
public class CustomException extends Exception{
    public CustomException(){
        super();
    }
    public CustomException(String message){
        super(message);
    }
}
