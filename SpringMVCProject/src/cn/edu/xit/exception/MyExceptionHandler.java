package cn.edu.xit.exception;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice
public class MyExceptionHandler {//不是控制器，仅仅是用于处理异常的类
	@ExceptionHandler({Exception.class})
	public ModelAndView handleArithmeticException2(Exception e){
		ModelAndView mv = new ModelAndView("error");
		System.out.println(e+"===-===");//该ControllerAdvice中的异常处理方法，可以处理任何类中异常 
		mv.addObject("e", e);
		return mv;
	}
}
