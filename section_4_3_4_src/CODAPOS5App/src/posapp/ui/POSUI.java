package posapp.ui;

import posadmin.controllers.IAdminCtrlr;
import posbillui.controllers.IPayBilCtrlr;
import posbillui.ui.BaseUI;
import posguestui.controllers.ICheckInCtrlr;
import posguestui.controllers.ICheckOutCtrlr;
import posorderui.controllers.IOrderCtrlr;
import codabook.componentmodel.ComponentRegistry;


public class POSUI extends BaseUI {

	private ICheckInCtrlr checkInCtrlrService;
	private IOrderCtrlr orderCtrlrService;
	private IPayBilCtrlr payBillCtrlrService;
	private ICheckOutCtrlr checkOutCtrlrService;
	private IAdminCtrlr adminCtrlrService;
	
	public void bindBizServices()
	{
		if(this.checkInCtrlrService==null)
		this.checkInCtrlrService=(ICheckInCtrlr)ComponentRegistry.fetchComponent(ICheckInCtrlr.class);
	
	
		if(this.orderCtrlrService==null)
			this.orderCtrlrService=(IOrderCtrlr)ComponentRegistry.fetchComponent(IOrderCtrlr.class);
		
		if(this.payBillCtrlrService==null)
			this.payBillCtrlrService=(IPayBilCtrlr)ComponentRegistry.fetchComponent(IPayBilCtrlr.class);
		
		if(this.checkOutCtrlrService==null)
			this.checkOutCtrlrService=(ICheckOutCtrlr)ComponentRegistry.fetchComponent(ICheckOutCtrlr.class);
	
		if(this.adminCtrlrService==null)
			this.adminCtrlrService=(IAdminCtrlr)ComponentRegistry.fetchComponent(IAdminCtrlr.class);
	
	}
	
	
	

	@Override
	protected boolean doDisplayUI() {
		bindBizServices();
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
			checkInCtrlrService.invokeCheckIn();
			break;

		case 2:
			orderCtrlrService.invokeOrders();
			break;
			
		case 3:
			payBillCtrlrService.invokePayBill();
			break;
			
		case 4:
			checkOutCtrlrService.invokeCheckOut();
			break;
			
		case 5:
			adminCtrlrService.invokeAdmin();
			break;

		case 6:
			payBillCtrlrService.invokeDisplayBills();
			break;
			
		default: 
			return false;
		
		}

		return true;
	}

}
