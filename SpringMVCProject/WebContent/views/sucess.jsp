<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<c:forEach items="${requestScope.errors}" var="error">
		${error.getDefaultMessage() }
	</c:forEach>



	<br>
	<fmt:message key="resource.welcome"></fmt:message><br/>
	<fmt:message key="resource.exist"></fmt:message>


	<br/>
	welcome springmvc
	<br>
	--------request:<br>
	${requestScope.student.id}-${requestScope.student.name}<br>
	${requestScope.student1.id}-${requestScope.student1.name}<br>
	${requestScope.student2.id}-${requestScope.student2.name}<br>
	${requestScope.student3.id}-${requestScope.student3.name}<br>
	
	-----session:<br>
	${sessionScope.student.id}-${sessionScope.student.name}<br>
	${sessionScope.student1.id}-${sessionScope.student1.name}<br>
	${sessionScope.student2.id}-${sessionScope.student2.name}<br>
	${sessionScope.student3.id}-${sessionScope.student3.name}<br>
</body>
</html>