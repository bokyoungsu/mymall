package com.test.mymall.service;

import java.sql.Connection;

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
		Connection connection = null;
		try {
			connection = DBHelper.getConnection();
			this.memberDao.modifyMember(connection, member);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(null, null, connection);
		}
		
	}
	// 멤버한명을 조회하기위한 memberDao.selectMember() 메서드를 호출하여 리턴값으로 no id pw level 을 리턴받음
	public Member selectMemberService(String id) {
		System.out.println("service.selectMember()");
		memberDao = new MemberDao();
		Connection connection = null;
		Member member = new Member();
		try {
			connection = DBHelper.getConnection();
			member = memberDao.selectMember(connection, id);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(null, null, connection);
		}
		return member;
	}
	//로그인을 위한 memberDao.login() 메서드를 호출하여 리턴값으로 member 객체에 id값과 level값을 리턴받음
	public Member LoginService(Member member) {
		System.out.println("service.memberLogin()");
		memberDao = new MemberDao();
		Connection connection = null;
		try {
			connection = DBHelper.getConnection();
			member = memberDao.login(connection,member);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(null, null, connection);
		}
		return member;
	}
	
	// 회원가입을 위한 memberDao의 insertMember() 를 호출하는 메서드
	public void insertMemberService(Member member) {
		System.out.println("service.insertMember()");
		memberDao = new MemberDao();
		Connection connection = null;
		try {
			connection = DBHelper.getConnection();
			memberDao.insertMember(connection,member);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(null, null, connection);
		}
	}
	
	
	
	// RemoveMemberController 에서 MemberServic.removeMember() 호출 
	public void removeMember(int no ) {
		Connection connection = null;
		memberItemDao = new MemberItemDao();
		memberDao = new MemberDao();
		try{
			connection = DBHelper.getConnection();
			memberItemDao.getMemberItemList(connection, no);
			connection.setAutoCommit(false);// 자동으로 커밋 안함
 			
			//1. 메서드
			memberDao = new MemberDao();
			memberDao.deleteMember(connection,no);
			// 2. 메서드
			memberItemDao = new MemberItemDao();
			memberItemDao.deleteMemberItem(connection,no);
			connection.commit();
		}catch (Exception e) {
			try{
				connection.rollback();
			}catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DBHelper.close(null, null, connection);
		}
		
	}

}
