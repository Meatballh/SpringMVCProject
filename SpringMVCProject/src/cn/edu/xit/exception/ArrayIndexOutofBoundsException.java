package cn.edu.xit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value=HttpStatus.FORBIDDEN,reason="数组越界222!!!")
public class ArrayIndexOutofBoundsException extends Exception {//自定义异常

}