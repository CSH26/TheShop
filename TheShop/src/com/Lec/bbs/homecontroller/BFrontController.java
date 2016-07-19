package com.Lec.bbs.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Lec.bbs.command.BAdminCompInfo;
import com.Lec.bbs.command.BAdminCompList;
import com.Lec.bbs.command.BAdminCompModifyCommand;
import com.Lec.bbs.command.BAdminLogonCommand;
import com.Lec.bbs.command.BAdminProdDeleteCommand;
import com.Lec.bbs.command.BAdminProdInfo;
import com.Lec.bbs.command.BAdminProdList;
import com.Lec.bbs.command.BAdminProdModify;
import com.Lec.bbs.command.BAdminUserCommand;
import com.Lec.bbs.command.BAllProductListCommand;
import com.Lec.bbs.command.BBuyCommand;
import com.Lec.bbs.command.BCommand;
import com.Lec.bbs.command.BCompCheckCommand;
import com.Lec.bbs.command.BCompDetailProductListCommand;
import com.Lec.bbs.command.BCompLogonCommand;
import com.Lec.bbs.command.BCompModifyCommand;
import com.Lec.bbs.command.BCompNewItemCommand;
import com.Lec.bbs.command.BCompProductListCommand;
import com.Lec.bbs.command.BCompProductModifyCommand;
import com.Lec.bbs.command.BCompanyDeleteProductCommand;
import com.Lec.bbs.command.BCompinfoCommand;
import com.Lec.bbs.command.BContentCommand;
import com.Lec.bbs.command.BDeleteCommand;
import com.Lec.bbs.command.BIdcheckCommand;
import com.Lec.bbs.command.BListCommand;
import com.Lec.bbs.command.BLogonCommand;
import com.Lec.bbs.command.BLogoutcommand;
import com.Lec.bbs.command.BModifyCommand;
import com.Lec.bbs.command.BMylistCommand;
import com.Lec.bbs.command.BReportCommand;
import com.Lec.bbs.command.BWriteCommand;
import com.Lec.bbs.command.BWriteCompCommand;
import com.Lec.bbs.command.BbuyOKCommand;

