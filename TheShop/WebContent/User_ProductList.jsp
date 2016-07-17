<%@page import="java.sql.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script language="javascript">
    function sessionId(){
    	<%
    		session.setAttribute("USER",session.getAttribute("USER_LOGIN_CHECK").toString()); 
    	%>	
    }
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>안녕하세요</title>
</head>
<body onload="sessionId()">

	<center>
		<table>
			<tr>
				<td align="center"><img src="main.jpg"></td>
			</tr>
			<tr>
				<td align="right">
					<table>
						<tr>
							<td align="center" colspan="2"><%=session.getAttribute("USER_LOGIN_CHECK").toString() %>님 어서오세요 :) </td>
						</tr>
						<tr>
							<td align="center">
							<td><a href ="User_Logout.jsp"><input type="button" value="Logout" style="height: 30px; width: 60px;"> </a></td>
							<td><a href ="mylist.do"><input type="button" value="MyPage" style="height: 30px; width: 71px;"></a></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td align="center"><h1>Product List</h1></td>
			</tr>
			<tr>
				<td align="center">
					<table border="1">
						<tr>
							<th>상품코드</th>
							<th>&nbsp;&nbsp;&nbsp;상품명&nbsp;&nbsp;&nbsp;</th>
							<th>판매가</th>
							<th>재고</th>
							
						</tr>
						<c:forEach items="${ALL_PRODUCT_LIST}" var="dto">
							<tr>
								<td align="left">${dto.pcode}</td>
								<td align="left"><a href="buy.do?pcode=${dto.pcode}">${dto.pname} </a></td>
								<td align="right">￦ ${dto.pcost}</td>
								<td align="right">${dto.pstock}</td>
								
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
		</table>
	</center>
</body>
</html>