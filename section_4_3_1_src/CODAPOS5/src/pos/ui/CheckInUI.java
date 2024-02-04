package pos.ui;

import java.util.List;

import pos.controllers.CheckInCtrlr;
import pos.model.Table;

public class CheckInUI extends BaseUI {
	
	private CheckInCtrlr checkInCtrlr;
	private List<Table> emptyTables;
	
	public CheckInUI(CheckInCtrlr checkInCtrlr) {
		super();
		this.checkInCtrlr = checkInCtrlr;
	}
	
	public void setEmptyTables(List<Table> emptyTables) {
		this.emptyTables = emptyTables;
	}
	
	@Override
	protected boolean doDisplayUI() {
		System.out.println("\n---------------");
		System.out.println("    CheckIn");
		System.out.println("---------------\n");	
		
		System.out.println("\nPlease choose a table to seat the guests");
		TableSelectionUI selectTableUI = new TableSelectionUI();
		Table table = selectTableUI.selectTable(emptyTables);
		
		System.out.println("Enter the number of Guests : ");
		int noOfGuests = scanInt();
		
		System.out.println("Enter the waiter name : ");
		String waiter = scanString();
		
		
		try {
			checkInCtrlr.checkIn(table, noOfGuests, waiter);
		} catch (Exception e) {
			displayError(e.getMessage());
		}
		
		return false;
	}

	public void displaySuccess() {
		System.out.println("\n**** SUCCESS - Check in completed successfully! ****\n");
	}

}
