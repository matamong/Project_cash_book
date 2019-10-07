package com.cash_book.controllers.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cash_book.model.CashBookDAO;
import com.cash_book.model.GetableAttributeNamesDTO;
import com.cash_book.model.dbConnection.DBConnection;
import com.cash_book.model.member.MemberDTO;

public class LoginAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/JSPTest/loginFailed.jsp";

		HttpSession session = request.getSession();

		String name = request.getParameter("");//name
		String pw = request.getParameter("");//pw
		String phone = request.getParameter("");//phone

		CashBookDAO dao = new CashBookDAO(DBConnection.getConnection());

		GetableAttributeNamesDTO memberDTO = new MemberDTO(phone, name, pw); //name만 받을 때.


		List<GetableAttributeNamesDTO> resultSelect = dao.select(memberDTO);
		if(!resultSelect.isEmpty()) {
			Map<String, String> selectMap = resultSelect.get(0).getAttributeValues();
			String selectedPW  = selectMap.get(MemberDTO.PW_NAME);
			if(pw == selectedPW) {
				session.removeAttribute("name");
				session.setAttribute("loginUser", memberDTO);
				url="CashBook?command=index";
			}
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
