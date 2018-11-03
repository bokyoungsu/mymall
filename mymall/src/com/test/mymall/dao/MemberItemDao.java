package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.test.mymall.commons.DBHelper;

public class MemberItemDao {
	// 주문목록 삭제를 위한 메서드
	
	public void insertMemberItem(SqlSession sqlSession,HashMap<String, Integer> map) {
		System.out.println("MemberItemDao.java.insertMemberItem()");
		sqlSession.insert("com.test.mymall.dao.MemberItem.insertMemberItem", map);
	}
	//주문목록삭제를위한 메서드
	public void deleteMemberItem(SqlSession sqlSession,int no) {
		System.out.println("MemberItemDao.java.deleteMemberItem()");
		sqlSession.delete("com.test.mymall.dao.MemberItem.deleteMemberItem", no);
	}
	// 주문목록 조회를 위한 메서드 
	public List<HashMap<String, Object>> getMemberItemList(SqlSession sqlSession,int memberNO){
		System.out.println("MemberItemDao.java.getMemberItemList()");
		return sqlSession.selectList("com.test.mymall.dao.MemberItem.getMemberItemList", memberNO);
	}
	
}
