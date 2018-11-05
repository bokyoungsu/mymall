package com.test.mymall.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.mymall.dao.MemberItemDao;
import com.test.mymall.service.MemberItemService;
import com.test.mymall.vo.Member;
import com.test.mymall.vo.MemberItem;

/**
 * Servlet implementation class OrderController
 */
@WebServlet("/OrderController")
public class OrderController extends HttpServlet {
	private MemberItemService memberItemService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OrderController.java.doGet()");
		MemberItem memberItem = new MemberItem();
		memberItemService = new MemberItemService();
		int itemNo = Integer.parseInt(request.getParameter("itemNo"));
		int memberNo = (Integer) request.getSession().getAttribute("memberNo");
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("itemNo", itemNo);
		map.put("memberNo", memberNo);
		memberItemService.insertMemberItemService(map);
		// 주문내역으로 이동 
		response.sendRedirect(request.getContextPath()+"/OrderListController");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
