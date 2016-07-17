<%@page import="java.sql.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>안녕하세요</title>
</head>
<body>
	<center>
		<table>
			<tr>
				<td align="center"><img src="main.jpg"></td>
			</tr>

			<tr>
				<td align="center"><h1>Product List</h1></td>
			</tr>
			<tr>
				<td align="center">
					<table border="1">
						<tr>
							<th>상품코드</th>
							<th>상품명</th>
							<th>판매가</th>
							<th>재고</th>
						</tr>
						<c:forEach items="${ProductList}" var="dto">
							<tr>
								<td align="center"><a href="productInfo.do?pcode=${dto.pcode}">${dto.pcode}</td>
								<td align="left">${dto.pname}</td>
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