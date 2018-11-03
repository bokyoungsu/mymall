package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.vo.Item;
import com.test.mymall.vo.Member;

public class ItemDao {
	/**
	 * 현재 페이지에서 한 페이지에 보여지는 개수만큼 물품정보를 데이터베이스에서 가져온다
	 * 
	 * @return 물품정보(Item)의 리스트
	 * @param currentPage 현재 보여지는 페이지의 번호
	 * @param rowPerPage 한 페이지에 보여지는 아이템의 개수
	 */
	
	public List<Item> selectItemList(SqlSession sqlSession,HashMap<String, Integer> map) {
		System.out.println("ItemDao.java.selectItemList()");
		return sqlSession.selectList("com.test.mymall.dao.Item.selectItemList", map);
	}
	/**
	 * 데이터베이스에서 물품의 총 개수를 얻어온다
	 * 
	 * @return 물품의 총 갯수
	 */
	public int getTotalItemCount(SqlSession sqlSession) {
		System.out.println("ItemDao.java.getTotalItemCount()");
		return sqlSession.selectOne("com.test.mymall.dao.Item.getTotalItemCount");
	}
}
