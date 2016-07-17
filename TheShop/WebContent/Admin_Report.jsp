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
<h1> 관리자 페이지(실적보고 )</h1>
<table>

         <tr>
         
            <td align="right">
               <table>
               
                  <tr>
                  </tr>
                  	<tr>
                	  </tr>
                	  

				<tr> <!-- 로그아웃 누르면 첫 로그인 페이지로 이동! -->
				<td align="center" colspan="4"><td><a href="logout.do"><input type="button" value="Log out" style="height:30px; width: 65px;"></a>&nbsp;
				 <!-- 상품 정보 관리가 뭔지 몰라서 아직 못함 -->
				<a href="http://192.168.100.42:8080/TheShop/Company_AddProduct.jsp"><input type="button" value="상품정보관리" style="height:30px; width: 110px; "></a></td></tr>

  </table>
      	
      	<form action="compnewitem.do">
		<td colspan="4"><td><input type="submit" value ="상품 등록" style="height:30px; width: 90px; "></td></tr>
		</form>
	
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