<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<form action="Admin_ProductModify.do" method="post">
			<input type="hidden" name="pcode" value="${Prod_Info.pcode}">
			<tr>
			<td>상품코드 : </td>
			<td>${Prod_Info.pcode}</td>
			</tr>
			<tr>
			      <td>상품명 : </td>
			      <td><input type="text" name ="pname" value = "${Prod_Info.pname}"></td>
			</tr>
			<tr>
			       <td>판매가격 : </td>
			       <td><input type="text" name ="pcost" value ="${Prod_Info.pcost}"></td>
		    </tr>
		    <tr>
		        <td>상품재고 : </td>
		        <td><input type="text" name ="pstock" value ="${Prod_Info.pstock}"></td>
		    </tr>
		    <tr>
		        <td colspan ="2"><input type="submit" value="수정">&nbsp;&nbsp;&nbsp;<a href="Admin_ProductList.do">목록보기</a>
		        <a href="Admin_ProductDelete.do?pcode=${Prod_Info.pcode}">삭제</a></td>
		    </tr>
		</form>
	</table>
</body>
</html>