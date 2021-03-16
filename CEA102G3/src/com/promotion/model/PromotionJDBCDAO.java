package com.promotion.model;

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


public class PromotionJDBCDAO implements PromotionDAO_interface {
	
String driver = "com.mysql.cj.jdbc.Driver";
//String url = "jdbc:mysql://localhost:3306/guideme?serverTimezone=Asia/Taipei";
String userid = "root";
String passwd = "123456";


	private static final String INSERT_STMT = "INSERT INTO promotion (promot_Content, promot_Start, promot_End, release_Date, promot_Product_No, promot_Product_Price, promot_Product_Title, promot_Product_Pic) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT promot_No, promot_Content, promot_Start, promot_End, release_Date, promot_Product_No, promot_Product_Price, promot_Product_Title, promot_Product_Pic FROM Promotion order by promot_No desc";
	private static final String GET_ONE_STMT = "SELECT promot_No, promot_Content, promot_Start, promot_End, release_Date, promot_Product_No, promot_Product_Price, promot_Product_Title, promot_Product_Pic FROM Promotion where promot_No = ?";
	private static final String DELETE = "DELETE FROM Promotion where promot_No = ?";
	private static final String UPDATE = "UPDATE Promotion set promot_Content=?, promot_Start=?, promot_End=?, release_Date=?, promot_Product_No=?, promot_Product_Price=?, promot_Product_Title=?, promot_Product_Pic=?, where promot_No = ?";
	private static final String FIND_BY_PROMOTPRODUCTNO = "SELECT * FROM Promotion WHERE promot_Product_No = ? order by promot_Product_Title";
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
	public void insert(PromotionVO promotionVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			con = DriverManager.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setString(1, promotionVO.getPromot_Content());
			pstmt.setDate(2, promotionVO.getPromot_Start());
			pstmt.setDate(3, promotionVO.getPromot_End());
			pstmt.setDate(4, promotionVO.getRelease_Date());
			pstmt.setInt(5, promotionVO.getPromot_Product_No());
			pstmt.setInt(6, promotionVO.getPromot_Product_Price());
			pstmt.setString(7, promotionVO.getPromot_Product_Title());
			pstmt.setBytes(8, promotionVO.getPromot_Product_Pic());
			pstmt.executeUpdate();
			
			// Handle any SQL errors
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
	public void update(PromotionVO promotionVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection();
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, promotionVO.getPromot_Content());
			pstmt.setDate(2, promotionVO.getPromot_Start());
			pstmt.setDate(3, promotionVO.getPromot_End());
			pstmt.setDate(4, promotionVO.getRelease_Date());
			pstmt.setInt(5, promotionVO.getPromot_Product_No());
			pstmt.setInt(6, promotionVO.getPromot_Product_Price());
			pstmt.setString(7, promotionVO.getPromot_Product_Title());
			pstmt.setBytes(8, promotionVO.getPromot_Product_Pic());
			pstmt.setInt(9, promotionVO.getPromot_No());
			
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
	public void delete(Integer promot_No) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection();
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, promot_No);

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
	public PromotionVO findByPrimaryKey(Integer promot_No) {
		PromotionVO promotionVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection();
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);


			pstmt.setInt(1, promot_No);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				promotionVO = new PromotionVO();
				
				promotionVO.setPromot_No(rs.getInt("promot_No"));
				promotionVO.setPromot_Content(rs.getString("promot_Content"));
				promotionVO.setPromot_Start(rs.getDate("promot_Start"));
				promotionVO.setPromot_End(rs.getDate("promot_End"));
				promotionVO.setRelease_Date(rs.getDate("release_Date"));
				promotionVO.setPromot_Product_No(rs.getInt("promot_Product_No"));
				promotionVO.setPromot_Product_Price(rs.getInt("promot_Product_Price"));
				promotionVO.setPromot_Product_Title(rs.getString("promot_Product_Title"));
				promotionVO.setPromot_Product_Pic(rs.getBytes("promot_Product_Pic"));
				
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
		return promotionVO;
	}
	@Override
	public List<PromotionVO> findByPromotProductNo(Integer promot_Product_No) {
		List<PromotionVO> list = new ArrayList<PromotionVO>();
		PromotionVO promotionVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection();
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(FIND_BY_PROMOTPRODUCTNO);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				promotionVO = new PromotionVO();
				promotionVO.setPromot_No(rs.getInt("promot_No"));
				promotionVO.setPromot_Content(rs.getString("promot_Content"));
				promotionVO.setPromot_Start(rs.getDate("promot_Start"));
				promotionVO.setPromot_End(rs.getDate("promot_End"));
				promotionVO.setRelease_Date(rs.getDate("release_Date"));
				promotionVO.setPromot_Product_No(rs.getInt("promot_Product_No"));
				promotionVO.setPromot_Product_Price(rs.getInt("promot_Product_Price"));
				promotionVO.setPromot_Product_Title(rs.getString("promot_Product_Title"));
				promotionVO.setPromot_Product_Pic(rs.getBytes("promot_Product_Pic"));
				
				
				list.add(promotionVO);
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
	public List<PromotionVO> getAll() {
		List<PromotionVO> list = new ArrayList<PromotionVO>();
		PromotionVO promotionVO = null;

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

				promotionVO = new PromotionVO();
				promotionVO.setPromot_No(rs.getInt("promot_No"));
				promotionVO.setPromot_Content(rs.getString("promot_Content"));
				promotionVO.setPromot_Start(rs.getDate("promot_Start"));
				promotionVO.setPromot_End(rs.getDate("promot_End"));
				promotionVO.setRelease_Date(rs.getDate("release_Date"));
				promotionVO.setPromot_Product_No(rs.getInt("promot_Product_No"));
				promotionVO.setPromot_Product_Price(rs.getInt("promot_Product_Price"));
				promotionVO.setPromot_Product_Title(rs.getString("promot_Product_Title"));
				promotionVO.setPromot_Product_Pic(rs.getBytes("promot_Product_Pic"));
				
					
				
				list.add(promotionVO); // Store the row in the list
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


	public static void main(String[] args) {

	PromotionJDBCDAO dao = new PromotionJDBCDAO();

	// 新增
	PromotionVO promotionVO1 = new PromotionVO();
	promotionVO1.setPromot_Content("TEST");
	promotionVO1.setPromot_Start(java.sql.Date.valueOf("2021-03-01"));
	promotionVO1.setPromot_End(java.sql.Date.valueOf("2021-03-10"));
	promotionVO1.setRelease_Date(java.sql.Date.valueOf("2021-02-28"));
	promotionVO1.setPromot_Product_No(1);
	promotionVO1.setPromot_Product_Price(1000);
	promotionVO1.setPromot_Product_Title("鳳梨");
	promotionVO1.setPromot_Product_Pic(null);
	dao.insert(promotionVO1);
//
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
}
}

