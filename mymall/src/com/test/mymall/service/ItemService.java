package com.test.mymall.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.ItemDao;
import com.test.mymall.vo.Item;

public class ItemService {
	private ItemDao itemDao;
	// 페이징 처리를 위한 itemDao.selectItemList() 메서드를 호출하기위한 메서드 
	public ArrayList<Item> selectItemListService(HashMap<String, Integer> map){
		System.out.println("ItemService.java.selectItemListService()");
		itemDao = new ItemDao();
		ArrayList<Item> itemList = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = DBHelper.getSqlSession();
			itemList = (ArrayList<Item>) itemDao.selectItemList(sqlSession,map);
			sqlSession.commit();
		}catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return itemList;
	}
	
	// 상품의 전체행을 구하는 메서드.(물품의 총 갯수)
	public int getTotalItemCountService() {
		System.out.println("ItemService.java.getTotalItemCountService()");
		itemDao = new ItemDao();
		int totalCount= 0;
		SqlSession sqlSession = null;
		try {
			sqlSession = DBHelper.getSqlSession();
			totalCount = itemDao.getTotalItemCount(sqlSession);
			sqlSession.commit();
		}catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		System.out.println(totalCount);
		return totalCount;
	}
}
