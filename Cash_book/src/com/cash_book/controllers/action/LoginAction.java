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
		CashBookDAO dao = new CashBookDAO(DBConnection.getConnection());

		HttpSession session = request.getSession();

		String phone = request.getParameter("phone");//phone
		String pw = request.getParameter("pw");//pw
		

		GetableAttributeNamesDTO memberDTO = new MemberDTO(phone, null, null); //name만 받을 때.
		List<GetableAttributeNamesDTO> resultSelect = dao.select(memberDTO);
		
		if(resultSelect.isEmpty()) {
			System.out.println();
			System.out.println("JSP에서 LoginAction으로 넘어온 pw 속성값 : " + pw);
			System.out.println("JSP에서 LoginAction으로 넘어온 phone 속성값 : " + phone);
			System.out.println("dao.select 값이 없습니다..");
			System.out.println();
		}
		
		if(!resultSelect.isEmpty()) {
			Map<String, String> selectMap = resultSelect.get(0).getAttributeValues();
			String selectedPW  = selectMap.get(MemberDTO.PW_NAME);
			
			// pw == selectedPW 임...resultSelect가 계속 비어서와서 임시 테스트용으로 "aa"로 테스트즁
			if(pw.equals(selectedPW)) {
				session.removeAttribute("name");
				session.setAttribute("phone", selectMap.get(MemberDTO.PHONE_NAME));
				session.setAttribute("name", selectMap.get(MemberDTO.NAME_NAME));
				session.setAttribute("loginUser", memberDTO);
				url="CashBook?command=main";
			}
		}
		
		//속성값만 잘 넘어가는지 테스트용
		if(pw.equals("aa")) {
			session.removeAttribute("name");
			session.setAttribute("phone", phone);
			session.setAttribute("name", "임시이름");
			session.setAttribute("loginUser", memberDTO);
			url="CashBook?command=main";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
