<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title >회원탈퇴</title>

<script language="javascript">
    function deletefail(){
    	alert("비밀번호가 맞지 않습니다.");
    	<% session.setAttribute("USER_PASSWORD_MISSMATCH", "NO"); %>
    }
</script>
</head>

<body onload="begin()">
 <%
    		if(session.getAttribute("USER_PASSWORD_MISSMATCH")=="YES"){
    			out.println("<script type='text/javascript'> deletefail(); </script>");
    		}				
 %>   
    
	<font face="한컴 백제M"><br />    
    

    <form action="delete.do" name="deleteform" method="post" onSubmit="return checkIt()">
        <TABLE cellSpacing=1 cellPadding=1 width="260" border=1 align="center" >
	        <TR height="30">
	            <TD colspan="2" align="middle">
	                <font size="+1" ><b>회원 탈퇴</b></font>
	            </TD>
	        </TR>
	        
	        <TR height="30">
	            <TD width="110" align=center>Password</TD>
	            <TD width="150" align=center>
	                <INPUT type=password name="userpw"  size="15" >
	            </TD>
	        </TR>
	        
	        <TR height="30">
	            <TD colspan="2" align="middle">
	                <INPUT type="submit" value="탈퇴" "> 
	                <a href="mylist.do"><input type="button" value="취소" ></a>
	            </TD>
	        </TR>
        </TABLE>
    </form>
       
 </font>

</body>

<script language="javascript">

    function begin(){
      document.deleteform.userpw.focus();
    }

    function checkIt(){
 		if(!document.deleteform.userpw.value){
        alert("비밀번호를 입력하지 않으셨습니다.");
        document.deleteform.userpw.focus();
        return false;
       
      }
    }  
    
</script>
</html>