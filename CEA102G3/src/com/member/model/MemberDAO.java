package com.member.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.friendList.model.FriendListVO;

import util.Util;

public class MemberDAO implements MemberDAO_interface {
	private static final String INSERT_STMT = "INSERT INTO Member(Account, Password, Name, ID_Number, Birth_Date, Phone, email, Member_State, Member_Pic, Lisce_Pic1, Lisce_Pic2, Lisce_Pic3, Lisce_Name1, Lisce_Name2, Lisce_Name3) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_STMT = "UPDATE Member SET Account = ?, Password = ?, Name = ?, ID_Number = ?, Birth_Date = ?, Phone = ?, email = ?, Member_State = ? , Member_Pic = ?, Lisce_Pic1 = ?, Lisce_Pic2 = ?, Lisce_Pic3 = ?, Lisce_Name1 = ?, Lisce_Name2 = ?, Lisce_Name3 = ? WHERE member_no = ?";
	private static final String DELETE_STMT = "DELETE FROM Member WHERE member_no = ?";
	private static final String FIND_BY_PK = "SELECT * FROM Member WHERE member_no = ?";
	private static final String FIND_BY_NAME = "SELECT * FROM Member WHERE NAME like ? ";
	private static final String FIND_BY_EMAIL = "SELECT * FROM Member WHERE EMAIL = ? ";
	private static final String FIND_BY_NAME_FORFRIENDS = "SELECT * FROM Member WHERE NAME like ? ";
	private static final String GET_ALL = "SELECT * FROM Member";

	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/guidemeDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(MemberVO member) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, member.getAccount());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getIdNumber());
			pstmt.setDate(5, member.getBirthDate());
			pstmt.setString(6, member.getPhone());
			pstmt.setString(7, member.getEmail());
			pstmt.setInt(8, member.getMemberState());
			pstmt.setBytes(9, member.getMemberPic());
			pstmt.setBytes(10, member.getLiscePic1());
			pstmt.setBytes(11, member.getLiscePic2());
			pstmt.setBytes(12, member.getLiscePic3());
			pstmt.setString(13, member.getLisceName1());
			pstmt.setString(14, member.getLisceName2());
			pstmt.setString(15, member.getLisceName3());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
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
	public void update(MemberVO member) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE_STMT);

			pstmt.setString(1, member.getAccount());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getIdNumber());
			pstmt.setDate(5, member.getBirthDate());
			pstmt.setString(6, member.getPhone());
			pstmt.setString(7, member.getEmail());
			pstmt.setInt(8, member.getMemberState());
			pstmt.setInt(9, member.getMemberNo());
			pstmt.setBytes(10, member.getMemberPic());
			pstmt.setBytes(11, member.getLiscePic1());
			pstmt.setBytes(12, member.getLiscePic2());
			pstmt.setBytes(13, member.getLiscePic3());
			pstmt.setString(14, member.getLisceName1());
			pstmt.setString(15, member.getLisceName2());
			pstmt.setString(16, member.getLisceName3());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
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
	public void delete(Integer memberNo) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE_STMT);
			pstmt.setInt(1, memberNo);
			pstmt.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public MemberVO findByPrimaryKey(Integer memberNo) {
		MemberVO memberVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, memberNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				memberVO = new MemberVO();
				memberVO.setMemberNo(rs.getInt("Member_No"));
				memberVO.setAccount(rs.getString("Account"));
				memberVO.setPassword(rs.getString("Password"));
				memberVO.setName(rs.getString("Name"));
				memberVO.setIdNumber(rs.getString("ID_Number"));
				memberVO.setBirthDate(rs.getDate("Birth_Date"));
				memberVO.setPhone(rs.getString("Phone"));
				memberVO.setEmail(rs.getString("Email"));
				memberVO.setMemberState(rs.getInt("Member_State"));
				memberVO.setMemberPic(rs.getBytes("Member_Pic"));
				memberVO.setLiscePic1(rs.getBytes("Lisce_Pic1"));
				memberVO.setLiscePic2(rs.getBytes("Lisce_Pic2"));
				memberVO.setLiscePic3(rs.getBytes("Lisce_Pic3"));
				memberVO.setLisceName1(rs.getString("Lisce_Name1"));
				memberVO.setLisceName2(rs.getString("Lisce_Name2"));
				memberVO.setLisceName3(rs.getString("Lisce_Name3"));
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return memberVO;
	}
	
	@Override
	public List<MemberVO> findByName(String name) {
		List<MemberVO> list = new ArrayList<MemberVO>();
		MemberVO memberVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(FIND_BY_NAME);
			System.out.println("FIND_BY_NAME:"+FIND_BY_NAME);
			pstmt.setString(1, "%"+name+"%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				memberVO = new MemberVO();
				memberVO.setMemberNo(rs.getInt("Member_No"));
				memberVO.setAccount(rs.getString("Account"));
				memberVO.setPassword(rs.getString("Password"));
				memberVO.setName(rs.getString("Name"));
				memberVO.setIdNumber(rs.getString("ID_Number"));
				memberVO.setBirthDate(rs.getDate("Birth_Date"));
				memberVO.setPhone(rs.getString("Phone"));
				memberVO.setEmail(rs.getString("Email"));
				memberVO.setMemberState(rs.getInt("Member_State"));
				memberVO.setMemberPic(rs.getBytes("Member_Pic"));
				memberVO.setLiscePic1(rs.getBytes("Lisce_Pic1"));
				memberVO.setLiscePic2(rs.getBytes("Lisce_Pic2"));
				memberVO.setLiscePic3(rs.getBytes("Lisce_Pic3"));
				memberVO.setLisceName1(rs.getString("Lisce_Name1"));
				memberVO.setLisceName2(rs.getString("Lisce_Name2"));
				memberVO.setLisceName3(rs.getString("Lisce_Name3"));
				list.add(memberVO);
			}
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public MemberVO findByEmail(String email) {
		MemberVO memberVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(FIND_BY_EMAIL);
			System.out.println("FIND_BY_EMAIL:"+FIND_BY_EMAIL);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				memberVO = new MemberVO();
				memberVO.setMemberNo(rs.getInt("Member_No"));
				memberVO.setAccount(rs.getString("Account"));
				memberVO.setPassword(rs.getString("Password"));
				memberVO.setName(rs.getString("Name"));
				memberVO.setIdNumber(rs.getString("ID_Number"));
				memberVO.setBirthDate(rs.getDate("Birth_Date"));
				memberVO.setPhone(rs.getString("Phone"));
				memberVO.setEmail(rs.getString("Email"));
				memberVO.setMemberState(rs.getInt("Member_State"));
				memberVO.setMemberPic(rs.getBytes("Member_Pic"));
				memberVO.setLiscePic1(rs.getBytes("Lisce_Pic1"));
				memberVO.setLiscePic2(rs.getBytes("Lisce_Pic2"));
				memberVO.setLiscePic3(rs.getBytes("Lisce_Pic3"));
				memberVO.setLisceName1(rs.getString("Lisce_Name1"));
				memberVO.setLisceName2(rs.getString("Lisce_Name2"));
				memberVO.setLisceName3(rs.getString("Lisce_Name3"));
			}
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return memberVO;
	}
	
	@Override
	public List<FriendListVO> findByNameForFreinds(Integer memNO, String name) {
		List<FriendListVO> list = new ArrayList<FriendListVO>();
		FriendListVO friendListVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(FIND_BY_NAME_FORFRIENDS);
			pstmt.setString(1, "%"+name+"%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				friendListVO = new FriendListVO();
				friendListVO.setMemberNo(memNO);
				friendListVO.setFriendNo(rs.getInt("Member_No"));
				list.add(friendListVO);
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public List<MemberVO> getAll() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		MemberVO memberVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				memberVO = new MemberVO();
				memberVO.setMemberNo(rs.getInt("Member_No"));
				memberVO.setAccount(rs.getString("Account"));
				memberVO.setPassword(rs.getString("Password"));
				memberVO.setName(rs.getString("Name"));
				memberVO.setIdNumber(rs.getString("ID_Number"));
				memberVO.setBirthDate(rs.getDate("Birth_Date"));
				memberVO.setPhone(rs.getString("Phone"));
				memberVO.setEmail(rs.getString("Email"));
				memberVO.setMemberState(rs.getInt("Member_State"));
				memberVO.setMemberPic(rs.getBytes("Member_Pic"));
				memberVO.setLiscePic1(rs.getBytes("Lisce_Pic1"));
				memberVO.setLiscePic2(rs.getBytes("Lisce_Pic2"));
				memberVO.setLiscePic3(rs.getBytes("Lisce_Pic3"));
				memberVO.setLisceName1(rs.getString("Lisce_Name1"));
				memberVO.setLisceName2(rs.getString("Lisce_Name2"));
				memberVO.setLisceName3(rs.getString("Lisce_Name3"));
				list.add(memberVO);
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	
}
