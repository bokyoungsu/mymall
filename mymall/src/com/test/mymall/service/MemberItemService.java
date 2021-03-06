package com.test.mymall.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.websocket.Session;

import org.apache.ibatis.session.SqlSession;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.MemberItemDao;

public class MemberItemService {
	MemberItemDao memberItemDao;
	
	public void insertMemberItemService(HashMap<String, Integer> map) {
		System.out.println("MemberItemService.java.insertMemberItemService()");
		memberItemDao = new MemberItemDao();
		SqlSession sqlSession = null;
		try {
			sqlSession = DBHelper.getSqlSession();
			memberItemDao.insertMemberItem(sqlSession, map);
			sqlSession.commit();
		}catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	
	}
	public int getOderListCount(int memberNo) {
		System.out.println("MemberItemService.java.getOderListCount()");
		int oderListCount = 0;
		memberItemDao = new MemberItemDao();
		SqlSession sqlSession = null;
		try {
			sqlSession = DBHelper.getSqlSession();
			oderListCount = memberItemDao.getOderListCount(sqlSession, memberNo);
			sqlSession.commit();
		}catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return oderListCount;
	}
	public List<HashMap<String, Object>> getMemberItemListService(HashMap<String, Integer> numMap){
		System.out.println("MemberItemService.java.getMemberItemListService()");
		List<HashMap<String,Object>> list = null;
		memberItemDao = new MemberItemDao();
		SqlSession sqlSession = null;
		try {
			sqlSession = DBHelper.getSqlSession();
			list = memberItemDao.getMemberItemList(sqlSession, numMap);
			sqlSession.commit();
		}catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return list;
	}
}
