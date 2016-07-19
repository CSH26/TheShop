<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<h1> 제품 관리 </h1>
	<table>
         <tr>
         
            <td align="right">
               <table>
               
                  <tr>
                  </tr>
                  	<tr>
                	  </tr>
                	  

				<tr> <!-- 로그아웃 누르면 로그인 페이지로 이동! 하이퍼로 걸었음 form 넣으면 테이블 붕괴-->
				<td align="center" colspan="4"><td><a href="Company_Logout.jsp"><input type="button" value="Log out" style="height:30px; width: 60px;"></a>&nbsp;&nbsp;</td>
				 <!-- 마이 페이지 누르면 업체 내 정보 관리 페이지로 이동! 하이퍼로 걸었음 form 넣으면 테이블 붕괴 -->
				<td> <a href="company_productlist.do"><input type="button" value="제품 리스트" style="height:30px; width: 100px; "></a></td>
				<td> <a href="comp_detail.do"><input type="button" value="업체정보변경" style="height:30px; width: 100px; "></a></td>
				</tr>

  </table>
      	<form action="Company_CreateItem.jsp">
				<td colspan="4"><td><input type="submit" value ="상품 등록" style="height:40px; width: 148px; "></td></tr>
		</form>
	<table border="1">
		<tr>
			<td> 상품코드 </td>
			<td> 상품명 </td>
			<td> 수량 </td>
			<td> 가격 </td>
			
		</tr>
		
		<c:forEach items = "${COMP_PRODUCT_LIST}" var="pro">
		<tr>
			<td> <a href="comp_detail_product.do?pcode=${pro.pcode}">${pro.pcode} </a></td>
			<td> ${pro.pname} </td>
			<td> ${pro.pstock} </td>
			<td> ${pro.pcost} </td>		
				
		</tr>
		</c:forEach>
		
	</table>
</center>
</body>
</html>