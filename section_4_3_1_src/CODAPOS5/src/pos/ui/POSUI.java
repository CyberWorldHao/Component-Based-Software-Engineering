package pos.ui;

import pos.controllers.AdminCtrlr;
import pos.controllers.CheckInCtrlr;
import pos.controllers.CheckOutCtrlr;
import pos.controllers.OrderCtrlr;
import pos.controllers.PayBillCtrlr;

public class POSUI extends BaseUI {


	@Override
	protected boolean doDisplayUI() {

		System.out.println("\n----------------------");
		System.out.println("Welcome to Restaurant");
		System.out.println("----------------------\n");
		System.out.println("1. Guests Checkin");
		System.out.println("2. Manage Orders");
		System.out.println("3. Pay Bill");
		System.out.println("4. Guests Checkout");
		System.out.println("5. Restaurant Administration");
		System.out.println("6. Collection Report");
		System.out.println("0. Exit\n");

		System.out.print(">>");

		int choice = scanInt();

		switch (choice) {

		case 1:
			new CheckInCtrlr().invokeCheckIn();
			break;

		case 2:
			new OrderCtrlr().invokeOrders();
			break;
			
		case 3:
			new PayBillCtrlr().invokePayBill();
			break;
			
		case 4:
			new CheckOutCtrlr().invokeCheckOut();
			break;
			
		case 5:
			new AdminCtrlr().invokeAdmin();
			break;

		case 6:
			new PayBillCtrlr().invokeDisplayBills();
			break;
			
		default: 
			return false;
		
		}

		return true;
	}

}
