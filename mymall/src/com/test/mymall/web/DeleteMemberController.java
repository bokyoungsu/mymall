package com.test.mymall.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.mymall.service.MemberService;
import com.test.mymall.vo.Member;

/**
 * Servlet implementation class DeleteMemberController
 */
@WebServlet("/DeleteMemberController")
public class DeleteMemberController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DeleteMemberController.doGet()");
		request.getRequestDispatcher("WEB-INF/views/deleteMember.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DeleteMemberController.doPost()");	
		MemberService memberService = new MemberService(); 
		Member member = new Member();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		member.setId(id);
		member.setPw(pw);
		member = memberService.LoginService(member);
		if(member.getLevel() != -1) {
			memberService.removeMember(member.getNo());
			
		}else {
			response.sendRedirect(request.getContextPath()+"/IndexController");
		}
		
		
		}

}
