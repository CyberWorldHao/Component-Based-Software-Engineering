package pos.controllers;

import java.util.List;

import pos.biz.TableBiz;
import pos.model.Table;
import pos.ui.CheckInUI;

public class CheckInCtrlr {

	private CheckInUI checkInUI;
	private TableBiz tableBiz = TableBiz.getInstance();

	public void invokeCheckIn() {
		checkInUI = new CheckInUI(this);
		List<Table> emptyTables = tableBiz.getEmptyTables();
		checkInUI.setEmptyTables(emptyTables);
		checkInUI.displayUI();
	}

	public void checkIn(Table table, int noOfGuests, String waiter)
			throws Exception {
		tableBiz.occupyTable(table, noOfGuests, waiter);
		checkInUI.displaySuccess();

	}

}
