package cn.edu.xit.handler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.xit.entity.Address;
import cn.edu.xit.entity.Student;


//普通的类变成  特定功能的类     ————>实现接口，继承类，注解，配置

//@SessionAttributes("student3")//如果要在request中存放student3对象，则同时将该对象存放到session域中
//@SessionAttributes(types=Student.class)//如果要在request中存放student类型的对象，则同时将该类型的对象存放到session域中

@Controller
@RequestMapping(value="SpringMVCHandler")//映射
public class SpringMVCHandler {
	@RequestMapping(value="welcome",method=RequestMethod.POST,params={"name=zs","age!=23","!bupei"})//映射 ------没有指定默认方式是get
	public String welcome(){
		return "sucess";//   view/success.jsp . 默认使用了 请求转发的跳转方式
	}
	
	@RequestMapping(value="welcome2",headers={"Accept=text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8"})//headers浏览器的请求头
	public String welcomt(){
		return "sucess";//   view/success.jsp . 默认使用了 请求转发的跳转方式
	}
	
	@RequestMapping(value="welcome3/**/test")
	public String welcome3(){
		return "sucess";//   view/success.jsp . 默认使用了 请求转发的跳转方式
	}
	
	@RequestMapping(value="welcome4/a?v/test")
	public String welcome4(){
		return "sucess";//   view/success.jsp . 默认使用了 请求转发的跳转方式
	}
	
	@RequestMapping(value="welcome5/{name}")
	public String welcome5(@PathVariable("name") String name){
	//以前拿值：	String zs = request.getParamter("name");
		System.out.println(name);
		return "sucess";//   view/success.jsp . 默认使用了 请求转发的跳转方式
	}
	
	//增
	@RequestMapping(value="testPost/{id}",method=RequestMethod.POST)
	public String testPost(@PathVariable("id") Integer id){
		System.out.println("post增："+id);
		return "sucess";
	}
	
	//删
	@RequestMapping(value="testDelete/{id}",method=RequestMethod.DELETE)
	public String testDelete(@PathVariable("id") Integer  id){
		System.out.println("post删："+id);
		return "sucess";
	}
	
	//改
	@RequestMapping(value="testPut/{id}",method=RequestMethod.PUT)
	public String testPut(@PathVariable("id") Integer id){
		System.out.println("post改："+id);
		return "sucess";
	}
	
	//查
	@RequestMapping(value="testGet/{id}",method=RequestMethod.GET)
	public String testGet(@PathVariable("id") Integer id){
		System.out.println("post查："+id);
		//Servlet实现真正的增
		return "sucess";
	}

	//参数传值
	@RequestMapping(value="testParam")
	public String testGet(@RequestParam("uname") String name,@RequestParam(value="uage",required=false,defaultValue="11") Integer age){
		System.out.println("参数传值："+name);
		System.out.println("参数传值："+age);
		return "sucess";
	}
	
	//获取头信息
	@RequestMapping(value="testRequestHeader")
	public String testRequestHeader(@RequestHeader("Accept-Language") String language){
		System.out.println(language);
		return "sucess";
	}
	
	//获取cookie
	@RequestMapping(value="testCookieValue")
	public String testCookieValue(@CookieValue("JSESSIONID") String jsessionid){
		System.out.println(jsessionid);
		return "sucess";
	}
	
	//
	@RequestMapping(value="testObjectProperties")
	public String testObjectProperties(Student student){//student属性必须和form表单中的属性Name值一致（支持级联属性）
		
		/*以前的传值
		String name = request.getParameter("name");
		int age = request.getParameter("age");
		String haddress = request.getParameter("homeaddress");
		String saddress = request.getParameter("schooladdress");
		Address address = new Address();
		address.setHomeAddress(homeAddress);
		address.setSchoolAddress(schoolAddress);
		Student student = new Student();
		student.setNamr(name);
		student.setId(id);
		student.setAddress(address);
		*/
		System.out.println(student.getId()+","+student.getName()+","+student.getAddress().getHomeAddress()+","+student.getAddress().getSchoolAddress());
		return "sucess";
	}
	
