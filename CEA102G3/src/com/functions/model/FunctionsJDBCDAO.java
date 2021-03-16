package com.functions.model;

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



public class FunctionsJDBCDAO implements FunctionsDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
//	String url = "jdbc:mysql://localhost:3306/guideme?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "123456";

	private static final String INSERT_STMT = "INSERT INTO functions (funct_Name) VALUES (?)";
	private static final String GET_ALL_STMT = "SELECT funct_No, funct_Name FROM functions order by funct_No";
	private static final String GET_ONE_STMT = "SELECT funct_No, funct_Name FROM functions where funct_No = ?";
	private static final String DELETE = "DELETE FROM functions where funct_No = ?";
	private static final String UPDATE = "UPDATE functions set funct_Name = ? where funct_No = ?";

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
	public void insert(FunctionsVO functionsVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
				
			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			con = DriverManager.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setString(1, functionsVO.getFunct_Name());
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
	public void update(FunctionsVO functionsVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection();
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, functionsVO.getFunct_Name());
			pstmt.setInt(2, functionsVO.getFunct_No());

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
	public void delete(Integer funct_No) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection();
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, funct_No);

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
	public FunctionsVO findByPrimaryKey(Integer funct_No) {
		FunctionsVO functionsVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection();
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, funct_No);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				functionsVO = new FunctionsVO();
				functionsVO.setFunct_No(rs.getInt("funct_No"));
				functionsVO.setFunct_Name(rs.getString("funct_Name"));
	

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
		return functionsVO;
	}
	
	@Override
	public List<FunctionsVO> getAll() {
		List<FunctionsVO> list = new ArrayList<FunctionsVO>();
		FunctionsVO functionsVO = null;

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

				functionsVO = new FunctionsVO();
				functionsVO.setFunct_No(rs.getInt("funct_No"));
				functionsVO.setFunct_Name(rs.getString("funct_Name"));
		

				list.add(functionsVO); // Store the row in the list
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

//	public static void main(String[] args) {
//
//		FunctionsJDBCDAO dao = new FunctionsJDBCDAO();
//
//		// 新增
//		FunctionsVO functionsVO1 = new FunctionsVO();
//		functionsVO1.setFunct_No(13);
//		functionsVO1.setFunct_Name("test");
//
//
//		dao.insert(functionsVO1);
//	//
////		// 修改
//		FunctionsVO  functionsVO2 = new FunctionsVO();
//		functionsVO2.setFunct_No(9);
//		functionsVO2.setFunct_Name("test");
////		dao.update(functionsVO2);
////	//
//////		刪除
//		dao.delete(9);
	//
//		// 查詢
//		FunctionVO functionVO3 = dao.findByPrimaryKey(2);
//		System.out.print(functionVO3.getFunct_No() + ",");
//		System.out.print(functionVO3.getFunct_Name() + ",");
////
////	
//		System.out.println("---------------------");
//	//
//////		// 查詢
//		List<FunctionVO> list = dao.getAll();
//		for (FunctionVO aNews : list) {
//			System.out.print(aNews.getFunct_No() + ",");
//			System.out.print(aNews.getFunct_Name() + ",");
//		
//			System.out.println();
//		}
	}
//	}

