<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>탈퇴 완료</title>
</head>

<body>
    
    <%
        session.invalidate();
	%>

<form method="post" action="LoginPage.jsp" name="userinput" >
    <table width="500" border="1" cellspacing="0" cellpadding="5" align="center">
        <tr> 
            <td height="39" align="center">
            <font size="+1" ><b>회원정보가  완전히 삭제되었습니다.</b></font></td>
        </tr>
        
        <tr>
            <td align="center"> 
                <p>이용해 주셔서 감사합니다.</p>
                <meta http-equiv="Refresh" content="5;url=main.jsp" >
            </td>
        </tr>
        
        <tr>
            <td align="center"> 
                <input type="submit" value="확인">
            </td>
        </tr>
    </table>
</form>


</body>
</html>