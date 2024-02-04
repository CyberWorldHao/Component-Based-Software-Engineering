package posadmin.ui;

import posadmin.controllers.IAdminCtrlr;

public class AdminUI extends BaseUI {

	IAdminCtrlr adminCtrlr;

	public AdminUI(IAdminCtrlr adminCtrlr) {
		super();
		this.adminCtrlr = adminCtrlr;
	}

	@Override
	protected boolean doDisplayUI() {
		System.out.println("\n-------------------------");
		System.out.println("Restaurant Administration");
		System.out.println("-------------------------\n");
		System.out.println("1. Food Administration");
		System.out.println("2. Table Administration");
		System.out.println("0. Exit\n");

		System.out.print(">>");

		int choice = scanInt();

		switch (choice) {

		case 1:
			adminCtrlr.foodAdminInvoked();
			break;
			
		case 2:
			adminCtrlr.tableAdminInvoked();
			break;
			
		default:
			return false;
		}

		return true;
	}

}
