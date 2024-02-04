package posadmin.controllers;

import posadmin.ui.AdminUI;
import codabook.componentmodel.ComponentInterface;

public class AdminCtrlr implements ComponentInterface, IAdminCtrlr {
	
	private AdminUI adminUI;
	
	@Override
	public void invokeAdmin() {
		adminUI = new AdminUI(this);
		adminUI.displayUI();
	}
	
	@Override
	public void foodAdminInvoked() {
		new FoodAdminCtrlr().invokeFoodAdmin();
	}
	
	@Override
	public void tableAdminInvoked() {
		new TableAdminCtrlr().invokeTableAdmin();
	}
}
