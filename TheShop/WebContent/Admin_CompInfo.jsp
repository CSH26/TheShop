<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function updatecomp(){
			alert("업체 정보가 변경되었습니다.");
			<%	session.setAttribute("ADMIN_CHANGED_COMPANY_STATE","NO"); %>
	}
	function update_fail_comp(){
		alert("업체 정보가 변경에 실패하였습니다.");
		<%	session.setAttribute("ADMIN_CHANGED_COMPANY_STATE","NO"); %>
	}
</script>
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
		<form action="Admin_CompModify.do" method="post">
			<input type="hidden" name="compcode" value="${Comp_Info.compcode}">
			<tr>
			<td>상품코드 : </td>
			<td>${Comp_Info.compcode}</td>
			</tr>
			<tr>
			      <td>업체명(ID) : </td>
			      <td><input type="text" name ="compname" value = "${Comp_Info.compname}"></td>
			</tr>
			<tr>
			       <td>비밀번호 : </td>
			       <td><input type="password" name ="comppw" value ="${Comp_Info.comppw}"></td>
		    </tr>
			<tr>
			       <td>주소 : </td>
			       <td><input type="text" name ="compadd" value ="${Comp_Info.compadd}"></td>
		    </tr>
		    <tr>
		        <td>전화번호 : </td>
		        <td><input type="text" name ="comptel" value ="${Comp_Info.comptel}"></td>
		    </tr>
		    <tr>
		        <td colspan ="2"><input type="submit" value="수정">&nbsp;&nbsp;&nbsp;<a href="Admin_CompList.do">목록보기</a>
		        </td>
		    </tr>
		</form>
	</table>
	
	<% 
		
			if(session.getAttribute("ADMIN_CHANGED_COMPANY_STATE") == "YES"){
				out.println("<script type='text/javascript'> updatecomp(); </script>");
			}else if(session.getAttribute("ADMIN_CHANGED_COMPANY_STATE") == "NO"){
				out.println("<script type='text/javascript'> update_fail_comp(); </script>");
			}

	%>
	</center>
</body>
</html>