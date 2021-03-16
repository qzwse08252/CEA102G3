package com.news.model;

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

import com.news.model.NewsVO;
public class NewsJDBCDAO implements NewsDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
//	String url = "jdbc:mysql://localhost:3306/guideme?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "123456";

	private static final String INSERT_STMT = 
		"INSERT INTO news (news_Content, release_Date, news_Title, news_Pic) VALUES (?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT news_No, news_Content, release_Date, news_Title, news_Pic FROM news order by news_No";
	private static final String GET_ONE_STMT = 
		"SELECT news_No, news_Content, release_Date, news_Title, news_Pic FROM news where news_No = ?";
	private static final String DELETE = 
		"DELETE FROM news where news_No = ?";
	private static final String UPDATE = 
		"UPDATE news set news_Content=?, release_Date=?, news_Title=? , news_Pic=? where news_No = ?";

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
	public void insert(NewsVO newsVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
				
			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			con = DriverManager.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, newsVO.getNews_Content());
			pstmt.setDate(2, newsVO.getRelease_Date());
			pstmt.setString(3, newsVO.getNews_Title());
			pstmt.setBytes(4, newsVO.getNews_Pic());
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
	public void update(NewsVO newsVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection();
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, newsVO.getNews_Content());
			pstmt.setDate(2, newsVO.getRelease_Date());
			pstmt.setString(3, newsVO.getNews_Title());
			pstmt.setBytes(4, newsVO.getNews_Pic());
			pstmt.setInt(5, newsVO.getNews_No());
			
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
	public void delete(Integer news_No) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection();
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, news_No);

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
	public NewsVO findByPrimaryKey(Integer news_No) {

		NewsVO newsVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection();
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, news_No);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				newsVO = new NewsVO();
				newsVO.setNews_No(rs.getInt("news_No"));
				newsVO.setNews_Content(rs.getString("news_Content"));
				newsVO.setRelease_Date(rs.getDate("release_Date"));
				newsVO.setNews_Title(rs.getString("news_Title"));
				newsVO.setNews_Pic(rs.getBytes("news_Pic"));
				
				
				
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
		return newsVO;
	}
	@Override
	public List<NewsVO> getAll() {
		List<NewsVO> list = new ArrayList<NewsVO>();
		NewsVO newsVO = null;

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

			
				newsVO = new NewsVO();
				newsVO.setNews_No(rs.getInt("news_No"));
				newsVO.setNews_Content(rs.getString("news_Content"));
				newsVO.setRelease_Date(rs.getDate("release_Date"));
				newsVO.setNews_Title(rs.getString("news_Title"));
				newsVO.setNews_Pic(rs.getBytes("news_Pic"));
				
				
				list.add(newsVO); // Store the row in the list
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

	NewsJDBCDAO dao = new NewsJDBCDAO();

	// 新增
	NewsVO newsVO1 = new NewsVO();
	newsVO1.setNews_Content("12");
	newsVO1.setRelease_Date(java.sql.Date.valueOf("2021-03-09"));
	newsVO1.setNews_Title("xxx");
	newsVO1.setNews_Pic(null);

	dao.insert(newsVO1);
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








