package pos.controllers;

import java.util.List;

import pos.biz.TableBiz;
import pos.model.Table;
import pos.ui.TableAdminUI;

public class TableAdminCtrlr {

	private TableBiz tableBiz = TableBiz.getInstance();

	private TableAdminUI tableAdminUI;

	public void invokeTableAdmin() {
		tableAdminUI = new TableAdminUI(this);
		tableAdminUI.displayUI();
	}

	public void configureInvoked() {
		int currentNoOfTables = tableBiz.getNoOfTables();
		tableAdminUI.displayConfigScreen(currentNoOfTables);
	}

	public void tablesConfigured(int newNoOfTables) throws Exception {
		tableBiz.reconfigureTables(newNoOfTables);
		tableAdminUI.displayConfigSuccess();

	}

	public void showOccupiedInvoked() {
		List<Table> occupiedTables = tableBiz.getOccupiedTables();
		tableAdminUI.displayOccupiedTables(occupiedTables);
	}

	public void showEmptyInvoked() {
		List<Table> emptyTables = tableBiz.getEmptyTables();
		tableAdminUI.displayEmptyTables(emptyTables);
	}

}
