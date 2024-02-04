package pos.controllers;

import pos.ui.AdminUI;

public class AdminCtrlr {
	
	private AdminUI adminUI;
	
	public void invokeAdmin() {
		adminUI = new AdminUI(this);
		adminUI.displayUI();
	}
	
	public void foodAdminInvoked() {
		new FoodAdminCtrlr().invokeFoodAdmin();
	}
	
	public void tableAdminInvoked() {
		new TableAdminCtrlr().invokeTableAdmin();
	}
}
