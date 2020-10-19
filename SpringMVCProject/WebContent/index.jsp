<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript">
	
		$(document).ready(function(){
			$("#testJson").click(function(){
				//通过ajsx请求springmvc
				$.post(
					"SpringMVCHandler/testJson",//服务器地址
					//{"name":"zs"."age":2},
					function(result){//服务端处理完毕后的回调函数 List<Student> students,该集合传递回来的值被result接收
						// eval(result)
						for(var i=0;i<result.length;i++){
							alert(result[i].id +"-"+result[i].name +"-"+result[i].age);
						}
					}
				);
			});
		});
	
	
	
	</script>
<body>
	<input type="submit" value="testJson" id="testJson">

	
	



<!-- 
	  <servlet-mapping>
		  	<servlet-name>springDispatchServlet</servlet-name>
		  	<url-pattern>.action</url-pattern>
 	 </servlet-mapping>
  
	<a href="welcome.action">first SprongMVC  -welcome</a>  .action的结尾    该请求交给springmvc处理      找@RequestMapping映射
	<a href="welcome.action">first SprongMVC  -welcome</a>	.action的结尾    该请求交给springmvc处理	 找@RequestMapping映射
	<a href="welcome">first SprongMVC  -welcome</a>				交给servlet处理				找url-parttern(2.5)  / @WebServlet(3.0)
 -->
 
 
 
 
 
	<!--  <a href="SpringMVCHandler/welcome2">first SprongMVC  -welcome</a>-->
	
	/**/<a href="SpringMVCHandler/welcome3/sd/hsfjh/test">first SprongMVC  -welcome</a><br>
	/a?v/<a href="SpringMVCHandler/welcome4/acv/test">first SprongMVC  -welcome</a><br>
	<a href="SpringMVCHandler/welcome5/zs">first SprongMVC  -welcome</a>
	<form action="SpringMVCHandler/welcome" method="post">
		name:<input name="name" ><br>
		age:<input name="age">
		bupei:<input name="bupei">
		<input type="submit" value="post"><br>
	</form>
	
	<br/>======<br/>
	
	
	
	<!-- 增 -->
	<form action="SpringMVCHandler/testPost/123" method="post">
		<input type="submit" value="增">
	</form>
	
	<!-- 删 -->
	<form action="SpringMVCHandler/testDelete/123" method="post">
		<input type="hidden" name="_method" value="DELETE">
		<input type="submit" value="删">
	</form>
	
	<!-- 改 -->
	<form action="SpringMVCHandler/testPut/123" method="post">
		<input type="hidden" name="_method" value="PUT">
		<input type="submit" value="改">
	</form>
	
	<!-- 查 -->
	<form action="SpringMVCHandler/testGet/123" method="get">
		<input type="submit" value="查">
	</form>
	
	--------------<br>
	
	<!-- 参数传值 -->
	<form action="SpringMVCHandler/testParam" method="get">
		name:<input type="text" name="uname">
		<input type="submit" value="查">
	</form>
	
	<!-- 请求头信息 -->
	<a href="SpringMVCHandler/testRequestHeader">first SprongMVC  -welcome</a><br>
	
	<!-- 获取cookie -->
	<a href="SpringMVCHandler/testCookieValue">first SprongMVC  -welcome</a><br>
	
	--------------<br>
	<form action="SpringMVCHandler/testObjectProperties" method="post">
		id：<input name="id" type="text">
		name:<input name="name" type="text">
		homeaddress:<input name="address.homeAddress" type="text">
		schooladdress:<input name="address.schoolAddress" type="text">
		<input type="submit" value="提交">
	</form>
	
	<!-- 使用原生态的Servlet API -->
	<a href="SpringMVCHandler/testServletAPI">testServletAPI</a><br>
	
	
	
	<a href="SpringMVCHandler/testModelAndView">testModelAndView</a><br>
	<a href="SpringMVCHandler/testModelMap">testModelMap</a><br>
	<a href="SpringMVCHandler/testMap">testMap</a><br>
	<a href="SpringMVCHandler/testModel">testModel</a><br>
	
	
	<form action="SpringMVCHandler/testModelAttribute">
		编号：<input name="id" type="hidden"  value="12"/>
		姓名：<input  name="name" type="text"/>
		<input type="submit" value="修改" />	
	</form>
	
	<!-- 处理国际化请求 -->
	<a href="SpringMVCHandler/testI18n">testI18n</a><br>
	
	<!-- index.jsp——>sucess.jsp -->
	<a href="SpringMVCHandler/testMvcViewController">testMvcViewController</a><br>
	
	<form action="SpringMVCHandler/testConverter" method="post">
		学生信息：<input name="studentInfo" type="text" />
		<input type="submit" value="转换" />	
	</form>
	
	
	<form action="SpringMVCHandler/testDateTimeFormat">
		编号：<input name="id" type="text"/>
		姓名：<input  name="name" type="text"/>
		出生日期：<input name="birthday" type="text">
		<input type="submit" value="修改" />	
	</form>
	
	
	=============<br>
	
	<form action="SpringMVCHandler/testUpload" method="post" enctype="multipart/form-data">
		<input type="file" name="file" multiple="multiple">
		描述：<input name="desc" type="text"/>
		
		<input type="submit" value="上传" />	
	</form>
	
	
	<a href="SpringMVCHandler/testInterceptor">testInterceptor</a><br>
	
	<a href="second/testExcptionHandler">testExcptionHandler</a><br>
	<a href="second/testExcptionHandler2">testExcptionHandler2</a><br>
	<a href="SpringMVCHandler/testException">testException</a><br>
	<form action="second/testMyException" >
		数字：<input name="i" type="text" />
		<input type="submit" value="提交" />	
	</form>
		<form action="second/testMyException2" >
		数字：<input name="i" type="text" />
		<input type="submit" value="提交" />	
	</form>
</body>
</html>