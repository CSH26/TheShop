<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title >유저 정보 수정 페이지</title>

<script language="javascript">
    function changeState(){
    	alert("상품 정보가  변경 되었습니다.");
    	<% session.setAttribute("COMPANY_PRODUCT_CHANGE_STATE", "DENY");%>
    }
    function deleteState(){
    	alert("상품이 삭제 되었습니다.");
    	<% session.setAttribute("COMPANY_PRODUCT_DELETE_STATE", "DENY");%>
    }
</script>
</head>

<body>
<%
    		if(session.getAttribute("COMPANY_PRODUCT_CHANGE_STATE")=="YES"){
    			out.println("<script type='text/javascript'> changeState(); </script>");
    		}	

			if(session.getAttribute("COMPANY_PRODUCT_DELETE_STATE")=="YES"){
				out.println("<script type='text/javascript'> deleteState(); </script>");
			}
 %>
<center>
<br /><br /><br /><br /><br /><br />
<table border = "0"> 
<form>
	
	<input type="image" src="http://localhost:8080/TeamProj/user.png"><br /><br />
	
	
	<font face="맑은고딕"><br />
	</font>
</form>
</table>

<form action="comp_product_modify.do" method="post">
	<!--  <td colspan="2" width="5"><font color="black" ><strong>
	ID<td><input type = "text" align="center" name = "userid" size = "10"></td><td>-->
	<table>
	<tr align="center">
		<td> 상품코드는 변경할 수 없습니다. </td>
	</tr>
	<tr>
		<td colspan="2" width="5"><font color="black" ><strong> ProductCode</td>
		<td><input type = "text" align="center" name = "pcode" size = "10" value="${PRODUCT_UPDATE_VIEW.pcode}" readonly="readonly"></td>
	</tr>
	<tr>
		<td colspan="2" width="5"><font color="black"><strong> 상품명</td>
		<td><input type = "text" name = "pname" size = "10" value = "${PRODUCT_UPDATE_VIEW.pname}"></td>
	</tr>
	<tr>
		<td colspan="2" width="5"><font color="black"><strong> 상품 수량 </td>
		<td><input type = "text" name = "pstock"  size = "10" value = "${PRODUCT_UPDATE_VIEW.pstock}"></td>
	</tr>
	<tr>
		<td colspan="2" width="5"><font color="black"><strong>상품 가격</td>
		<td><input type = "text" name = "pcost" size = "10" value = "${PRODUCT_UPDATE_VIEW.pcost}"></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value = "수정"></td>   <td colspan="2"><a href="company_product_delete.do?pcode=${PRODUCT_UPDATE_VIEW.pcode}"> 삭제</a></td>  <td colspan="2"><a href="company_productlist.do"> 돌아가기</a></td>  
	</tr>
</table>
</center>
</form>

</body>
</html>