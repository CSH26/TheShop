<%@page import="jdk.nashorn.internal.ir.RuntimeNode.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>로그아웃 하시겠습니까?</h1>
<form action="CompanyLoginPage.jsp" onSubmit="return checkIt()">
	<input type = "submit" value = "로그아웃" >
</form>
</center>
</body>

<script language="javascript">
    function checkIt(){
    	alert("로그 아웃 되었습니다.");
    	session.invalidate();
      }
</script>
</html>