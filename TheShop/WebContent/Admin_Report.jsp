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

<table>
         <tr>
            <td align="right">
               <table>
               
                  <tr>
                  </tr>
                  	<tr>
                	  </tr>
                	 

				<tr> <!-- 로그아웃 누르면 첫 로그인 페이지로 이동! -->
				<td align="center" colspan="4"><td><a href="logout.do"><input type="button" value="Log out" style="height:30px; width: 80px;"></a>&nbsp;</td>
				 <!-- 상품 정보 관리가 뭔지 몰라서 아직 못함 -->
				<td>
					<form action="Admin_CustomerList.do" method="post">
						<input type="submit" value="고객 관리"  style="height: 30px; width: 80px;">
					</form>
				</td>

				<td><form action="Admin_CompList.do" method="post">
						<input type="submit" value="업체 관리"  style="height: 30px; width: 80px;">
					</form></td>

				<td><form action="Admin_ProductList.do" method="post">
						<input type="submit" value="제품 관리" style="height: 30px; width: 80px;">
					</form></td>
					</tr>

  </table>
      	
      	
	<table border="1">
		<tr>
			<td> 유저명 </td>
			<td> 상품코드 </td>
			<td> 상품명 </td>
			<td> 구매량 </td>
			<td> 구매일자 </td>
			
		</tr>
		
		<c:forEach items = "${ALL_REPORT_LIST}" var="pur">
		<tr>
			<td> ${pur.userid} </td>
			<td> ${pur.pcode} </td>
			<td> ${pur.pname} </td>
			<td> ${pur.pnum} </td>		
			<td> ${pur.pdate} </td>		
			</tr>
			</c:forEach>
	
	</table>
</center>
</body>
</html>