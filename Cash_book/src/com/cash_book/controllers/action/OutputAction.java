package com.cash_book.controllers.action;

import java.io.IOException;
import java.util.ArrayList;
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

public class OutputAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String url = "JSPTest/failed.jsp";

		HttpSession session = request.getSession();
		CashBookDAO dao = new CashBookDAO(DBConnection.getConnection());


		GetableAttributeNamesDTO userDTO = (GetableAttributeNamesDTO)session.getAttribute("loginUser");

		if(userDTO == null) {
			url = "/JSPTest/loginTestForm.jsp"; //자바스크립트로 redirect해도 좋을 듯
			System.out.println("session에 유저정보 없음" );
		}
		//회원이 member에 존재하는지



		if(userDTO != null) {
			List<GetableAttributeNamesDTO> memberSelect = dao.select(userDTO);
			Map<String, String> selectMap = memberSelect.get(0).getAttributeValues();

			String userPhone  = selectMap.get(MemberDTO.PHONE_NAME);
			String userLocalDate = request.getParameter("date");

			System.out.println("session에 저장되어있던 member phone 번호 : " + userPhone);
			System.out.println("request로 넘어온 날짜 : " + userPhone);

			GetableAttributeNamesDTO dateListDTO = new DateListDTO(userPhone, userLocalDate);
			List<GetableAttributeNamesDTO> dateListSelect = dao.select(dateListDTO);

			if(dateListSelect != null) {
				GetableAttributeNamesDTO incomeDTO = new IncomeDTO(userPhone, userLocalDate, null, null, null);
				List<String> incomeDTOList = incomeDTO.getValues();
				GetableAttributeNamesDTO outcomeDTO = new OutcomeDTO(userPhone, userLocalDate, null, null, null);
				List<String> outcomeDTOList = outcomeDTO.getValues();
				
				

				session.setAttribute("incomeDTO", incomeDTO);
				session.setAttribute("outcomeDTO", outcomeDTO);
				session.setAttribute("incomeDTOList", incomeDTOList);
				session.setAttribute("outcomeDTOList", outcomeDTOList);

				url = "/JSPTest/outputListTest.jsp"; 

			}else {
				url = "/JSPTest/failed.jsp";
				System.out.println("dateList에 유저정보 없음" );
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
