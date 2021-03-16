package com.emp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class EmployeeJDBCDAO implements EmployeeDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
//	String url = "jdbc:mysql://localhost:3306/guideme?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "123456";


	private static final String INSERT_STMT = 
		"INSERT INTO employee (account, password, name, sex, phone, email, start_From, emp_State, emp_Pic) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT emplo_No, account, password, name, sex, phone, email, start_From, emp_State, emp_Pic FROM employee order by emplo_No";
	private static final String GET_ONE_STMT = 
		"SELECT emplo_No, account, password, name, sex, phone, email, start_From, emp_State, emp_Pic FROM employee where emplo_No = ?";
	private static final String DELETE = 
		"DELETE FROM employee where emplo_No = ?";
	private static final String UPDATE = 
		"UPDATE employee set account=?, name=?, sex=?, phone=?, email=?, start_From=?, emp_State=?, emp_Pic=? where emplo_No = ?";
	private static final String FIND_BY_ACCOUNT = 
		"SELECT * FROM employee where account = ?";
	
	private static DataSource DriverManager = null;
	static {
		try {
			Context ctx = new InitialContext();
			DriverManager = (DataSource) ctx.lookup("java:comp/env/jdbc/guidemeDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	
	
	


@Override
	public void insert(EmployeeVO employeeVO) {
	Connection con = null;
	PreparedStatement pstmt = null;

	try {
			
		Class.forName(driver);
//		con = DriverManager.getConnection(url, userid, passwd);
		con = DriverManager.getConnection();
		pstmt = con.prepareStatement(INSERT_STMT);

		
		pstmt.setString(1, employeeVO.getAccount());
		pstmt.setString(2, employeeVO.getPassword());
		pstmt.setString(3, employeeVO.getName());
		pstmt.setInt(4, employeeVO.getSex());
		pstmt.setString(5, employeeVO.getPhone());
		pstmt.setString(6, employeeVO.getEmail());
		pstmt.setDate(7, employeeVO.getStart_From());
		pstmt.setInt(8, employeeVO.getEmp_State());
		pstmt.setBytes(9, employeeVO.getEmp_Pic());
	
		pstmt.executeUpdate();


		// Handle any driver errors
	} catch (ClassNotFoundException e) {
		throw new RuntimeException("Couldn't load database driver. "
				+ e.getMessage());
		// Handle any SQL errors
	} catch (SQLException se) {
		throw new RuntimeException("A database error occured. "
				+ se.getMessage());
		// Clean up JDBC resources
	} finally {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace(System.err);
			}
		}
	}

}

	@Override
	public void update(EmployeeVO employeeVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection();
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			
			pstmt.setString(1, employeeVO.getAccount());
//			pstmt.setString(2, employeeVO.getPassword());
			pstmt.setString(2, employeeVO.getName());
			pstmt.setInt(3, employeeVO.getSex());
			pstmt.setString(4, employeeVO.getPhone());
			pstmt.setString(5, employeeVO.getEmail());
			pstmt.setDate(6, employeeVO.getStart_From());
			pstmt.setInt(7, employeeVO.getEmp_State());
			pstmt.setBytes(8, employeeVO.getEmp_Pic());
			pstmt.setInt(9, employeeVO.getEmplo_No());
			
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void delete(Integer emplo_No) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection();
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, emplo_No);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public EmployeeVO findByPrimaryKey(Integer emplo_No) {
		EmployeeVO employeeVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection();
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, emplo_No);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				employeeVO = new EmployeeVO();
				employeeVO.setEmplo_No(rs.getInt("emplo_No"));
				employeeVO.setAccount(rs.getString("account"));
				employeeVO.setPassword(rs.getString("password"));
				employeeVO.setName(rs.getString("name"));
				employeeVO.setSex(rs.getInt("sex"));
				employeeVO.setPhone(rs.getString("phone"));
				employeeVO.setEmail(rs.getString("email"));
				employeeVO.setStart_From(rs.getDate("start_From"));
				employeeVO.setEmp_State(rs.getInt("emp_State"));
				employeeVO.setEmp_Pic(rs.getBytes("emp_Pic"));
			
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return employeeVO;
	}

	@Override
	public List<EmployeeVO> getAll() {
		List<EmployeeVO> list = new ArrayList<EmployeeVO>();
		EmployeeVO employeeVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection();
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {

						
				employeeVO = new EmployeeVO();					
				employeeVO.setEmplo_No(rs.getInt("emplo_No"));
				employeeVO.setAccount(rs.getString("account"));
				employeeVO.setPassword(rs.getString("password"));
				employeeVO.setName(rs.getString("name"));
				employeeVO.setSex(rs.getInt("sex"));
				employeeVO.setPhone(rs.getString("phone"));
				employeeVO.setEmail(rs.getString("email"));
				employeeVO.setStart_From(rs.getDate("start_From"));
				employeeVO.setEmp_State(rs.getInt("emp_State"));
				employeeVO.setEmp_Pic(rs.getBytes("emp_Pic"));
				
				
				list.add(employeeVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	
	}
	
	@Override
	public EmployeeVO findByAccount(String account) {
		EmployeeVO employeeVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection();
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(FIND_BY_ACCOUNT);

			pstmt.setString(1, account);

			rs = pstmt.executeQuery();

			while (rs.next()) {
		
		
			
			
				employeeVO = new EmployeeVO();
				employeeVO.setEmplo_No(rs.getInt("emplo_No"));
				employeeVO.setAccount(rs.getString("account"));
				employeeVO.setPassword(rs.getString("password"));
				employeeVO.setName(rs.getString("name"));
				employeeVO.setSex(rs.getInt("sex"));
				employeeVO.setPhone(rs.getString("phone"));
				employeeVO.setEmail(rs.getString("email"));
				employeeVO.setStart_From(rs.getDate("start_From"));
				employeeVO.setEmp_State(rs.getInt("emp_State"));
				employeeVO.setEmp_Pic(rs.getBytes("emp_Pic"));

			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return employeeVO;
	}
	
	
}



//public static void main(String[] args) {
//
//	EmployeeJDBCDAO dao = new EmployeeJDBCDAO();

	// 新增
//	EmployeeVO employeeVO1 = new EmployeeVO();
//	employeeVO1.setAccount("12");
//	employeeVO1.setPassword("111");
//	employeeVO1.setName("xxx");
//	employeeVO1.setSex(1);
//	employeeVO1.setPhone("0903");
//	employeeVO1.setEmail("abc@Mail.com");
//	employeeVO1.setStart_From(java.sql.Date.valueOf("2021-03-09"));
//	employeeVO1.setEmp_State(1);
//	employeeVO1.setEmp_Pic(null);
//	dao.insert(employeeVO1);
//}
//}
////	// 修改
//	NewsVO newsVO2 = new NewsVO();
//	newsVO2.setNews_Content("14");
//	newsVO2.setRelease_Date(java.sql.Date.valueOf("2012-02-14"));
//	newsVO2.setNews_Title("aaa");
//	newsVO2.setNews_Pic(null);
//	newsVO2.setNews_No(11);
//	dao.update(newsVO2);
////
//////	刪除
//	dao.delete(11);
//
//	// 查詢
//	NewsVO newsVO3 = dao.findByPrimaryKey(2);
//	System.out.print(newsVO3.getNews_No() + ",");
//	System.out.print(newsVO3.getNews_Content() + ",");
//	System.out.print(newsVO3.getRelease_Date() + ",");
//	System.out.print(newsVO3.getNews_Title() + ",");
//	System.out.print(newsVO3.getNews_Pic() + ",");
//
//	System.out.println("---------------------");
//
//////	// 查詢
//	List<NewsVO> list = dao.getAll();
//	for (NewsVO aNews : list) {
//		System.out.print(aNews.getNews_No() + ",");
//		System.out.print(aNews.getNews_Content() + ",");
//		System.out.print(aNews.getRelease_Date() + ",");
//		System.out.print(aNews.getNews_Title() + ",");
//		System.out.print(aNews.getNews_Pic() + ",");
//		System.out.println();
//	}
//}
//}








