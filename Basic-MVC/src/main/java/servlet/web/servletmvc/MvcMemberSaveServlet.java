package servlet.web.servletmvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.domain.Repository.MemberRepository;
import servlet.domain.member.Member;

@WebServlet(name = "mvcMemberSaveServlet", urlPatterns = "/servlet-mvc/members/save")
public class MvcMemberSaveServlet extends HttpServlet{
	
	private MemberRepository memberRepository = MemberRepository.getInstance();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));
		Member member = new Member(username, age);
		
		memberRepository.save(member);
		
		//Model에 데이터를 보관
		request.setAttribute("member",member); // table 구조와 비슷
		
		String viewPath = "/WEB-INF/views/save-result.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(viewPath);
		requestDispatcher.forward(request,response);
		
	}
	
}
