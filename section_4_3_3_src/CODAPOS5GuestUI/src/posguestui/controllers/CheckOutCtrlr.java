package posguestui.controllers;

import java.util.List;

import pos.model.Table;
import posguestui.ui.CheckOutUI;
import postable.biz.ITableBiz;
import codabook.componentmodel.ComponentInterface;
import codabook.componentmodel.ComponentRegistry;

public class CheckOutCtrlr implements ComponentInterface, ICheckOutCtrlr {

	private CheckOutUI checkOutUI;
	private ITableBiz tableBiz;
	
	public void bindBizServices()
	{
		if(this.tableBiz==null)
		this.tableBiz=(ITableBiz)ComponentRegistry.fetchComponent(ITableBiz.class);
	}

	@Override
	public void invokeCheckOut() {
		bindBizServices();
		checkOutUI = new CheckOutUI(this);
		List<Table> occupiedTables = tableBiz.getOccupiedTables();
		checkOutUI.setOccupiedTables(occupiedTables);
		checkOutUI.displayUI();
	}

	@Override
	public void checkOutTableSelected(Table table) throws Exception {
		bindBizServices();
		tableBiz.unOccupyTable(table);
		checkOutUI.displaySuccess();
	}
}
