<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script>
	function emptyAdmin(){
			alert("등록되지 않은 관리자 이거나 잘못된 비밀번호 입니다.");
	}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> User Join</title>
</head>

<body>


<center>
<h1> 관리자 페이지 입니다. </h1>
<font face="맑은고딕">
<table border = "0"> 
<form action="adminlogon.do" method="post">
	<!--  아이디 일치시 메인 페이지로 ㅡ 아이디 불일치시 등록 안 된 아이디라는 알림 떠야 함 -->
	<br /><br /><br /><br />
	<tr>
	<td colspan="4" align="center"><input type="image" src="http://192.168.35.21:8080/TheShop/theshop.png"></td></tr>
	<tr>
	<td colspan="4" align="center">&nbsp;</td></tr>
	<!--  엔터  -->
	<tr>
	<th colspan="2" height="30"><font size="4">　ID　　</font></th><th><input type = "text" align="center" name = "adminid" size = "12"></th>
	<td rowspan="2">&nbsp;&nbsp;&nbsp;</font><input type ="submit" name ="orbtn" value = "로그인" style="background-color: gray"></td></tr>
	
	<tr>
	<th colspan="2" height="30"><font size="4">　Password　　</font></th><th><input type = "password" align="center" name = "adminpw" size="12"></th></tr>
</form>

<tr>
<td colspan="4" align="center">&nbsp;</td></tr>
<!--  엔터  -->
</table>
<% 

	if(session.getAttribute("ADMIN_LOGIN_FLAG") == "FAIL"){
		if(session.getAttribute("ADMIN_LOGIN_CHECK") == "DENY"){
			out.println("<script type='text/javascript'> emptyAdmin(); </script>");
		}
	}
%>
</body>
</html>