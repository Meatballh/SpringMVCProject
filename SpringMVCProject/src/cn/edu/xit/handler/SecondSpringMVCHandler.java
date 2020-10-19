package cn.edu.xit.handler;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.xit.exception.ArrayIndexOutofBoundsException;

@Controller
@RequestMapping(value="second")
public class SecondSpringMVCHandler {
	
	@RequestMapping("testExcptionHandler")
	public String testExcptionHandler(){
//		try{
		System.out.println( 1/ 0);
//		}catch(ArithmeticException e) e
//		}catch(ArithmeticException e) e
		return "sucess";
		
	}
	
	
	@RequestMapping("testExcptionHandler2")
	public String testExcptionHandler2(){
		int[] nums = new int[2];
		System.out.println(nums[2]);
		return "sucess";
		
	}
	
/**
	//检验哪个异常先捕获（子类优先）
 
	@ExceptionHandler({ArithmeticException.class})
	public ModelAndView handleArithmeticException(Exception e){
		ModelAndView mv = new ModelAndView("error");
		System.out.println(e+"===-===");
		mv.addObject("e", e);
		return mv;
	}
	
	
	@ExceptionHandler({Exception.class})
	public ModelAndView handleArithmeticException2(Exception e){
		ModelAndView mv = new ModelAndView("error");
		System.out.println(e+"===-===");
		return mv;
	}
	
**/	
	@RequestMapping(value="testMyException")
	public String testMyException(@RequestParam("i") Integer i ) throws ArrayIndexOutofBoundsException{
		if(i==3){
			throw new ArrayIndexOutofBoundsException();
		}
		return "sucess";
		
	}
	
	@RequestMapping(value="testMyException2")
	public String testMyException2(@RequestParam("i") Integer i ) throws ArrayIndexOutofBoundsException{
		if(i==3){
			return "forward: testResponseStatus";//跳转到某一个 异常处理方法里
		}
		return "sucess";
		
	}
	
	@ResponseStatus(value=HttpStatus.FORBIDDEN,reason="数组越界222!!!")
	@RequestMapping(value="testResponseStatus")
	public String testResponseStatus(){
		
		return "sucess";
		
	}
	
//	//该方法可以捕获本类中的Exception异常
//	@ExceptionHandler({ArithmeticException.class,ArrayIndexOutOfBoundsException.class})
//	public ModelAndView handleArithmeticException(Exception e){
//		ModelAndView mv = new ModelAndView("error");
//		System.out.println(e+"===-===");
//		mv.addObject("e", e);
//		return mv;
//	}
}
