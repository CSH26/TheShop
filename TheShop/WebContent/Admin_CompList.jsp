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
				<td align="center" colspan="4"><td><a href="logout.do"><input type="button" value="Log out" style="height:30px; width: 80px;"></a>&nbsp;</td>
				<td>
					<form action="Admin_CustomerList.do" method="post">
						<input type="submit" value="고객 관리"  style="height: 30px; width: 80px;">
					</form>
				</td>
				<td><form action="Admin_ProductList.do" method="post">
						<input type="submit" value="제품 관리" style="height: 30px; width: 80px;">
					</form></td>

				<td><form action="report.do" method="post">
						<input type="submit" value="실적보고" style="height: 30px; width: 80px;">
					</form></td>
			</tr>
		</table>
		
		<table>
			<tr>
				<td align="center"></td>
			</tr>

			<tr>
				<td align="center"><h1>Company List</h1></td>
			</tr>
			<tr>
				<td align="center">
					<table border="1">
						<tr>
							<th>업체코드(ID)</th>
							<th>업체명</th>
							<th>주소</th>
							<th>전화번호</th>
						</tr>
						<c:forEach items="${CompList}" var="dto">
							<tr>
								<td align="center"><a href="CompInfo.do?compcode=${dto.compcode}">${dto.compcode}</td>
								<td align="left">${dto.compname}</td>
								<td align="right">${dto.compadd}</td>
								<td align="right">${dto.comptel}</td>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
		</table>
	</center>
</body>
</html>