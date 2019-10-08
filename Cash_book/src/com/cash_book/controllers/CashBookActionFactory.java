package com.cash_book.controllers;

import com.cash_book.controllers.action.Action;
import com.cash_book.controllers.action.InputAction;
import com.cash_book.controllers.action.InputFormAction;
import com.cash_book.controllers.action.JoinAction;
import com.cash_book.controllers.action.JoinFormAction;
import com.cash_book.controllers.action.MainAction;
import com.cash_book.controllers.action.OutputAction;
import com.cash_book.controllers.action.OutputFormAction;
import com.cash_book.controllers.action.LoginAction;
import com.cash_book.controllers.action.LoginFormAction;
import com.cash_book.controllers.action.LogoutAction;

public class CashBookActionFactory {
	private CashBookActionFactory() {}
	private static CashBookActionFactory instance = new CashBookActionFactory();
	public static CashBookActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory : "+ command);
		if(command.equals("main")) {
			action = new MainAction();
		}if(command.equals("login_form")) {
			action = new LoginFormAction();
		}if(command.equals("login")) {
			action = new LoginAction();
		}if(command.equals("logout")) {
			action = new LogoutAction();
		}if(command.equals("join_form")) {
			action = new JoinFormAction();
		}if(command.equals("join")) {
			action = new JoinAction();
		}if(command.equals("input_form")) {
			action = new InputFormAction();
		}if(command.equals("input")) {
			action = new InputAction();
		}if(command.equals("output_form")) {
			action = new OutputFormAction(); 
		}if(command.equals("output")) {
			action = new OutputAction();
		}
		return action;
	}
}
