<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title >유저 정보 수정 페이지</title>

<script language="javascript">
    function changeState(){
    	alert("사용자 정보가  변경 되었습니다.");
    	session.setAttribute("USER_CHANGE_STATE", "NO");
    }
</script>
</head>

<body>
<%
    		if(session.getAttribute("USER_CHANGE_STATE")=="YES"){
    			out.println("<script type='text/javascript'> changeState(); </script>");
    		}				
 %>
<center>
<br /><br /><br /><br /><br /><br />
<table border = "0"> 
<form>
	
	<input type="image" src="http://localhost:8180/TheShop/user.png"><br /><br />
	
	
	<font face="맑은고딕"><br />
	</font>
</form>
</table>

<form action="modify.do" method="post">
	<!--  <td colspan="2" width="5"><font color="black" ><strong>
	ID<td><input type = "text" align="center" name = "userid" size = "10"></td><td>-->
	<table>
	<tr>
		<td colspan="2" width="5"><font color="black" ><strong> ID</td>
		<td><input type = "text" align="center" name = "userid" size = "10" value="${CONTENT_VIEW.userid}"></td>
	</tr>
	<tr>
		<td colspan="2" width="5"><font color="black"><strong> Password</td>
		<td><input type = "text" name = "userpw" size = "10" value = "${CONTENT_VIEW.userpw}"></td>
	</tr>
	<tr>
		<td colspan="2" width="5"><font color="black"><strong>Name</td>
		<td><input type = "text" name = "username"  size = "10" value = "${CONTENT_VIEW.username}"></td>
	</tr>
	<tr>
		<td colspan="2" width="5"><font color="black"><strong>Address</td>
		<td><input type = "text" name = "useradd" size = "10" value = "${CONTENT_VIEW.useradd}"></td>
	</tr>
	<tr>
		<td colspan="2" width="5"><font color="black"><strong>Tel</td>
		<td><input type = "text" name = "usertel"   size = "20" value = "${CONTENT_VIEW.usertel}"> </td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value = "수정"></td>  <td colspan="2"><a href="mylist.do"> 돌아가기</a></td>  <td colspan="2"><a href="User_DeletePage.jsp"> 회원 탈퇴</a></td>
	</tr>
</table>
</center>
</form>

</body>
</html>