package com.user.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class UserFrontController extends HttpServlet{

	protected ActionForward mappingURI(Action action, HttpServletRequest request, HttpServletResponse response){
		ActionForward forward = new ActionForward();
		try {
			forward = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return forward;
	}

	protected String getLastURI(String before){

		String[] divider = before.split("[/]");
		String after = divider[divider.length-1];
		return after;
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String URI = getLastURI(request.getRequestURI());
		ActionForward forward = null;
		Action action = null;
		request.setCharacterEncoding("utf-8");

		//System.out.println(URI);

		if (URI != null) {
			forward = new ActionForward();
			forward.setRedirect(false);
			// case "가상주소 이름":
			// forward = mappingURI(new 매핑할 액션 클래스명(), request, response);
			// break;

			switch (URI) {

			/*	case "main.ite":
				forward.setRedirect(false);
				forward.setPath("./main/main.jsp");
				break;*/


			case "Main.me":
				forward.setRedirect(false);
				forward.setPath("./main/main.jsp");
				break;

			case "UserList.us":
				System.out.println("회원관리");
				forward = mappingURI(new UserList(),request, response);
				break;

				//member
			case "UserAction.us":
				System.out.println("회원관리 리스트 ㄱㄱ");
				forward.setRedirect(false);
				forward.setPath("./user/list.jsp");
				break;

			case "UserDelPro.us":
				System.out.println("추방");
				forward = mappingURI(new UserDelPro(),request, response);
				break;
			
			case "AboutView.us":
				forward = mappingURI(new AboutView(),request, response);
				break;
				
			case "About.us":
				forward.setRedirect(false);
				forward.setPath("./user/about.jsp");
				break;
				
			case "Aboutin.us":
				forward = mappingURI(new Aboutin(),request, response);
				break;
			}
		}
		if(forward != null){
			if(forward.isRedirect() == true){
				response.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
}