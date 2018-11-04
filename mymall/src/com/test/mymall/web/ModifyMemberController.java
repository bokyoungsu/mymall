package com.test.mymall.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.mymall.dao.MemberDao;
import com.test.mymall.service.MemberService;
import com.test.mymall.vo.Member;

@WebServlet("/ModifyMemberController")
public class ModifyMemberController extends HttpServlet {
	private MemberService memberService;
	//수정 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ModifyMemberController.doGet()");
		memberService = new MemberService();
		//로그인 확인
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember") != null) {
			String id = request.getParameter("id");
			//memberDao.selectMember(String id);
			System.out.println(id);
			Member member = memberService.selectMemberService(id);
			request.setAttribute("member", member);
			//forward
			request.getRequestDispatcher("/WEB-INF/views/modifyMember.jsp").forward(request, response);
		}
		else {
			response.sendRedirect(request.getContextPath() + "/IndexController");
		}
		
	}
	//수정 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ModifyMemberController.doPost()");
		memberService = new MemberService();
		//로그인 확인
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember") != null) {
			Member member = new Member();
			member.setId(request.getParameter("id"));
			member.setPw(request.getParameter("pw"));
			member.setLevel(Integer.parseInt(request.getParameter("level")));
			memberService.modifyMemberService(member);
		}	
		response.sendRedirect(request.getContextPath() + "/LogoutMemberController");
	}
}
