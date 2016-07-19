package com.Lec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.Lec.bbs.dto.BDto;
import com.Lec.bbs.dto.CompListBean;
import com.Lec.bbs.dto.CompanyBean;
import com.Lec.bbs.dto.ProductBean;
import com.Lec.bbs.dto.PurListBean;
import com.Lec.bbs.dto.UserBean;

public class BDao {
	
	DataSource dataSource;
	DataSource dataSource2;

	public BDao() {
		try{
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
			dataSource2 = (DataSource) context.lookup("java:comp/env/jdbc/project");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public int delete(String userid, String userpw){
		int result_Code = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
	    try{
	    	connection = dataSource2.getConnection();
	    	
	    	String query = "delete from userinfo where userid = ? and userpw = ?";
		    preparedStatement = connection.prepareStatement(query);
		 
		    preparedStatement.setString(1, userid);
		    preparedStatement.setString(2, userpw);
		    result_Code = preparedStatement.executeUpdate();

	    } catch(Exception e){
			e.printStackTrace();
			
		}finally {
			try{
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	    return result_Code;
	   
	}

	public void modify(String userid, String userpw, String username, String useradd, String usertel){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
	    try{
	    	connection = dataSource2.getConnection();
	    	
	    	String query = "update userinfo set userpw = ?, username = ?, useradd = ?, usertel = ? where userid = ? and userpw = ?";
		    preparedStatement = connection.prepareStatement(query);
		  
		    preparedStatement.setString(1, userpw);
		    preparedStatement.setString(2, username);
		    preparedStatement.setString(3, useradd);
		    preparedStatement.setString(4, usertel);
		    preparedStatement.setString(5, userid);
		    preparedStatement.setString(6, userpw);
		 
		    preparedStatement.executeUpdate();

	        
	    } catch(Exception e){
			e.printStackTrace();
			
		}finally {
			try{
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	public ArrayList<UserBean> list(){
		ArrayList<UserBean> dtos = new ArrayList<UserBean>();
	    Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int count = 0;
		try{
			connection = dataSource2.getConnection();
			
			String query = "select * from student_rank";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				count++;
				String userid = resultSet.getString("userid");
				String userpw = resultSet.getString("userpw");
				String username = resultSet.getString("username");
				String useradd = resultSet.getString("useradd");
				String usertel = resultSet.getString("usertel");
				UserBean bDto = new UserBean(userid, userpw, username, useradd, usertel);
				dtos.add(bDto);
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
			
		}finally {
			try{
	
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	
		return dtos;
	}
	
	// 유저 상세정보 
	public UserBean contentView(String userid){
		
		UserBean dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
	
		try{
			connection = dataSource2.getConnection();
			String query = "select * from userinfo where userid = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userid);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()){
				String userpw = resultSet.getString(2);
				String username = resultSet.getString(3);
				String useradd = resultSet.getString(4);
				String usertel = resultSet.getString(5);
				
				dto = new UserBean(userid, userpw, username, useradd, usertel);
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try{
		
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return dto;
	}

	public int write(String userid, String userpw, String username, String useradd, String usertel) {
		  	Connection connection = null;
			PreparedStatement preparedStatement = null;
			int result_Code = 0;
			
			try{
				connection = dataSource2.getConnection();
			    String query = "insert into userinfo (userid, userpw, username, useradd, usertel) values (?,?,?,?,?)";
			    preparedStatement = connection.prepareStatement(query);
			    preparedStatement.setString(1, userid);
			    preparedStatement.setString(2, userpw);
			    preparedStatement.setString(3, username);
			    preparedStatement.setString(4, useradd);
			    preparedStatement.setString(5, usertel);

			    result_Code = preparedStatement.executeUpdate();
			   
			} 
			catch (Exception e){
			    e.printStackTrace();
			}finally {
				try{
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		return result_Code;
	}
	
	public ArrayList<ProductBean> companyProductList(String compcode){
		ArrayList<ProductBean> probeans = new ArrayList<ProductBean>();
	    Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
	
		try{
			connection = dataSource2.getConnection();
			
			String query = "select * from productinfo where compcode = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, compcode);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				String pcode = resultSet.getString("pcode");
				String pname = resultSet.getString("pname");
				String pstock = resultSet.getString("pstock");
				String pcost = resultSet.getString("pcost");
				ProductBean product = new ProductBean(pcode, pname, pstock, pcost);
				probeans.add(product);
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
			
		}finally {
			try{
	
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	
		return probeans;
	}
	
	public String complogonCheck(String compcode, String comppw){
		  Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			String compTemp = "none";
			try{
				connection = dataSource2.getConnection();
				
				String query = "select compcode from companyinfo where compcode = ? and comppw = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, compcode);
				preparedStatement.setString(2, comppw);
				resultSet = preparedStatement.executeQuery();
				
				if(resultSet.next()){
					compTemp = resultSet.getString("compcode");
				}
			}catch(Exception e){
				e.printStackTrace();
				
			}finally {
				try{
		
					if(resultSet != null) resultSet.close();
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		
			return compTemp;
	}
	
	//등록된 유저인지 체크하는 메서드
	public String logonCheck(String userid, String userpw){
		
	    Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String userTemp = "NONE";
		try{
			connection = dataSource2.getConnection();
			
			String query = "select userid from userinfo where userid = ? and userpw = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userid);
			preparedStatement.setString(2, userpw);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()){
				userTemp = resultSet.getString("userid");
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}finally {
			try{
	
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	
		return userTemp;
	}
	
	public String idCheckTest(String userid){
		 	Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			String userTemp = "NONE";
			try{
				connection = dataSource2.getConnection();
				
				String query = "select userid from userinfo where userid = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, userid);
				resultSet = preparedStatement.executeQuery();
				
				if(resultSet.next()){
					userTemp = resultSet.getString("userid");
				}
				
				
			}catch(Exception e){
				e.printStackTrace();
				
			}finally {
				try{
		
					if(resultSet != null) resultSet.close();
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		
			return userTemp;
	}
	
	public String compidCheckTest(String compcode){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String compTemp = "none";
		try{
			connection = dataSource2.getConnection();
			
			String query = "select compcode from companyinfo where compcode = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, compcode);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()){
				compTemp = resultSet.getString("compcode");
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
			
		}finally {
			try{
	
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	
		return compTemp;
	}
	
	public int writeComp(String compcode, String comppw, String compname, String compadd, String comptel){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result_Code = 0;
		
		try{
			connection = dataSource2.getConnection();
		    String query = "insert into companyinfo (compcode, comppw, compname, compadd, comptel) values (?,?,?,?,?)";
		    preparedStatement = connection.prepareStatement(query);
		    preparedStatement.setString(1, compcode);
		    preparedStatement.setString(2, comppw);
		    preparedStatement.setString(3, compname);
		    preparedStatement.setString(4, compadd);
		    preparedStatement.setString(5, comptel);

		    result_Code = preparedStatement.executeUpdate();
		   
		} 
		catch (Exception e){
		    e.printStackTrace();
		}finally {
			try{
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return result_Code;
	}
	
	public int compitemwrite(String compcode, String pname, String pstock, String pcost){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String pcode= compcode;
		int result_Code = 0;
		try{
			connection = dataSource2.getConnection();
		    String query = "insert into productinfo (pcode, pname, pstock, pcost, compcode) values (?,?,?,?,?)";
		    preparedStatement = connection.prepareStatement(query);
		    pcode += (Integer.parseInt(productListCount(compcode))+1);
		    preparedStatement.setString(1, pcode);
		    preparedStatement.setString(2, pname);
		    preparedStatement.setString(3, pstock);
		    preparedStatement.setString(4, pcost);
		    preparedStatement.setString(5, compcode);

		    result_Code = preparedStatement.executeUpdate();
		   
		} 
		catch (Exception e){
		    e.printStackTrace();
		}finally {
			try{
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return result_Code;
	}
	
	public String productListCount(String compcode){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String proCount="";
		try{
			connection = dataSource2.getConnection();
		    String query = "select count(*) from productinfo where compcode = ?";
		    preparedStatement = connection.prepareStatement(query);
		    preparedStatement.setString(1, compcode);
		    
		    resultSet = preparedStatement.executeQuery();
		    if(resultSet.next()){
				proCount = resultSet.getString(1);
			}
		   
		   
		} 
		catch (Exception e){
		    e.printStackTrace();
		}finally {
			try{
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return proCount;
	}
	
	//모든 상품리스트를 가져오는 메서드
	public ArrayList<ProductBean> allProductList(){
		ArrayList<ProductBean> probeans = new ArrayList<ProductBean>();
	    Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
	
		try{
			connection = dataSource2.getConnection();
			
			String query = "select * from productinfo";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				String pcode = resultSet.getString("pcode");
				String pname = resultSet.getString("pname");
				String pstock = resultSet.getString("pstock");
				String pcost = resultSet.getString("pcost");
				
				ProductBean proBean = new ProductBean(pcode, pname, pstock, pcost);
				probeans.add(proBean);
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
			
		}finally {
			try{
	
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	
		return probeans;
	}
	

	public void produpdate(String pcode, String pstock, String pnum) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource2.getConnection();
			String query = "update productinfo set pstock = ? where pcode = ?";
			preparedStatement = connection.prepareStatement(query);
			int temp = Integer.parseInt(pstock);
			temp = temp - Integer.parseInt(pnum);
			pstock = Integer.toString(temp);
			preparedStatement.setString(1, pstock);
			preparedStatement.setString(2, pcode);
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	public void purchase(String userid, String pcode, String pname, String pnum) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource2.getConnection();
			String query = "insert into purchaseinfo (userid, pcode, pname, pnum, pdate) values (?,?,?,?,now())";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userid);
			preparedStatement.setString(2, pcode);
			preparedStatement.setString(3, pname);
			preparedStatement.setString(4, pnum);
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public String adminlogonCheck(String adminid, String adminpw){
		String ADMIN_ACCESS = "";
		if(adminid.equals("admin")){
			if(adminpw.equals("1111")){
				ADMIN_ACCESS = "WELCOME_ADMIN";
			}
		}
		else{
			ADMIN_ACCESS = "WHO ARE YOU?....";
		}
		/*Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String compTemp = "none";
		try{
			connection = dataSource.getConnection();
			
			String query = "select compcode from companyinfo where compcode = ? and comppw = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, compcode);
			preparedStatement.setString(2, comppw);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()){
				compTemp = resultSet.getString("compcode");
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}finally {
			try{
	
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		 */
		return ADMIN_ACCESS;
	}
	
	public ArrayList<PurListBean> mylist(String userid) {

		ArrayList<PurListBean> dtos = new ArrayList<PurListBean>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource2.getConnection();
			String query = "select A.*, B.pcost from purchaseinfo A, productinfo B  where A.userid = ? and (A.pcode = B.pcode)";
				
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userid);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String pcode = resultSet.getString("pcode");
				String pname = resultSet.getString("pname");
				String pnum = resultSet.getString("pnum");
				Timestamp pdate = resultSet.getTimestamp("pdate");
				PurListBean dto = new PurListBean(userid, pcode, pname, pnum, pdate);
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	
		return dtos;
	}
	
	public BDto buy(String strid) {
		BDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource2.getConnection();
			String query = "select pcode,pname,pcost, pstock from productinfo where pcode = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, strid);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				String pcode = resultSet.getString("pcode");
				String pname = resultSet.getString("pname");
				String pcost = resultSet.getString("pcost");
				String pstock = resultSet.getString("pstock");

				dto = new BDto(pcode, pname, pcost, pstock);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return dto;

	}
	
	public CompanyBean companyinfo(String compcode){
		CompanyBean comp = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
	
		try{
			connection = dataSource2.getConnection();
			String query = "select * from companyinfo where compcode = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, compcode);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()){
				String comppw = resultSet.getString(2);
				String compname = resultSet.getString(3);
				String compadd = resultSet.getString(4);
				String comptel = resultSet.getString(5);
				
				comp = new CompanyBean(compcode, comppw, compname, compadd, comptel);
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try{
		
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return comp;
	}
	
	public int comp_modify(String compcode, String comppw, String compname, String compadd, String comptel){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result_Code = 0;
	    try{
	    	connection = dataSource2.getConnection();
	    	
	    	String query = "update companyinfo set comppw = ?, compname = ?, compadd = ?, comptel = ? where compcode = ? and comppw = ?";
		    preparedStatement = connection.prepareStatement(query);
		  
		    preparedStatement.setString(1, comppw);
		    preparedStatement.setString(2, compname);
		    preparedStatement.setString(3, compadd);
		    preparedStatement.setString(4, comptel);
		    preparedStatement.setString(5, compcode);
		    preparedStatement.setString(6, comppw);
		 
		    result_Code = preparedStatement.executeUpdate();

	        
	    } catch(Exception e){
			e.printStackTrace();
			
		}finally {
			try{
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	    return result_Code;
	}

	public ProductBean productView(String pcode){

		ProductBean pro = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
	
		try{
			connection = dataSource2.getConnection();
			String query = "select * from productinfo where pcode = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, pcode);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()){
	
				String pname = resultSet.getString(2);
				String pstock = resultSet.getString(3);
				String pcost = resultSet.getString(4);
				
				pro = new ProductBean(pcode, pname, pstock, pcost);
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try{
		
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return pro;
	}
	
	public int comp_product_modify(String pcode, String pname, String pstock, String pcost){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result_Code = 0;
	    try{
	    	connection = dataSource2.getConnection();
	    	
	    	String query = "update productinfo set pname = ?, pstock = ?, pcost = ? where pcode = ?";
		    preparedStatement = connection.prepareStatement(query);
		  
		    preparedStatement.setString(1, pname);
		    preparedStatement.setString(2, pstock);
		    preparedStatement.setString(3, pcost);
		    preparedStatement.setString(4, pcode);
		  
		    result_Code = preparedStatement.executeUpdate();

	        
	    } catch(Exception e){
			e.printStackTrace();
			
		}finally {
			try{
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	    return result_Code;
	}
	
	public ArrayList<BDto> AdminProductList() {

		ArrayList<BDto> dtos = new ArrayList<BDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource2.getConnection();
			String query = "select pcode,pname,pcost,pstock from productinfo";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String pcode = resultSet.getString("pcode");
				String pname = resultSet.getString("pname");
				String pcost = resultSet.getString("pcost");
				String pstock = resultSet.getString("pstock");
				BDto dto = new BDto(pcode, pname, pcost, pstock);
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		return dtos;
	}

	public void ProductModify(String pcode, String pname, String pcost, String pstock) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource2.getConnection();
			String query = "update productinfo set pname = ?,  pcost = ?,pstock = ? where pcode = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, pname);
			preparedStatement.setString(2, pcost);
			preparedStatement.setString(3, pstock);
			preparedStatement.setString(4, pcode);
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	public BDto ProductInfo(String strid) {
		BDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource2.getConnection();
			String query = "select *  from productinfo where pcode = ? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, strid);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				String pcode = resultSet.getString("pcode");
				String pname = resultSet.getString("pname");
				String pcost = resultSet.getString("pcost");
				String pstock = resultSet.getString("pstock");

				dto = new BDto(pcode, pname, pcost, pstock);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return dto;

	}

	public void AdminProdDelete(String pcode, String pname, String pcost, String pstock) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource2.getConnection();
			String query = "delete from productinfo where pcode = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, pcode);
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	public ArrayList<CompListBean> CompList() {

		ArrayList<CompListBean> dtos = new ArrayList<CompListBean>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource2.getConnection();
			String query = "select * from companyinfo";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String compcode = resultSet.getString("compcode");
				String comppw = resultSet.getString("comppw");
				String compname = resultSet.getString("compname");
				String compadd = resultSet.getString("compadd");
				String comptel = resultSet.getString("comptel");
				CompListBean dto = new CompListBean(compcode, comppw, compname, compadd, comptel);
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		return dtos;
	}

	public CompListBean CompInfo(String strid) {
		CompListBean dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource2.getConnection();
			String query = "select *  from companyinfo where compcode = ? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, strid);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				String compcode = resultSet.getString("compcode");
				String comppw = resultSet.getString("comppw");
				String compname = resultSet.getString("compname");
				String compadd = resultSet.getString("compadd");
				String comptel = resultSet.getString("comptel");

				dto = new CompListBean(compcode, comppw, compname, compadd, comptel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return dto;

	}
	
	public ArrayList<PurListBean> companyPurList(){
		ArrayList<PurListBean> purbeans = new ArrayList<PurListBean>();
	    Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		PurListBean purBean = null;
	
		try{
			connection = dataSource2.getConnection();
			
			String query = "select * from purchaseinfo";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				String userid = resultSet.getString("userid");
				String pcode = resultSet.getString("pcode");
				String pname = resultSet.getString("pname");
				String pnum = resultSet.getString("pnum");
				Timestamp pdate = resultSet.getTimestamp("pdate");
				purBean = new PurListBean(userid, pcode, pname, pnum, pdate);
				purbeans.add(purBean);
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
			
		}finally {
			try{
	
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	
		return purbeans;
	}
	
	public void CompModify(String compcode, String compname, String comppw, String compadd, String comptel) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource2.getConnection();
			String query = "update companyinfo set compname = ? , comppw = ?, compadd = ?, comptel = ? where compcode = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, compname);
			preparedStatement.setString(2, comppw);
			preparedStatement.setString(3, compadd);
			preparedStatement.setString(4, comptel);
			preparedStatement.setString(5, compcode);
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	public int deleteCompanyProduct(String pcode){
		int result_Code = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
	    try{
	    	connection = dataSource2.getConnection();
	    	
	    	String query = "delete from productinfo where pcode = ?";
		    preparedStatement = connection.prepareStatement(query);
		 
		    preparedStatement.setString(1, pcode);
		 
		    result_Code = preparedStatement.executeUpdate();

	    } catch(Exception e){
			e.printStackTrace();
			
		}finally {
			try{
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	    return result_Code;
	}
	
	public ArrayList<UserBean> allUserList(){
		ArrayList<UserBean> userbeans = new ArrayList<UserBean>();
	    Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		UserBean user = null;
	
		try{
			connection = dataSource2.getConnection();
			
			String query = "select * from admin_user";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				String userid = resultSet.getString("userid");
				String userpw = resultSet.getString("userpw");
				String username = resultSet.getString("username");
				String useradd = resultSet.getString("useradd");
				String usertel = resultSet.getString("usertel");
				Timestamp userdate = resultSet.getTimestamp("userdate");
				user = new UserBean(userid, userpw, username, useradd, usertel, userdate);
				userbeans.add(user);
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
			
		}finally {
			try{
	
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	
		return userbeans;
	}
}