@WebServlet("*.do")
public class BFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("actionDo");
		request.setCharacterEncoding("UTF-8");
		
		String viewPage = null;
		BCommand command = null;
		HttpSession session = request.getSession();
		
		String uri = request.getRequestURI();				//     /MVC/*.do 까지의 uri를 가져오기
		String conPath = request.getContextPath();		//   mvc==context
		String com  = uri.substring(conPath.length()); //
		
		switch (com) {
		case ("/list.do"):
			command = new BListCommand();  // 커맨드  타입 상속
			command.excute(request, response);
			viewPage = "list.jsp";
			break;
		case ("/write_view.do"):
			viewPage = "write_view.jsp";
			break;
		case ("/write.do"):
			command = new BWriteCommand();  // 커맨드  타입 상속
			command.excute(request, response);
			int ok = (int) request.getAttribute("USER_INSERT_RESULT");
			if(ok==1){
				viewPage = "User_JoinComplete.jsp";
			}
			else{
				viewPage = "Error.jsp";
			}
			break;
		case ("/writecomp.do"):
			command = new BWriteCompCommand();  // 커맨드  타입 상속
			command.excute(request, response);
			int compok = (int) request.getAttribute("COMP_INSERT_RESULT");
			if(compok==1){
				viewPage = "Comp_JoinComplete.jsp";
			}
			else{
				viewPage = "Error_comp.jsp";
			}
			break;
		case ("/content_view.do"): // 유저 상세정보 가져오기
			command = new BContentCommand();  
			command.excute(request, response);
			viewPage = "User_Mypage_Modify.jsp";
			break;
		case ("/modify.do"): // 유저 정보 업데이트
			command = new BModifyCommand();  
			command.excute(request, response);
			session.setAttribute("USER_CHANGE_STATE", "YES");
			viewPage = "User_Mypage_Modify.jsp";
			break;
		case ("/delete.do"):
			command = new BDeleteCommand();  // 커맨드  타입 상속
			command.excute(request, response);
			if(session.getAttribute("USER_DEL_RESULT")=="SUCCESS"){
				viewPage = "User_DeleteComplete.jsp";
			}
			else if(session.getAttribute("USER_DEL_RESULT")=="FAIL"){
				session.setAttribute("USER_PASSWORD_MISSMATCH", "YES");
				viewPage = "User_DeletePage.jsp";
			}
	
			break;
		case ("/logon.do"): // 유저 아이디 검사하기
 			command = new BLogonCommand();  
			command.excute(request, response);
			if(session.getAttribute("USER_LOGIN_CHECK")=="NONE"){
				viewPage = "LoginPage.jsp";
				session.setAttribute("ACCESS_COUNT","1");
				session.setAttribute("RESULT","UN_ACCESSIBLE");
			}
			else{
				viewPage = "allproductlist.do"; // 등록된 유저면 모든 상품리스트를 보여주는 페이지로 이동
			}
			break;
		case ("/allproductlist.do"): // 로그인 성공 후 모든 상품을 보여주는 페이지
			command = new BAllProductListCommand();  // 상품 리스트 커맨드
			command.excute(request, response);	
			viewPage = "User_ProductList.jsp";
			break;
		case ("/complogon.do"):
			command = new BCompLogonCommand();  // 커맨드  타입 상속
			command.excute(request, response);	
			if(session.getAttribute("COMP_LOGIN_CHECK")=="NONE"){
				viewPage = "CompanyLoginPage.jsp";
				session.setAttribute("COMP_LOGIN_FLAG","1");
				session.setAttribute("COMP_LOGIN_RESULT","UN_ACCESSIBLE");
			}
			else{
				viewPage = "company_productlist.do";
			}
			break;
		case ("/company_productlist.do"):
			command = new BCompProductListCommand();  // 커맨드  타입 상속
			command.excute(request, response);	
			viewPage = "Company_ProductList.jsp";
			break;
		case ("/company.do"):
			viewPage = "CompanyLoginPage.jsp";	
			break;
		case ("/idcheck.do"):
			command = new BIdcheckCommand();  // 커맨드  타입 상속
			command.excute(request, response);
			if(session.getAttribute("USER_ID_CHECK")=="NONE"){
				session.setAttribute("USER_ID_CHECK_ACCESS_COUNT","1");
				session.setAttribute("RESULT","OK");
				viewPage = "CustomerJoin.jsp";
			}
			else{
				session.setAttribute("RESULT","NO");
				session.setAttribute("USER_ID_CHECK_ACCESS_COUNT","1");
				viewPage = "CustomerJoin.jsp";
			}
			break;
		case ("/compcheck.do"):
			command = new BCompCheckCommand();  // 커맨드  타입 상속
			command.excute(request, response);
			if(session.getAttribute("COMP_CODE_CHECK")=="NONE"){
				session.setAttribute("COMP_ID_CHECK_ACCESS_COUNT","1");
				session.setAttribute("COMP_RESULT","OK");
				viewPage = "CompanyJoin.jsp";
			}
			else{
				session.setAttribute("COMP_RESULT","NO");
				session.setAttribute("COMP_ID_CHECK_ACCESS_COUNT","1");
				viewPage = "CompanyJoin.jsp";
			}
			break;
		case ("/admin.do"):
			viewPage = "AdminLoginPage.jsp";
			break;
		case ("/adminlogon.do"):
			command = new BAdminLogonCommand();  // 커맨드  타입 상속
			command.excute(request, response);
			if(session.getAttribute("ADMIN_LOGIN_CHECK")=="OK"){
				viewPage = "Admin_Main.jsp";
			
			}
			else if(session.getAttribute("ADMIN_LOGIN_CHECK")=="DENY"){
				session.setAttribute("ADMIN_LOGIN_FLAG","1");
				viewPage = "AdminLoginPage.jsp";
			}
			break;
		case ("/compnewitem.do"):
			command = new BCompNewItemCommand();  // 커맨드  타입 상속
			command.excute(request, response);
			int compNewItemok = (int) request.getAttribute("COMP_ITEM_INSERT_RESULT");
			if(compNewItemok==1){
				viewPage = "company_productlist.do";
				session.setAttribute("COMP_CREATE_ITEM_DENY","NO");
				session.setAttribute("COMP_CREATE_ITEM_ACCESS_COUNT","1");
			}
			else{
				session.setAttribute("COMP_CREATE_ITEM_DENY","YES");
				session.setAttribute("COMP_CREATE_ITEM_ACCESS_COUNT","1");
				viewPage = "company_productlist.do";
			}
			break;
		case ("/buy.do"):
			command = new BBuyCommand();
			command.excute(request, response);
			viewPage = "User_Buy.jsp";
			break;
		case ("/buyOK.do"):
			command = new BbuyOKCommand();
			command.excute(request, response);
			viewPage = "mylist.do";
			break;
		case ("/mylist.do"):
			command = new BMylistCommand(); // 커맨드 타입 상속
			command.excute(request, response);
			viewPage = "User_Mypage.jsp";
			break;
		case ("/comp_detail.do"):
			command = new BCompinfoCommand();  // 커맨드  타입 상속
			command.excute(request, response);
			viewPage = "Company_Modify.jsp";
			break;
		case ("/comp_modify.do"):
			command = new BCompModifyCommand();  // 커맨드  타입 상속
			command.excute(request, response);
			if((int)request.getAttribute("COMP_MODIFY_RESULT") == 1){
				session.setAttribute("COMPANY_CHANGE_STATE", "YES");
				viewPage = "Company_Modify.jsp";
			}
			else{
				session.setAttribute("COMPANY_CHANGE_STATE", "DENY");
				viewPage = "Company_Modify.jsp";
			}
			break;
		case ("/comp_product_manage.do"):
			command = new BCompProductListCommand();  // 커맨드  타입 상속
			command.excute(request, response);	
			viewPage = "Company_ProductModify.jsp";
			break;
		case ("/comp_detail_product.do"):
			command = new BCompDetailProductListCommand();  // 커맨드  타입 상속
			command.excute(request, response);	
			viewPage = "Company_ProductUpdateView.jsp";
			break;
		case ("/comp_product_modify.do"):
			command = new BCompProductModifyCommand();  // 커맨드  타입 상속
			command.excute(request, response);
			if((int)request.getAttribute("COMP_PRODUCT_MODIFY_RESULT") == 1){
				session.setAttribute("COMPANY_PRODUCT_CHANGE_STATE", "YES");
				viewPage = "Company_ProductUpdateView.jsp";
			}
			else{
				session.setAttribute("COMPANY_PRODUCT_CHANGE_STATE", "DENY");
				viewPage = "Company_ProductUpdateView.jsp";
			}
			break;
		case ("/company_product_delete.do"):
			command = new BCompanyDeleteProductCommand();  // 커맨드  타입 상속
			command.excute(request, response);
			if(request.getAttribute("COMP_PRODUCT_DEL_RESULT")=="SUCCESS"){
				session.setAttribute("COMPANY_PRODUCT_DELETE_STATE", "YES");
				viewPage = "Company_ProductUpdateView.jsp";
			}
			else {
				session.setAttribute("COMPANY_PRODUCT_DELETE_STATE", "DENY");
				viewPage = "Company_ProductUpdateView.jsp";
			}
			break;
		case ("/Admin_CustomerList.do"):
			command = new BAdminUserCommand(); // 커맨드 타입 상속
			command.excute(request, response);
			viewPage = "Admin_Userinfo.jsp";
			break;
		case ("/Admin_CompList.do"):
			command = new BAdminCompList(); // 커맨드 타입 상속
			command.excute(request, response);
			viewPage = "Admin_CompList.jsp";
			break;
		case ("/CompInfo.do"):
			command = new BAdminCompInfo(); // 커맨드 타입 상속
			command.excute(request, response);
			viewPage = "Admin_CompInfo.jsp";
			break;
		case ("/Admin_ProductList.do"):
			command = new BAdminProdList(); // 커맨드 타입 상속
			command.excute(request, response);
			viewPage = "Admin_ProductList.jsp";
			break;
		case ("/productInfo.do"):
			command = new BAdminProdInfo(); // 커맨드 타입 상속
			command.excute(request, response);
			viewPage = "Admin_ProductInfo.jsp";
			break;
		case ("/Admin_ProductModify.do"):
			command = new BAdminProdModify(); // 커맨드 타입 상속
			command.excute(request, response);
			viewPage = "Admin_ProductList.do";
			break;
		case ("/Admin_ProductDelete.do"):
			command = new BAdminProdDeleteCommand();
			command.excute(request, response);
			viewPage = "Admin_ProductList.do";
			break;
		case ("/report.do"):
			command = new BReportCommand(); 
			command.excute(request, response);
			viewPage = "Admin_Report.jsp";
			break;
		case ("/logout.do"):
			command = new BLogoutcommand();
			command.excute(request, response);
			viewPage = "AdminLoginPage.jsp";
			break;
		case ("/Admin_CompModify.do"):
			command = new BAdminCompModifyCommand(); 
			command.excute(request, response);
			if(request.getAttribute("ADMIN_COMP_MODIFY_RESULT")=="SUCCESS"){
				session.setAttribute("ADMIN_CHANGED_COMPANY_STATE", "YES");
				viewPage = "Admin_CompInfo.jsp";
			}
			else{
				session.setAttribute("ADMIN_CHANGED_COMPANY_STATE", "NO");
				viewPage = "Admin_CompInfo.jsp";
			}
			break;
		default:
			break;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	
	}

}
