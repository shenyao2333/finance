package com.sy.finance.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

/**
 * @author sy
 * Date: 2020/3/27 13:51
 * @Description 处理全局异常
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler  {


    /**
     * 自定义异常
     * @param ex
     * @return
     */
    @ExceptionHandler(value = {GrabException.class})
    public RespBean serviceException(GrabException ex) {
        log.error("自定义抛出异常: "+ ex.getMessage());
        return  RespBean.fail(ex.getCode(), ex.getMsg());

    }


    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public <T> RespBean serviceException(MethodArgumentNotValidException ex) {
        //获取参数校验错误集合
        List<FieldError> bindingResult = ex.getBindingResult().getFieldErrors();
        StringBuilder errorMessage = new StringBuilder();
        for (FieldError fieldError : bindingResult) {
            errorMessage.append(fieldError.getDefaultMessage()).append(";") ;
        }
        errorMessage.substring(errorMessage.length()-1);
        log.error("参数校验错误: "+ ex.getMessage());
        return new RespBean<T>(RespBean.CodeStatus.REQUEST,false,errorMessage.toString(),null);
    }


    @ExceptionHandler(value = {BindException.class})
    public <T> RespBean serviceException(BindException ex) {
        //获取参数校验错误集合
        List<FieldError> bindingResult = ex.getBindingResult().getFieldErrors();
        StringBuilder errorMessage = new StringBuilder();
        for (FieldError fieldError : bindingResult) {
            errorMessage.append(fieldError.getDefaultMessage()).append(";") ;
        }
        errorMessage.substring(errorMessage.length()-1);
        log.error("参数校验错误: "+ ex.getMessage());
        return new RespBean<T>(RespBean.CodeStatus.REQUEST,false,errorMessage.toString(),null);
    }



    @ExceptionHandler(value = {MissingServletRequestParameterException.class})
    public <T> RespBean serviceException (MissingServletRequestParameterException ex){
        return new RespBean<T>(RespBean.CodeStatus.REQUEST,false,ex.getParameterName()+"参数校验不通过",null);
    }


    /**
     * 参数类型
     * @param ex
     * @return
     */
    @ExceptionHandler(value = {TypeMismatchException.class})
    public RespBean serviceException(TypeMismatchException ex) {
        String  message = String.format("参数类型不匹配，类型应该为: %s", ex.getRequiredType());
        return  RespBean.fail(RespBean.CodeStatus.REQUEST,message);
    }


    /**
     * 请求方式错误
     * @param ex
     * @return
     */
    @ExceptionHandler(value = {HttpRequestMethodNotSupportedException.class})
    public RespBean serviceException(HttpRequestMethodNotSupportedException ex, HttpServletRequest request) {
        return RespBean.fail(RespBean.CodeStatus.REQUEST, "接口"+ request.getMethod()+"请求类型错误!");
    }

    /**
     * 索引重复
     * @param ex
     * @return
     */
    @ExceptionHandler(value = {DuplicateKeyException.class})
    public RespBean serviceException(DuplicateKeyException ex) {
        return RespBean.fail(RespBean.CodeStatus.DATA, "数据库索引重复。");
    }

    /**
     * 数据异常
     * @param ex
     * @return
     */
    @ExceptionHandler(value = {SQLException.class})
    public RespBean serviceException(SQLException ex) {
        log.error("数据异常错误: "+ ex.getMessage());
        return RespBean.fail(RespBean.CodeStatus.DATA, "数据异常："+ex.getMessage());
    }


    /**
     * 传参类型错误
     * @param e
     * @return
     */
    @ExceptionHandler( value = {HttpMediaTypeNotSupportedException.class})
    public RespBean serviceException(HttpMediaTypeNotSupportedException e){
        return RespBean.fail(RespBean.CodeStatus.REQUEST, "传参类型错误："+e.getContentType());
    }




    /**
     * 其他异常
     * @return
     */
    @ExceptionHandler(value = {Exception.class})
    public RespBean serviceException(Exception e) {
        e.printStackTrace();
        log.error("出现错误: "+ e.getMessage());
        return RespBean.fail(-1,"错误："+e.getMessage());
    }




}
