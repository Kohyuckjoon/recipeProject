package com.kh.recipe.member.model.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.recipe.common.db.JDBCTemplate;
import com.kh.recipe.common.http.HttpConnector;
import com.kh.recipe.common.http.RequestParams;
import com.kh.recipe.common.mail.handler.MailSender;
import com.kh.recipe.member.model.dao.MemberDao;
import com.kh.recipe.member.model.dto.Member;

//Service
//어플리케이션의 비지니스로직을 작성
//사용자의 요청을 컨트롤러로 부터 위임받아 해당 요청을 처리하기 위해 필요한 핵심적인 작업을 진행
//작업을 수행하기 위해 데이터베이스에 저장된 데이터가 필요하면 Dao에게 요청
//비지니스로직을 Service가 담당하기 때문에 Transaction관리를 Service가 담당.
//commit,rollback을 Service가 담당

//Connection객체 생성, close처리
//commit, rollback
//SQLException에 대한 예외처리(Rollback)
public class MemberService {

	private MemberDao memberDao = new MemberDao();
	private JDBCTemplate template = JDBCTemplate.getInstance();
	
	public Member memberAuthenticate(String id, String password) {
		Connection conn = template.getConnection();
		Member member = null;
		try {
			member = memberDao.memberAuthenticate(id, password, conn);
		}finally {
			template.close(conn);
		}
		
		return member;
	}

	public Member selectMemberById(String id) {
		
		Connection conn = template.getConnection();
		Member member = null;
		
		try {
			member = memberDao.selectMemberById(id, conn);
		} finally {
			template.close(conn);
		}
		return member;
		
		
	}

	public List<Member> selectMemberList() {
		
		Connection conn = template.getConnection();
		List<Member> memberList = null;
		
		try {
			memberList = memberDao.selectMemberList(conn);
		} finally {
			template.close(conn);
		}
		
		return memberList;
	}

	public int insertMember(Member member) {
		
		Connection conn = template.getConnection();
		int res = 0;
		//회원가입을 진행하고
		
		try {
			res = memberDao.insertMember(member,conn);
			//회원가입에 성공하면 아이디로 회원의 정보를 받아와서 Controller 반환
			//Member member = memberDao.selectMemberById(member.getUserId(), conn);
			template.commit(conn);
			
			} catch(Exception e) {
				template.rollback(conn);
				throw e;
		}finally {
			template.close(conn);
		}
		return res;
	}

	public int updateMemeberPassword(String id, String password) {
		Connection conn = template.getConnection();
		int res = 0;
		
		try {
			res = memberDao.updateMemberPassword(id, password, conn);
			template.commit(conn);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			template.rollback(conn);
			
		} finally {
			template.close(conn);
		}
		return res; 
	} 

	public int deleteMember(String id) {
		Connection conn = template.getConnection();
		int res = 0;
		try {
			res = memberDao.deleteMember(id, conn);
			template.commit(conn);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			template.rollback(conn);
		}
		return res;	
	}

	public static void authenticateByEmail(Member member, String persistToken) {
		MailSender mailSender = new MailSender();
		HttpConnector conn = new HttpConnector();

		String queryString = conn.urlEncodedForm(RequestParams
												.builder()
												.param("mailTemplate", "join-auth-mail")
												.param("id", member.getId())
												.param("persistToken", persistToken).build());
		
		String response 
		= conn.get("http://localhost:9090/mail?" + queryString);
		mailSender.sendEmail(member.getEmail(),"회원가입 축하합니다.", response);
		
		
	}
	
	
	
	
	
	
}
