package com.kh.recipe.member.model.service;

import java.sql.Connection;
import java.util.List;

import com.kh.recipe.common.db.JDBCTemplate;
import com.kh.recipe.common.http.HttpConnector;
import com.kh.recipe.common.http.RequestParams;
import com.kh.recipe.common.mail.MailSender;
import com.kh.recipe.member.model.dao.Kakao_MemberDao;
import com.kh.recipe.member.model.dao.MemberDao;
import com.kh.recipe.member.model.dto.Kakao_Member;

public class Kakao_MemberService {

	private Kakao_MemberDao kakao_MemberDao = new Kakao_MemberDao();
	private JDBCTemplate template = JDBCTemplate.getInstance();
	
	public Kakao_Member kakaomemberAuthenticate(String userId, String password) {
		Connection conn = template.getConnection();
		Kakao_Member kakao_member = null;
		try {
			kakao_member = kakao_MemberDao.kakaomemberAuthenticate(userId, password, conn);
			
		}finally {
			template.close(conn);
		}
		
		return kakao_member;
	}

	public Kakao_Member selectMemberById(String userId) {
		
		Connection conn = template.getConnection();
		Kakao_Member kakao_member = null;
		
		try {
			kakao_member = kakao_MemberDao.selectMemberById(userId, conn);
		} finally {
			template.close(conn);
		}
		return kakao_member;
		
		
	}

	public List<Kakao_Member> selectMemberList() {
		
		Connection conn = template.getConnection();
		List<Kakao_Member> kakao_memberList = null;
		
		try {
			kakao_memberList = kakao_MemberDao.selectMemberList(conn);
		} finally {
			template.close(conn);
		}
		
		return kakao_memberList;
	}

	public int insertkakaoMember(Kakao_Member kakao_member) {
		
		Connection conn = template.getConnection();
		int res = 0;
		//회원가입을 진행하고
		
		try {
			res = kakao_MemberDao.insertKakaoMember(kakao_member,conn);
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

	

	public int deleteKakaoMember(String userId) {
		Connection conn = template.getConnection();
		int res = 0;
		try {
			res = kakao_MemberDao.deleteKakaoMember(userId, conn);
			template.commit(conn);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			template.rollback(conn);
		}
		return res;	
	}

	
	
	
	
}
