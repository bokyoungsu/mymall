package com.test.mymall.service;

import org.apache.ibatis.session.SqlSession;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.MemberDao;
import com.test.mymall.dao.MemberItemDao;
import com.test.mymall.vo.Member;

public class MemberService {
	private MemberDao memberDao;
	private MemberItemDao memberItemDao;
	
	
	// 회원정보 수정을 위한 memberDao.selectMember() 메서드를 호출하는 메서드
	public void modifyMemberService(Member member) {
		System.out.println("service.modifyMemberService()");
		memberDao = new MemberDao();
		SqlSession sqlSession = null;
		try {
			sqlSession = DBHelper.getSqlSession();
			memberDao.modifyMember(sqlSession, member);
			sqlSession.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
	}
	// 멤버한명을 조회하기위한 memberDao.selectMember() 메서드를 호출하여 리턴값으로 no id pw level 을 리턴받음
	public Member selectMemberService(String id) {
		System.out.println("service.selectMember()");
		memberDao = new MemberDao();
		SqlSession sqlSession = null;
		Member member = new Member();
		try {
			sqlSession = DBHelper.getSqlSession();
			member = memberDao.selectMember(sqlSession, id);
			sqlSession.commit();
		}catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return member;
	}
	//로그인을 위한 memberDao.login() 메서드를 호출하여 리턴값으로 member 객체에 id값과 level값을 리턴받음
	public Member LoginService(Member member) {
		System.out.println("service.memberLogin()");
		memberDao = new MemberDao();
		SqlSession sqlSession = null;
		try {
			sqlSession = DBHelper.getSqlSession();
			member = memberDao.login(sqlSession,member);
			sqlSession.commit();
		}catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return member;
	}
	
	// 회원가입을 위한 memberDao의 insertMember() 를 호출하는 메서드
	public void insertMemberService(Member member) {
		System.out.println("service.insertMember()");
		SqlSession sqlSession = null;
		memberDao = new MemberDao();
		try {
			sqlSession =  DBHelper.getSqlSession();
			memberDao.insertMember(sqlSession,member);
			sqlSession.commit();
		}catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	}
	
	
	
	// RemoveMemberController 에서 MemberServic.removeMember() 호출 
	public void removeMember(int no ) {
		SqlSession sqlSession = null;
		memberItemDao = new MemberItemDao();
		memberDao = new MemberDao();
		try{
			sqlSession = DBHelper.getSqlSession();
			memberItemDao.getMemberItemList(sqlSession, no); 			
			//1. 메서드
			memberDao = new MemberDao();
			memberDao.deleteMember(sqlSession,no);
			// 2. 메서드
			memberItemDao = new MemberItemDao();
			memberItemDao.deleteMemberItem(sqlSession,no);
			sqlSession.commit();
		}catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
	}

}
