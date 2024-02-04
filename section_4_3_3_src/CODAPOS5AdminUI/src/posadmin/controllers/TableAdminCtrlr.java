package posadmin.controllers;

import java.util.List;

import pos.model.Table;
import posadmin.ui.TableAdminUI;
import postable.biz.ITableBiz;
import codabook.componentmodel.ComponentRegistry;

public class TableAdminCtrlr {

	private ITableBiz tableBiz;
	private TableAdminUI tableAdminUI;

	
	
	public void bindBizServices()
	{
		if(this.tableBiz==null)
		this.tableBiz=(ITableBiz)ComponentRegistry.fetchComponent(ITableBiz.class);
	}
	
	public void invokeTableAdmin() {
		bindBizServices();
		tableAdminUI = new TableAdminUI(this);
		tableAdminUI.displayUI();
	}

	public void configureInvoked() {
		bindBizServices();
		int currentNoOfTables = tableBiz.getNoOfTables();
		tableAdminUI.displayConfigScreen(currentNoOfTables);
	}

	public void tablesConfigured(int newNoOfTables) throws Exception {
		bindBizServices();
		tableBiz.reconfigureTables(newNoOfTables);
		tableAdminUI.displayConfigSuccess();

	}

	public void showOccupiedInvoked() {
		bindBizServices();
		List<Table> occupiedTables = tableBiz.getOccupiedTables();
		tableAdminUI.displayOccupiedTables(occupiedTables);
	}

	public void showEmptyInvoked() {
		bindBizServices();
		List<Table> emptyTables = tableBiz.getEmptyTables();
		tableAdminUI.displayEmptyTables(emptyTables);
	}

}
