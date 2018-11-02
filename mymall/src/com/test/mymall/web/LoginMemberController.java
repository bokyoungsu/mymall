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


@WebServlet("/LoginMemberController")
public class LoginMemberController extends HttpServlet {
	private MemberService memberService;
	//로그인 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginMemberController.doGet()");
		// 세션에 등록된값이 없으면 login.jsp로 포워드 . 등록된값이 있으면 메인화면으로이동
		if(request.getSession().getAttribute("loginMember") == null) {
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}
		else {
			response.sendRedirect(request.getContextPath() + "/IndexController");
		}
		
	}
	//로그인 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginMemberController.doPost()");
		memberService = new MemberService();
		Member member = new Member();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		member.setId(id);
		member.setPw(pw);
		// 데이터베이스에 id pw 값이 있는지 확인하는 메서드 있으면 member 객체에 id값과 level값을 세팅후 반환 하고 없으면 level값에 -1을 반환
		member = memberService.LoginService(member);
		// 로그인이성공하면 세션객체에 loginMember 이름으로 id값 등록 
		if(member.getLevel() != -1) {
			HttpSession session = request.getSession();
			session.setAttribute("memberNo", member.getNo());
			session.setAttribute("loginMember", member.getId());
			session.setAttribute("memberLogin", member.getLevel());			
			response.sendRedirect(request.getContextPath()+"/IndexController");
		}
		else {
			response.sendRedirect(request.getContextPath()+"/LoginMemberController");
		}
			
	}

}