	//使用原生态的Servlet API
	@RequestMapping(value="testServletAPI")
	public String testServletAPI(HttpServletRequest request,HttpServletResponse response){
		System.out.println(request);
		return "sucess";
	}
	
	
	//处理模型数据（view），跳转时需要带数据
	//1.ModelAndView
	@RequestMapping(value="testModelAndView")
	public ModelAndView testModelAndView(){//ModelAndView： 即有数据又有视图
		ModelAndView mv = new ModelAndView("sucess");//此处的”sucess“  告诉程序sucess就是mvc中的view   
		Student student = new Student();
		student.setId(3);
		student.setName("ww");
		mv.addObject("student", student);//相当于request.setAttribute("student"student)
		return mv;
	}
	//2.ModelMAp
	@RequestMapping(value="testModelMap")
	public String testModelAndView(ModelMap mm){//String： 只有视图页面：sucess
		 
		Student student = new Student();
		student.setId(3);
		student.setName("ww");
		mm.put("student1", student);//放到了request域中去
		//forward:请求转发             redirect:重定向
		return "sucess";//view
		//return "redirect:/views/sucess.jsp";
	}
	//3.Map
	@RequestMapping(value="testMap")
	public String testModelAndView(Map<String, Object> m){   
		
		Student student = new Student();
		student.setId(3);
		student.setName("ww");
		m.put("student2", student);//放到了request域中去
		return "sucess";
	}
	//4.Model
	@RequestMapping(value="testModel")
	public String testModelAndView(Model model){
		
		Student student = new Student();
		student.setId(3);
		student.setName("ww");
		model.addAttribute("student3",student);//放到了request域中去
		return "sucess";
	}
	
	
	
	/*@ModelAttribute//在任何一次请求前，都会执行@ModelAttribute修饰的方法
	*@ModelAttribute   在请求该类的各个方法钱吗均被执行的设计是基于一个思想：一个控制器只做一个功能
	 * 在该类中没执行其中的一个方法，给方法都会先被执行
	*
	public void queryStudentById(Map<String,Object> map){
		//StudentService stuService = new StudentService();
		//Student student = stuService.queryStudentById(12);
		//模拟调用三层查询数据库的数据
		Student student = new Student();
		student.setId(12);
		student.setName("zs");
		student.setAge(34);
		map.put("student", student);//约定：map的key  就是方法参数类型的首字母小写
		//map.put("stu", student);//当key不是大小写关系时，可用注解(@ModelAttribute("stu")Student student)来进行匹配
	}

	//修改
	@RequestMapping(value="testModelAttribute")
	public String testModelAttribute(Student student){
		student.setName(student.getName());
		System.out.println(student.getId()+","+student.getName()+","+student.getAge());
		return "sucess";
	}
	*/
	//处理国际化请求
	@RequestMapping(value="testI18n")
	public String testI18n(){
		return "sucess";
	}
	
	//自定义类型转换器
	@RequestMapping(value="testConverter")
	public String testConverter(@RequestParam("studentInfo") Student student){
		System.out.println(student.getId()+"-"+student.getName()+"-"+student.getAge());
		return "sucess";
	}
	
	@RequestMapping(value="testDateTimeFormat")//如果Student格式化出错，会将错误信息传入result中
	public String testDateTimeFormat(@Valid Student student, BindingResult result,Map<String,Object> map){
		System.out.println(student.getId()+","+student.getName()+","+student.getBirthday());
		if(result.getErrorCount()>0){
			for(FieldError error:result.getFieldErrors()){
				System.out.println(error.getDefaultMessage());
				map.put("errors",result.getFieldErrors() );//将错误信息传入到request域中的errors中
			}
		}
		return "sucess";
	}
	
	@ResponseBody//告诉SpringMVC，此时的返回 不是一个View页面，而是一个ajax调用的返回值
	@RequestMapping(value="testJson")
	public List<Student> testJson(){
		//Controller-Service-dao
		//StudentService studentService = new StudentServiceImp();
		//List<Student> students =  studentService.qeuryAllStudent();
		//模拟调用service的查询操作
		
		
		Student stu1 = new Student(1,"zs",23);
		Student stu2 = new Student(2,"ls",23);
		Student stu3 = new Student(3,"ww",23);
		
		List<Student> students = new ArrayList<>();
		students.add(stu1);
		students.add(stu2);
		students.add(stu3);
		
		return students;
	}
	
	
	//文件上传处理方法
	@RequestMapping(value="testUpload")
	public String testUpload(@RequestParam("desc") String desc , @RequestParam("file") MultipartFile file) throws IOException{
		System.out.println("文件描述信息："+desc);
		//jsp中上传的文件：file
		
		InputStream input = file.getInputStream();//IO
		String fileName = file.getOriginalFilename() ;
		OutputStream out = new FileOutputStream("e:\\"+fileName) ;
		byte[] bs = new byte[1024];
		int len = -1;
		while(( len = input.read(bs)) !=-1 ) {
			out.write(bs, 0, len);
		}
		out.close();
		input.close();
		
		System.out.println("上传成功！");
		
		return "sucess";
	}
	
	
	@RequestMapping(value="testInterceptor")
	public String testInterceptor(){
		System.out.println("处理请求的方法");
		return "sucess";
	}
	
	@RequestMapping(value="testException")
	public String testException(){
		System.out.println(1/0);
		return "sucess";
	}
}
