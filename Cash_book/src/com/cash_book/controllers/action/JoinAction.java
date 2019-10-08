package com.cash_book.controllers.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cash_book.model.CashBookDAO;
import com.cash_book.model.GetableAttributeNamesDTO;
import com.cash_book.model.dbConnection.DBConnection;
import com.cash_book.model.member.MemberDTO;

public class JoinAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String url = "JSPTest/failed.jsp";  
		
		String phone = request.getParameter("phone");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		System.out.println();
		System.out.println("loginTestForm에서 넘어온 phone 속성 : " + phone);
		System.out.println("loginTestForm에서 넘어온 pw 속성 : " + pw);
		System.out.println("loginTestForm에서 넘어온 name 속성 : " + name);

		CashBookDAO dao = new CashBookDAO(DBConnection.getConnection());
		
		GetableAttributeNamesDTO selectedMemberDTO = new MemberDTO(phone, null, null);
		List<GetableAttributeNamesDTO> resultSelect = dao.select(selectedMemberDTO);
		
		if(resultSelect.isEmpty()) {
			GetableAttributeNamesDTO insertedMemberDTO = new MemberDTO(phone, name, pw);
			boolean result = dao.insert(insertedMemberDTO);
			System.out.println("dao.insert 결과 : " + result);
			if(result != false)
				url = "JSPTest/success.jsp";
		}else {
			System.out.println("이미 DB에 존재하는 phone 입니다. phone : " + phone);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
