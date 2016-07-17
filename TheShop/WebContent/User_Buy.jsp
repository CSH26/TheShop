<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language="javascript">
    function sessionId(){
    	<%
    		session.setAttribute("USER",session.getAttribute("USER_LOGIN_CHECK").toString()); 
    	%>	
    }
</script>
</head>
<body onload="sessionId()">

	<center>
		<h1>${buy.pname}</h1>
		<h3>상품 이미지</h3>
	</center>
	<form action="buyOK.do" method="post">
		 
		<input type="hidden" name="pname" value="${buy.pname}"> 
		<input type="hidden" name="pcode" value="${buy.pcode}"> 
		<input type="hidden" name="pstock" value="${buy.pstock}">
		<table align="center">
			
			<tr>
				<td>상품코드 :</td>
				<td align="center">${buy.pcode}</td>
			</tr>
			<tr>
				<td>판매가 :</td>
				<td align="right">￦ ${buy.pcost}</td>
			</tr>
			<tr>
				<td>남은 상품 :</td>
				<td align="center">${buy.pstock}개</td>
			</tr>
			<tr>
				<td>구매 수량 :</td>
				<td align="center"><input type="text" name="pnum" size="5"
					style="text-align: right"></td>
			</tr>
			<tr>
				<td></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="구매하기">&nbsp;&nbsp;&nbsp;
					<a href="allproductlist.do">돌아가기</a></td>
			</tr>
		</table>
	</form>
</body>
</html>