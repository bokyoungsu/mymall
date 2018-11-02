package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.mymall.commons.DBHelper;

public class MemberItemDao {
	// 주문목록 삭제를 위한 메서드
	
	public void insertMemberItem(Connection connection,HashMap<String, Integer> map) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement("INSERT INTO member_item VALUES(?,?,date());");
			preparedStatement.setInt(1, map.get("memberNo"));
			preparedStatement.setInt(2, map.get("itemNo"));
			preparedStatement.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(null, preparedStatement, connection);
		}
	}
	
	public void deleteMemberItem(Connection connection,int no) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM member_item WHERE member_no=?");
			preparedStatement.setInt(1, no);
			preparedStatement.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(null, preparedStatement, connection);
		}
		
	}
	// 주문목록 조회를 위한 메서드 
	public ArrayList<HashMap<String, Object>> getMemberItemList(Connection connection,int memberNO){
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		System.out.println("getMemberItemList()");
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBHelper.getConnection();
			preparedStatement = connection.prepareStatement("SELECT mi.no, mi.order_date, mi.item_no, i.name, i.price FROM member_item mi JOIN item ON mi.item_no = i.no WHERE mi.member_no= ?");
			preparedStatement.setInt(1, memberNO);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("memberNo", resultSet.getInt("mi.no"));
			map.put("memberItemNo", resultSet.getInt("mi.item_no"));
			map.put("itemName", resultSet.getInt("i.name"));
			map.put("itemPrice", resultSet.getInt("i.price"));
			map.put("oderDate", resultSet.getInt("mi.order_date"));
			list.add(map);
		}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(resultSet, preparedStatement, connection);
		}
		return list;
	}
	
}
