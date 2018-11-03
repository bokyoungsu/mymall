package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.ibatis.session.SqlSession;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.vo.Member;

public class MemberDao {
	/** 
	 * 폼에서 입력한 멤버의 정보를 데이터베이스에 등록
	 * 
	 * @param Member 폼에서 입력한 멤버의 정보(id,pw,level)
	 */
	// 입력값으로 id pw level 을 입력받아 member 테이블에 입력하는 메서드
	// 보통 리턴값을 받아 회원가입이 완료됐는지 실패했는지 판단 
	// 두개이상의 쿼리를 사용하는것 트랜잭션
	
	
	// 회원탈퇴(회원삭제)를위한 메서드 
	public void deleteMember(SqlSession sqlSession,int no) {
		System.out.println("MemberDao.java.deleteMember()");
		sqlSession.delete("com.test.mymall.dao.Member.deleteMember", no);
	}
	//회원가입을 위한 메서드 
	public void insertMember(SqlSession sqlSession,Member member) {
		System.out.println("MemberDao.java.insertMember()");
		sqlSession.insert("com.test.mymall.dao.Member.insertMember", member);
	}
	//id와 pw값을 가지는 member객체를 이용해 로그인체크를 하는 메서드
	//데이터베이스에서 id와pw일치시  member 객체에 id값과 level값을 대입후 리턴
	public Member login(SqlSession sqlSession,Member member) {
		System.out.println("MemberDao.java.login()");
		return sqlSession.selectOne("com.test.mymall.dao.Member.login", member);	
		
		
	}
	/**
	 * 데이터베이스에서 로그인된 회원의 id에 해당하는 회원정보를 가져온다
	 * 
	 * @param	id	로그인된 회원의 id
	 * @return	회원의정보(no,id,pw,level)
	 */
	// 회원 정보한명을 조회하는 메서드 
	public Member selectMember(SqlSession sqlSession,String id) {
		System.out.println("MemberDao.java.selectMember()");
		return (Member) sqlSession.selectOne("com.test.mymall.vo.Member.deleteMember", id);
	}
    /**
     * 매개변수로전달된 로그인한 회원의 수정된 데이터(member)를 데이터베이스에서 갱신
     *
     * @param   member   로그인한 회원의 수정된 데이터(pw,level)
     * @return  없음
     */
	// 회원정보 수정을 위한 메서드 
	public void modifyMember(SqlSession sqlSession,Member member) {
		System.out.println("MemberDao.java.modifyMember()");
		sqlSession.update("com.test.mymall.vo.Member.modifyMember", member);
	}
}
