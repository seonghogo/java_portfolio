package com.portfolio.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class PortfolioFrontController extends HttpServlet{
   
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
				
			
				
				
				//member
			case "Main.me":
				System.out.println("메인");
				forward.setRedirect(false);
				forward.setPath("./main/main.jsp");
				break;
			
			case "P_listView.ad":
				forward = mappingURI(new P_listView(), request, response);
				break;
				
			case "P_listAction.ad":
				forward.setRedirect(false);
				forward.setPath("./p_folio/p_list.jsp");
				break;
				
			case "p_insert.ad":
				forward.setRedirect(false);
				forward.setPath("./p_folio/p_insert.jsp");
				break;
				
			case "P_insertPro.ad":
				forward = mappingURI(new P_insertPro(), request, response);
				break;
				
			case "P_selectView.ad":
				forward = mappingURI(new P_selectView(), request, response);
				break;
				
			case "P_selectAction.ad":
				forward.setRedirect(false);
				forward.setPath("./p_folio/p_select.jsp");
				break;
				
			case "P_updateView.ad":
				forward = mappingURI(new P_updateView(), request, response);
				break;
			
			case "P_updateAction.ad":
				forward.setRedirect(false);
				forward.setPath("./p_folio/p_update.jsp");
				break;
			
			case "P_updatePro.ad":
				forward = mappingURI(new P_updatePro(), request, response);
				break;
				
			case "P_deletePro.ad":
				forward = mappingURI(new P_deletePro(), request, response);
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