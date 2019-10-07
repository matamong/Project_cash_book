package com.cash_book.controllers;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cash_book.controllers.action.Action;

@WebServlet("/CashBook")
public class CashBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CashBookServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String command = request.getParameter("command");
		System.out.println("CashBookServlet에서의 요청 : " + command);
		CashBookActionFactory actionFactory = CashBookActionFactory.getInstance();
		Action action = actionFactory.getAction(command);
		if(action != null) {
			action.execute(request, response);
		}
	}
}
