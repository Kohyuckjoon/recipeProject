package com.kh.recipe.common.exception.handler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.recipe.common.exception.HandlableException;

/**
 * Servlet implementation class ExceptionHandler
 */
@WebServlet("/exception-handler")
public class ExceptionHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExceptionHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//서블릿 컨테이너는 HandlableException이 발생하면 요청을 exception-handler로 재지정
		//이때 request의 javax.servlet.error.exception 속성에 발생한 예외를 함께 담아서 넘겨준다.
		HandlableException e = (HandlableException) request.getAttribute("javax.servlet.error.exception");
		
		request.setAttribute("msg", e.error.MESSAGE);
		request.setAttribute("url", e.error.URL);
		request.getRequestDispatcher("/WEB-INF/views/error/result.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
