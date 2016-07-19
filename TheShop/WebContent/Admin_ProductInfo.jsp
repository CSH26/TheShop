<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
				<td><form action="Admin_CompList.do" method="post">
						<input type="submit" value="업체 관리"  style="height: 30px; width: 80px;">
					</form></td>

				<td><form action="report.do" method="post">
						<input type="submit" value="실적보고" style="height: 30px; width: 80px;">
					</form></td>
			</tr>
		</table>
	<table>
		<form action="Admin_ProductModify.do" method="post">
			<input type="hidden" name="pcode" value="${PROD_INfO.pcode}">
			<tr>
			<td>상품코드 : </td>
			<td>${Prod_Info.pcode}</td>
			</tr>
			<tr>
			      <td>상품명 : </td>
			      <td><input type="text" name ="pname" value = "${PROD_INfO.pname}"></td>
			</tr>
			<tr>
			       <td>판매가격 : </td>
			       <td><input type="text" name ="pcost" value ="${PROD_INfO.pcost}"></td>
		    </tr>
		    <tr>
		        <td>상품재고 : </td>
		        <td><input type="text" name ="pstock" value ="${PROD_INfO.pstock}"></td>
		    </tr>
		    <tr>
		        <td colspan ="2"><input type="submit" value="수정">&nbsp;&nbsp;&nbsp;<a href="Admin_ProductList.do">목록보기</a>
		        <a href="Admin_ProductDelete.do?pcode=${PROD_INfO.pcode}">삭제</a></td>
		    </tr>
		</form>
	</table>
	</center>
</body>
</html>