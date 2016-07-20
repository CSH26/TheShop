<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script>
	function emptyUser(){
		<%	session.setAttribute("ACCESS_COUNT","0"); %>
			alert("등록되지 않은 사용자 이거나 잘못된 비밀번호 입니다.");
			
	}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> User Join</title>
</head>

<body>

<center>
	<form action="logon.do" method="post">
		<table border = "0"> 
				<!--  아이디 일치시 메인 페이지로 ㅡ 아이디 불일치시 등록 안 된 아이디라는 알림 떠야 함 -->
				<tr>
				<td colspan="4" align="center"><input type="image" src="http://localhost:8180/TheShop/login_pageimage.gif"></td></tr>
				<tr>
				<td colspan="4" align="center">&nbsp;</td></tr>
				<!--  엔터  -->
				<tr>
				<th colspan="2" height="30"><font size="4">　ID　　</font></th><th><input type = "text" name = "userid" size = "12"></th>
				<td rowspan="2">&nbsp;&nbsp;&nbsp;<input type ="submit" name ="orbtn" value = "로그인" style="background-color: gray"></td></tr>
				<tr>
				<th colspan="2" height="30"><font size="4">　Password　　</font></th><th><input type = "password" name = "userpw" size="12"></th></tr>
		<tr>
		<td colspan="4" align="center">&nbsp;</td></tr>
		<!--  엔터  -->
		</table>
	</form>

	<table>
		<tr>
			<td colspan="3" height="30">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </td>
			<td> <a href="CustomerJoin.jsp">일반가입</a> &nbsp;&nbsp;&nbsp;</td>
			<td> <a href="CompanyJoin.jsp">업체가입</a> </td>
		</tr>
	</table>
</center>

<% 
	if(session.getAttribute("ACCESS_COUNT") == "1"){
		if(session.getAttribute("RESULT") == "UN_ACCESSIBLE"){
			out.println("<script type='text/javascript'> emptyUser(); </script>");
		}
	}
%>
</body>
</html>