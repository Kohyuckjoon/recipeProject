package com.kh.recipe.member.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kh.recipe.common.exception.DataAccessException;
import com.kh.recipe.common.db.JDBCTemplate;
import com.kh.recipe.member.model.dto.Member;

//DAO(DATA ACCESS OBJECT)
//DBMS에 접근해 데이터의 조회, 수정, 삽입, 삭제 요청을 보내는 클래스
//DAO의 메서드는 하나의 메서드 당 하나의 쿼리만 처리하도록 작성
public class MemberDao {
	
	private JDBCTemplate template = JDBCTemplate.getInstance();

	public Member memberAuthenticate(String userId, String password, Connection conn){
		Member member = null;	
		PreparedStatement pstm = null;
		ResultSet rset = null;
		String query = "select * from member where user_id = ? and password = ?";
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userId);
			pstm.setString(2, password);
			rset = pstm.executeQuery();
			
			if(rset.next()) {
				member = convertAllToMember(rset);
			}
		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(rset, pstm);
		}
		System.out.println(member);
		return member;
	}

	public Member selectMemberById(String userId, Connection conn) {
		Member member = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		String query = "select * from member where user_id = ?";
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userId);
			rset = pstm.executeQuery();
			if(rset.next()) {
				member = convertAllToMember(rset);
			}
		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(rset, pstm);
		}
		
		return member;
	}

	public List<Member> selectMemberList(Connection conn) {
		List<Member> memberList = new ArrayList<Member>();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		String columns = "user_id, name, phone, email";
		String query = "select " + columns +" from member";
		
		try {
			pstm = conn.prepareStatement(query);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Member member = convertRowToMember(columns.split(","),rset);
				memberList.add(member);
			}
		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(rset, pstm);
		}
		
		return memberList;
	}

	public int insertMember(Member member, Connection conn){	
		int res = 0;
		PreparedStatement pstm = null;
		String query = "insert into member(user_id,password,name,phone,email) values(?,?,?,?,?)";
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, member.getUserId());
			pstm.setString(2, member.getPassword());
			pstm.setString(3, member.getName());
			pstm.setString(4, member.getPhone());
			pstm.setString(5, member.getEmail());
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(pstm);
		}
		
		return res;
	}
	
	//userId로 ' or 1=1 or user_id = ' 값을 전달받으면 모든 회원의 비밀번호가 수정
	//SQL Injection 공격
	//악의적인 SQL구문을 주입해서 상대방의 DataBase를 공격하는 기법
	
	//SQL Injection 공격 막기 위해 PreparedStatement 사용
	//인스턴스를 생성할 때 쿼리 템플릿을 미리 등록
	//생성시 등록된 쿼리 템플릿의 구조가 변경되는 것을 방지
	//문자열에 대해서 자동으로 이스케이프 처리 
	//ex) ->\' or 1=1 or user_id = \'
	public int updateMemberPassword(String userId, String password, Connection conn) {
		
	      Statement stmt = null;
	      int res = 0;

		
	     try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         conn = DriverManager.getConnection("jdbc:oracle:thin:@db202109141233_high?TNS_ADMIN=C:/CODE/Wallet_DB202109141233", "ADMIN", "2whTpalvmf__");
	         stmt = conn.createStatement();
	         String query = "update member set password = '" + password + "' "
	                  + "where user_id = '" + userId + "'";
	         res = stmt.executeUpdate(query);
	      } catch (ClassNotFoundException | SQLException e) {
	         res = -1;
	         throw new DataAccessException(e);
	      } finally {
	         try {
	            stmt.close();
	            conn.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	      return res;
		
	}

	public int deleteMember(String userId, Connection conn) {
		int res = 0;
		
		Statement stmt = null;
		String query = "delete from member where user_id = '" + userId + "'";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@db202109141233_high?TNS_ADMIN=C:/CODE/Wallet_DB202109141233", "ADMIN", "2whTpalvmf__");
			stmt = conn.createStatement();
			res = stmt.executeUpdate(query);
		} catch (ClassNotFoundException | SQLException e) {
			 throw new DataAccessException(e);
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return res;
		
		
	}
	
	private Member convertAllToMember(ResultSet rset) throws SQLException {
		Member member = new Member();
		member.setUserId(rset.getString("user_id"));
		member.setPassword(rset.getString("password"));
		member.setName(rset.getString("name"));
		member.setEmail(rset.getString("email"));
		member.setBirth(rset.getDate("birth"));
		member.setPhone(rset.getString("phone"));
		return member;
	}
	
	private Member convertRowToMember(String[] columns, ResultSet rset) throws SQLException {
		Member member = new Member();
		for (int i = 0; i < columns.length; i++) {			
			String column = columns[i].toLowerCase();
			column = column.trim();
			
			switch (column) {
			case "user_id": member.setUserId(rset.getString("user_id")); break;
			case "password": member.setPassword(rset.getString("password")); break;
			case "name" : member.setName(rset.getString("name")); break;
			case "email" : member.setEmail(rset.getString("email")); break;
			case "birth" : member.setBirth(rset.getDate("birth")); break;
			case "phone" : member.setPhone(rset.getString("phone")); break;
			default : throw new SQLException("부적절한 컬럼명을 전달했습니다."); //예외처리
			}
		}
		return member;
	}
	
	
	
	
	
	
	
	
	
	
}
