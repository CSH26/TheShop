<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>구매내역 보기</title>

</head>
<body>
	<h1>유저의 구매내역 및 개인정보 페이지</h1>
	<font face="한컴 백제 M">

		<table align="right">
			<tr>
				<form action="content_view.do" method="post" >
					<td><input type="submit" value="내 정보관리"></td>
				</form>
				<form action="User_Logout.jsp" method="post">
					<td><input type="submit" value="로그아웃"></td>
				</form>
			</tr>
		</table> <br> <br> <br>

		<table border="1" align="center" width="80%">

			<tr>

				<td><b>아이디</td>
				<td><b>상품코드</td>
				<td><b>상품명</td>
				<td><b>상품가격</td>
				<td><b>구매수량</td>
				<td><b>일시</td>

			</tr>
			<c:forEach items="${mylist}" var="PurListBean">
				<tr>
					<td>${PurListBean.userid}</td>
					<td>${PurListBean.pcode}</td>
					<td>${PurListBean.pname}</td>
					<td>${PurListBean.pcost}</td>
					<td>${PurListBean.pnum}</td>
					<td>${PurListBean.pdate}</td>
				</tr>
			</c:forEach>
		</table> <br> <br> <br> <br>

		<table align="right">
			<tr>
				<form action="allproductlist.do" method="post">
					<td><input type="submit" value="메인으로 이동" height="30"></td>
				</form>
			</tr>

		</table>
	</font>
</body>
</html>