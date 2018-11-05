package com.test.mymall.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.lang.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.mymall.service.MemberItemService;
import com.test.mymall.vo.PageMarker;


@WebServlet("/OrderListController")
public class OrderListController extends HttpServlet {
	private MemberItemService memberItemService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OrderListController.doGet()");
		System.out.println(request.getParameter("pageNum"));
		int pageNum = 1;
		int contentNum = 10;
		if(request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		System.out.println(request.getParameter("pageNum"));
		int memberNo = (int) request.getSession().getAttribute("memberNo");
		HashMap<String, Integer> numMap = new HashMap<String, Integer>();
		memberItemService = new MemberItemService();
		PageMarker pageMarker = new PageMarker();
		numMap.put("memberNo", memberNo);
		numMap.put("pageNum", pageMarker.getPageNum()*10);
		numMap.put("contentNum", pageMarker.getContentNum());
		int totalCount = memberItemService.getOderListCount(memberNo);
		List<HashMap<String, Object>> list = memberItemService.getMemberItemListService(numMap);
		// 페이징 처리 세팅 
		pageMarker.setTotalCount(totalCount);
		pageMarker.setPageNum(pageNum-1);  
		pageMarker.setContentNum(contentNum);
		pageMarker.setCurrentBlock(pageNum);
		pageMarker.prevAndNextPage(pageNum);
		pageMarker.setLastBlock(pageMarker.getTotalCount());
		pageMarker.setStartPage(pageMarker.getCurrentBlock());
		pageMarker.setEndPage(pageMarker.getLastBlock(), pageMarker.getCurrentBlock());
		
		request.setAttribute("page", pageMarker);
		request.setAttribute("list", list);
		request.getRequestDispatcher("WEB-INF/views/oderItemList.jsp").forward(request, response);
	}
}
