package posguestui.ui;

import java.util.List;

import pos.model.Table;
import posguestui.controllers.ICheckOutCtrlr;

public class CheckOutUI extends BaseUI {

	private ICheckOutCtrlr checkOutCtrlr;
	private List<Table> occupiedTables;

	public CheckOutUI(ICheckOutCtrlr checkOutCtrlr) {
		super();
		this.checkOutCtrlr = checkOutCtrlr;
	}

	public void setOccupiedTables(List<Table> occupiedTables) {
		this.occupiedTables = occupiedTables;
	}

	@Override
	protected boolean doDisplayUI() {
		System.out.println("\n------------");
		System.out.println("  Checkout");
		System.out.println("------------\n");
		if (occupiedTables.isEmpty()) {
			displayError("SORRY - None of the tables is occupied!");
			return false;
		}

		System.out.println("Please choose a table to checkout guests from");
		TableSelectionUI selectTableUI = new TableSelectionUI();
		Table table = selectTableUI.selectTable(occupiedTables);
		try {
			checkOutCtrlr.checkOutTableSelected(table);
		} catch (Exception e) {
			displayError(e.getMessage());
		}
		return false;
	}

	public void displaySuccess() {
		System.out
				.println("\n**** SUCCESS - Checkout completed successfully! ****\n");
	}

}
