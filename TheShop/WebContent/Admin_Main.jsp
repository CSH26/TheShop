<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자 페이지</title>
</head>
<body>
	<h1>
		<center>관 리 자 페 이 지</center>
	</h1>
	<center>
		<table>
			<tr>
				<td>
					<form action="Admin_CustomerList.do" method="post">
						<input type="submit" value="고객 관리"  style="height: 80px; width: 80px;">
					</form>
				</td>

				<td><form action="Admin_CompList.do" method="post">
						<input type="submit" value="업체 관리"  style="height: 80px; width: 80px;">
					</form></td>

				<td><form action="Admin_ProductList.do" method="post">
						<input type="submit" value="제품 관리" style="height: 80px; width: 80px;">
					</form></td>

				<td><form action="report.do" method="post">
						<input type="submit" value="실적보고" style="height: 80px; width: 80px;">
					</form></td>
			</tr>
		</table>
	</center>
</body>
</html>