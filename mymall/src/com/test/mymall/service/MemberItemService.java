package com.test.mymall.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.MemberItemDao;

public class MemberItemService {
	MemberItemDao memberItemDao;
	public void insertMemberItemService(HashMap<String, Integer> map) {
		System.out.println("insertMemberItemService()");
		memberItemDao = new MemberItemDao();
		Connection connection = null;
		try {
			connection = DBHelper.getConnection();
			memberItemDao.insertMemberItem(connection, map);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(null, null, connection);
		}
	
	}
	public ArrayList<HashMap<String, Object>> getMemberItemListService(int memberNO){
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		System.out.println("getMemberItemListService()");
		memberItemDao = new MemberItemDao();
		Connection connection = null;
		try {
			connection = DBHelper.getConnection();
			list = memberItemDao.getMemberItemList(connection, memberNO);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(null, null, connection);
		}
		return list;
	}
}
