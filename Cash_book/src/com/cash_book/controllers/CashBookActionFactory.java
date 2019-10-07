package com.cash_book.controllers;

import com.cash_book.controllers.action.Action;
import com.cash_book.controllers.action.IndexAction;
import com.cash_book.controllers.action.LoginAction;
import com.cash_book.controllers.action.LoginFormAction;

public class CashBookActionFactory {
	private CashBookActionFactory() {}
	private static CashBookActionFactory instance = new CashBookActionFactory();
	public static CashBookActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory : "+ command);
		if(command.equals("index")) {
			action = new IndexAction();
		}if(command.equals("login_form")) {
			action = new LoginFormAction();
		}if(command.equals("login")) {
			action = new LoginAction();
		}
		return action;
	}

}
