package com.test.mymall.service;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.ItemDao;
import com.test.mymall.vo.Item;

public class ItemService {
	private ItemDao itemDao;
	// 페이징 처리를 위한 itemDao.selectItemList() 메서드를 호출하기위한 메서드 
	public ArrayList<Item> selectItemListService(HashMap<String, Integer> map){
		itemDao = new ItemDao();
		ArrayList<Item> itemList = new ArrayList<Item>();
		Connection connection = null;
		try {
			connection = DBHelper.getConnection();
			itemList = itemDao.selectItemList(connection,map);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(null, null, connection);
		}
		return itemList;
	}
	
	// 상품의 전체행을 구하는 메서드.(물품의 총 갯수)
	public int getTotalItemCountService() {
		itemDao = new ItemDao();
		int totalCount= 0;
		Connection connection = null;
		try {
			connection = DBHelper.getConnection();
			totalCount = itemDao.getTotalItemCount(connection);
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(null, null, connection);
		}
		
		return totalCount;
	}
}
