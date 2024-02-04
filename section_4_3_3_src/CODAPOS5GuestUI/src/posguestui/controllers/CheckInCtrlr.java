package posguestui.controllers;

import java.util.List;

import pos.model.Table;
import posguestui.ui.CheckInUI;
import postable.biz.ITableBiz;
import codabook.componentmodel.ComponentInterface;
import codabook.componentmodel.ComponentRegistry;

public class CheckInCtrlr implements ComponentInterface, ICheckInCtrlr {

	private CheckInUI checkInUI;
	private ITableBiz tableBiz;

	
	public void bindBizServices()
	{
		if(this.tableBiz==null)
		this.tableBiz=(ITableBiz)ComponentRegistry.fetchComponent(ITableBiz.class);
	}
	
	
	@Override
	public void invokeCheckIn() {
		bindBizServices();
		checkInUI = new CheckInUI(this);
		List<Table> emptyTables = tableBiz.getEmptyTables();
		checkInUI.setEmptyTables(emptyTables);
		checkInUI.displayUI();
	}

	@Override
	public void checkIn(Table table, int noOfGuests, String waiter)
			throws Exception {
		bindBizServices();
		tableBiz.occupyTable(table, noOfGuests, waiter);
		checkInUI.displaySuccess();

	}

}
