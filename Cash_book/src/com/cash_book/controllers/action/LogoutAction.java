package com.cash_book.controllers.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class LogoutAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "CashBook?command=main";
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.invalidate();
		}
		//dao close 하기 -> 흠 dao를 close하기 위해 다시 dao에 접속한다..?
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
	}

}
