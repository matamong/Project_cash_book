package com.cash_book.controllers;

import com.cash_book.controllers.action.Action;
import com.cash_book.controllers.action.MainAction;
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
		}
		
		return action;
	}

}
