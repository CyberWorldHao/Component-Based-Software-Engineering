package pos.controllers;

import java.util.List;

import pos.biz.TableBiz;
import pos.model.Table;
import pos.ui.CheckOutUI;

public class CheckOutCtrlr {

	private CheckOutUI checkOutUI;
	private TableBiz tableBiz = TableBiz.getInstance();

	public void invokeCheckOut() {

		checkOutUI = new CheckOutUI(this);
		List<Table> occupiedTables = tableBiz.getOccupiedTables();
		checkOutUI.setOccupiedTables(occupiedTables);
		checkOutUI.displayUI();
	}

	public void checkOutTableSelected(Table table) throws Exception {
		tableBiz.unOccupyTable(table);
		checkOutUI.displaySuccess();
	}
}
