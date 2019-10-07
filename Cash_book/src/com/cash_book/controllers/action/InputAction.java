package com.cash_book.controllers.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class InputAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/JSPTest/failed.jsp";
		HttpSession session = request.getSession();
		
		session.getAttribute("loginUser");
		System.out.println();
		
	}

}
