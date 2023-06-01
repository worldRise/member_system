package com.auther.fan.member_system.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    /**
     * 访问成功，不带有数据
     * @return
     * @param <T>
     */
    public static <T> Result<T> success(){
        return new Result<T>(20000,"success",null);
    }

    /**
     * 访问成功，带有一个数据
     * @param data
     * @return
     * @param <T>
     */
    public static <T> Result<T> success(T data){
        return new Result<T>(20000,"success",data);
    }

    /**
     *返回信息值和数据
     * @param message
     * @param data
     * @return
     * @param <T>
     */
    public static <T> Result<T> success(T data,String message){
        return new Result<T>(20000,message,data);
    }

    /**
     * 返回一个信息
     * @param message
     * @return
     * @param <T>
     */
    public static <T> Result<T> success(String message){
        return new Result<T>(20000,message,null);
    }

    /**
     * 访问失败
     * @return
     * @param <T>
     */
    public static <T> Result<T> fail(){
        return new Result<>(20001,"fail",null);
    }

    /**
     * 访问失败，设定状态码
     * @param code
     * @return
     * @param <T>
     */
    public static <T> Result<T> fail(Integer code){
        return new Result<>(code,"fail",null);
    }

    /**
     * 自定义状态码，并且自定义设定返回信息
     * @param code
     * @param message
     * @return
     * @param <T>
     */
    public static <T> Result<T> fail(Integer code,String message){
        return new Result<>(code,message,null);
    }

    /**
     * 返回失败信息
     * @param message
     * @return
     * @param <T>
     */
    public static <T> Result<T> fail(String message){
        return new Result<>(20001,message,null);
    }
}
