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
		request.setCharacterEncoding("utf-8");

		String url = "/JSPTest/failed.jsp";
		CashBookDAO dao = new CashBookDAO(DBConnection.getConnection());
		HttpSession session = request.getSession();

		String phone = request.getParameter("phone");//phone
		String pw = request.getParameter("pw");//pw
		
		GetableAttributeNamesDTO memberDTO = new MemberDTO(phone, null, null); //name만 받을 때.
		List<GetableAttributeNamesDTO> resultSelect = dao.select(memberDTO);
		
		if(resultSelect.isEmpty()) {
			System.out.println("resultSelect 가 비었습니다.");
		}
		
		if(!resultSelect.isEmpty()) {
			Map<String, String> selectMap = resultSelect.get(0).getAttributeValues();
			String selectedPW  = selectMap.get(MemberDTO.PW_NAME);
			
			if(pw.equals(selectedPW)) {
				session.removeAttribute("name");
				session.setAttribute("phone", selectMap.get(MemberDTO.PHONE_NAME));
				session.setAttribute("name", selectMap.get(MemberDTO.NAME_NAME));
				session.setAttribute("loginUser", memberDTO);
				url="CashBook?command=main";
			}
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
