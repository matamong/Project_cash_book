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
import com.cash_book.model.dateList.DateListDTO;
import com.cash_book.model.dbConnection.DBConnection;
import com.cash_book.model.income.IncomeDTO;
import com.cash_book.model.member.MemberDTO;
import com.cash_book.model.outcome.OutcomeDTO;

public class InputAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String url = "/JSPTest/failed.jsp";
		HttpSession session = request.getSession();
		CashBookDAO dao = new CashBookDAO(DBConnection.getConnection());
		
		GetableAttributeNamesDTO userDTO = (GetableAttributeNamesDTO)session.getAttribute("loginUser");
		
		if(userDTO == null) {
			url = "/JSPTest/loginTestForm.jsp"; //자바스크립트로 redirect해도 좋을 듯
			System.out.println("session에 유저정보 없음" );
			//session.setAttribute("inputResult", false);
		}
		
		if(userDTO != null) {
			List<GetableAttributeNamesDTO> resultSelect = dao.select(userDTO);
			Map<String, String> userMap = resultSelect.get(0).getAttributeValues();
			
			String userPhone  = userMap.get(MemberDTO.PHONE_NAME);
			System.out.println("input을 시도하는 user의 phone : " + userPhone);
			String name = request.getParameter("name");
			String userLocalDate = request.getParameter("date");
			String userAmount = request.getParameter("amount");
			String userMemo = request.getParameter("memo");
			String select = request.getParameter("select");
		
			GetableAttributeNamesDTO dateListDTO = new DateListDTO(userPhone, userLocalDate);
			boolean dateListResult = dao.insert(dateListDTO);
			
			if(dateListResult == true)
			System.out.println("dateList insert 완료.. " + select + "으로의 시도");
			
			if(select.equals("income")) {
				GetableAttributeNamesDTO inputDTO = new IncomeDTO(userPhone, userLocalDate, name, userAmount, userMemo);
				boolean inputResult = dao.insert(inputDTO);
				System.out.println("수입정보  DB 저장여부 : " + inputResult);
				//session.setAttribute("inputResult", inputResult);
			}else if(select.equals("outcome")) {
				GetableAttributeNamesDTO outputDTO = new OutcomeDTO(userPhone, userLocalDate, name, userAmount, userMemo);
				boolean inputResult = dao.insert(outputDTO);
				System.out.println("지출정보  DB 저장여부 : " + inputResult);
				//session.setAttribute("inputResult", inputResult);
			}else {
				System.out.println("테이블 접근 실패");
			}
		}
	}
}
