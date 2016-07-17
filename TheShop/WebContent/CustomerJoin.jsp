<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
	function okCheck(a){
			alert("등록되지 않은 아이디입니다. 사용 가능합니다.");
			document.idform.userid.value=a;
	}
	function nonCheck(){
			alert("이미 등록된 아이디 입니다.");
	}
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> User Join</title>
</head>

<body>
<center>

<br /><br /><br /><br /><br /><br />
<table border = "0"> 

<input type="image" src="http://192.168.35.21:8080/TheShop/user.png"><br /><br />


<font face="맑은고딕"><br />

<table>
<tr>
<form action="idcheck.do" method="post" name="idform">
	<td colspan="2" width="5"><font color="black" ><strong>
	ID<td><input type = "text" align="center" name = "userid" size = "10"></td><td>
	
	<!-- // #부분에는 중복 환인 창으로 넘어가는 주소를 넣어야 함 -->
	&nbsp; &nbsp; &nbsp;<input type ="submit" value = "중복 확인" /></td>
</form>
	
<form action="write.do" method="post">
	<tr>
	<td colspan="2" width="5"><font color="black"><strong>
	Name<td><input type = "text" name = "username"  size = "10"></td></tr>
	
	<tr>
	<td colspan="2" width="5"><font color="black"><strong>
	Password<td><input type = "text" name = "userpw" size = "10" ></td></tr>
	
	<tr>
	<td colspan="2" width="5"><font color="black"><strong>
	Address<td><input type = "text" name = "useradd"   size = "20" > </td></tr>
	
	<tr>
	<td colspan="2" width="5"><font color="black"><strong>
	Tel<td><input type = "text" name = "usertel"   size = "20"> </td></tr>
		
	<!-- // #부분에는 로그인 창으로 넘어가는 주소를 넣어야 함 -->
	<table border = "0">	
	<tr>
	<br><br>
	<td>&nbsp; &nbsp;<td colspan="2"><input type ="submit" name ="orbtn" value = "확인" /></td>
</form>



<!-- // #부분에는 로그인 창으로 넘어가는 주소를 넣어야 함 -->
<form action="LoginPage.jsp" method="post"><td>&nbsp; &nbsp; &nbsp;<input type ="submit" name ="orbtn" value = "뒤로가기" /></td></form>
</tr></table>


</font>
</center>
</table>

<% 
	if(session.getAttribute("input") == "1"){
		if(session.getAttribute("RESULT") == "ok"){
			String a = session.getAttribute("INSERT_ID").toString();
			out.println("<script type='text/javascript'> okCheck('"+a+"'); </script>");
		}
		else{
			out.println("<script type='text/javascript'> nonCheck(); </script>");
		}
	}
%>

</body>
</html>