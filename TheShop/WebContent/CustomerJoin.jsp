<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
	function okCheck(a){
			alert("등록되지 않은 아이디입니다. 사용 가능합니다.");
			document.idform.userid.value=a;
			session.setAttribute("USER_ID_CHECK_ACCESS_COUNT","0");
	}
	function nonCheck(){
			alert("이미 등록된 아이디 입니다.");
			session.setAttribute("USER_ID_CHECK_ACCESS_COUNT","0");
	}
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> User Join</title>
</head>

<body>
<center>

<br /><br /><br /><br /><br /><br />

<input type="image" src="http://localhost:8180/TheShop/user.png"><br /><br />


	<form action="idcheck.do" method="post" name="idform">
		<table border = "0"> 
			<tr>
				<td colspan="2" width="5"><font color="black" >
				ID</font></td>
				<td><input type = "text" align="center" name = "userid" size = "10"></td>
				
				<!-- // #부분에는 중복 환인 창으로 넘어가는 주소를 넣어야 함 -->
				<td>&nbsp; &nbsp; &nbsp;<input type ="submit" value = "중복 확인" /></td> 
			</tr>
		</table>
	</form>
	
	<form action="write.do" method="post">
		<table>
			<tr>
				<td colspan="2" width="5"><font color="black">
				Name</font></td><td><input type = "text" name = "username"  size = "10"></td>
			</tr>
			<tr>
				<td colspan="2" width="5"><font color="black">
				Password</font></td><td><input type = "text" name = "userpw" size = "10" ></td>
			</tr>
			<tr>
				<td colspan="2" width="5"><font color="black">
				Address</font></td>
				<td><input type = "text" name = "useradd"   size = "20" > </td>
			</tr>
			<tr>
				<td colspan="2" width="5"><font color="black">
				Tel</font></td>
				<td><input type = "text" name = "usertel"   size = "20"> </td>
			</tr>
				
			<!-- // #부분에는 로그인 창으로 넘어가는 주소를 넣어야 함 -->
			<tr>
				<td>&nbsp; &nbsp;<td colspan="2"><input type ="submit" name ="orbtn" value = "확인" /></td>
				<td> <a href=""></a><input type="button" LoginPage.jsp" method="post"e<td>&nbsp; &nbsp; &nbsp;<input type ="submit" name ="orbtn" value = "뒤로가기" /></td></form></td>
			</tr>
		</table>
	</form>

</center>


<% 
	if(session.getAttribute("USER_ID_CHECK_ACCESS_COUNT") == "1"){
		if(session.getAttribute("RESULT") == "OK"){
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