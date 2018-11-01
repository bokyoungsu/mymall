package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.mymall.commons.DBHelper;

public class MemberItemDao {
	// Member INNER JOIN item
	public ArrayList<HashMap<String, Object>> getMemberItemList(int memberNO){
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		System.out.println("getMemberItemList()");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBHelper.getConnection();
			preparedStatement = connection.prepareStatement("SELECT mi.no, mi.order_date, mi.item_no, i.name, i.price FROM member_item mi JOIN item ON mi.item_no = i.no WHERE mi.member_no member= ?");
		}catch (Exception e) {
			
		}
/*
		while(resultSet.next()) {
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("memberItemNo", resultSet.getInt("mi.no"));
			map.put("itemPrice", resultSet.getInt("i.price"));
			list.add(map);
		}
		*/
		return list;
	}
	
}
