package com.faq.model;


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

import com.faq.model.FaqVO;

	public class FaqJDBCDAO implements FaqDAO_interface {
		String driver = "com.mysql.cj.jdbc.Driver";
		String userid = "root";
		String passwd = "123456";

		private static final String INSERT_STMT = 
			"INSERT INTO faq (question, answer, update_Time) VALUES (?, ?, ?)";
		private static final String GET_ALL_STMT = 
			"SELECT question_No, question, answer, update_Time FROM faq order by question_No";
		private static final String GET_ONE_STMT = 
			"SELECT question_No,question, answer, update_Time FROM faq where question_No = ?";
		private static final String DELETE = 
			"DELETE FROM faq where question_No = ?";
		private static final String UPDATE = 
			"UPDATE faq set question=?, answer=?, update_Time=? where question_No = ?";
	
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
		public void insert(FaqVO faqVO) {
	Connection con = null;
	PreparedStatement pstmt = null;

	try {
			
		Class.forName(driver);
//		con = DriverManager.getConnection(url, userid, passwd);
		con = DriverManager.getConnection();
		pstmt = con.prepareStatement(INSERT_STMT);

		pstmt.setString(1, faqVO.getQuestion());
		pstmt.setString(2, faqVO.getAnswer());
		pstmt.setDate(3, faqVO.getUpdate_Time());


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
		public void update(FaqVO faqVO) {
			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				Class.forName(driver);
				con = DriverManager.getConnection();
//				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(UPDATE);

				pstmt.setString(1, faqVO.getQuestion());
				pstmt.setString(2, faqVO.getAnswer());
				pstmt.setDate(3, faqVO.getUpdate_Time());
				pstmt.setInt(4, faqVO.getQuestion_No());

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
		public void delete(Integer question_no) {
			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				Class.forName(driver);
				con = DriverManager.getConnection();
//				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(DELETE);

				pstmt.setInt(1, question_no);

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
		public FaqVO findByPrimaryKey(Integer questionno) {

			FaqVO faqVO = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				Class.forName(driver);
				con = DriverManager.getConnection();
//				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(GET_ONE_STMT);

				pstmt.setInt(1, questionno);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					// empVo 也稱為 Domain objects
					faqVO = new FaqVO();
					faqVO.setQuestion_No(rs.getInt("question_No"));
					faqVO.setQuestion(rs.getString("question"));
					faqVO.setAnswer(rs.getString("answer"));
					faqVO.setUpdate_Time(rs.getDate("update_Time"));
	
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
			return faqVO;
		}
//		
		@Override
		public List<FaqVO> getAll() {
			List<FaqVO> list = new ArrayList<FaqVO>();
			FaqVO faqVO = null;

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				Class.forName(driver);
				con = DriverManager.getConnection();
//				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(GET_ALL_STMT);
				rs = pstmt.executeQuery();

				while (rs.next()) {

					faqVO = new FaqVO();
					faqVO.setQuestion_No(rs.getInt("question_No"));
					faqVO.setQuestion(rs.getString("question"));
					faqVO.setAnswer(rs.getString("answer"));
					faqVO.setUpdate_Time(rs.getDate("update_Time"));

					list.add(faqVO); // Store the row in the list
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

	FaqJDBCDAO dao = new FaqJDBCDAO();

	// 新增
	FaqVO faqVO1 = new FaqVO();
	faqVO1.setQuestion("7888");
	faqVO1.setAnswer("451");
	faqVO1.setUpdate_Time(java.sql.Date.valueOf("2012-02-14"));
	faqVO1.setQuestion_No(19);
	dao.insert(faqVO1);

//	// 修改
//	FaqVO faqVO2 = new FaqVO();
//	faqVO2.setQuestion_No(18);
//	faqVO2.setQuestion("312");
//	faqVO2.setAnswer("3123");
//	faqVO2.setUpdate_Time(java.sql.Date.valueOf("2012-06-21"));
//	dao.update(faqVO2);
//
////	刪除
//	dao.delete(14);

	// 查詢
//	FaqVO faqVO3 = dao.findByPrimaryKey(2);
//	System.out.print(faqVO3.getQuestion_No() + ",");
//	System.out.print(faqVO3.getQuestion() + ",");
//	System.out.print(faqVO3.getAnswer() + ",");
//	System.out.print(faqVO3.getUpdate_Time() + ",");
//
//	System.out.println("---------------------");
//
////	// 查詢
//	List<FaqVO> list = dao.getAll();
//	for (FaqVO aEmp : list) {
//		System.out.print(aEmp.getQuestion_No() + ",");
//		System.out.print(aEmp.getQuestion() + ",");
//		System.out.print(aEmp.getAnswer() + ",");
//		System.out.print(aEmp.getUpdate_Time() + ",");
//		System.out.println();
//	}
}
}





