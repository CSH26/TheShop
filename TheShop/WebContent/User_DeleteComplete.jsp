<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Ż�� �Ϸ�</title>
</head>

<body>
    
    <%
        session.invalidate();
	%>

<form method="post" action="LoginPage.jsp" name="userinput" >
    <table width="500" border="1" cellspacing="0" cellpadding="5" align="center">
        <tr> 
            <td height="39" align="center">
            <font size="+1" ><b>ȸ��������  ������ �����Ǿ����ϴ�.</b></font></td>
        </tr>
        
        <tr>
            <td align="center"> 
                <p>�̿��� �ּż� �����մϴ�.</p>
                <meta http-equiv="Refresh" content="5;url=main.jsp" >
            </td>
        </tr>
        
        <tr>
            <td align="center"> 
                <input type="submit" value="Ȯ��">
            </td>
        </tr>
    </table>
</form>


</body>
</html>