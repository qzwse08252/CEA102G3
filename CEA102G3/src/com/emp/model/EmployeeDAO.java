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


public class EmployeeDAO implements EmployeeDAO_interface {
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/guidemeDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = 
		"INSERT INTO employee (account, password, name, sex, phone, email, start_From, emp_State, emp_Pic) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT emplo_No, account, password, name, sex, phone, email, start_From, emp_State, emp_Pic FROM employee order by emplo_No desc";
	private static final String GET_ONE_STMT = 
		"SELECT emplo_No, account, password, name, sex, phone, email, start_From, emp_State, emp_Pic FROM employee where emplo_No = ?";
	private static final String DELETE = 
		"DELETE FROM employee where emplo_No = ?";
	private static final String UPDATE = 
		"UPDATE employee set account=?, name=?, sex=?, phone=?, email=?, start_From=?, emp_State=?, emp_Pic=? where emplo_No = ?";
	private static final String FIND_BY_ACCOUNT = 
		"SELECT * FROM employee where account = ? ";
	
	
	@Override
	public void insert(EmployeeVO employeeVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
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
			
			con = ds.getConnection();
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

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, emplo_No);

			pstmt.executeUpdate();
			
			// Handle any driver errors
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

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, emplo_No);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 銋迂� Domain objects
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
	public EmployeeVO findByAccount(String account) {
		EmployeeVO employeeVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(FIND_BY_ACCOUNT);

			pstmt.setString(1,account);
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

			con = ds.getConnection();
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
}
