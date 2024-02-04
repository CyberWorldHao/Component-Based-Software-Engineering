package posbillui.controllers;

import java.util.List;

import codabook.componentmodel.ComponentInterface;
import codabook.componentmodel.ComponentRegistry;

import pos.model.Bill;
import pos.model.Gratuity;
import pos.model.Table;
import posbill.biz.IBillBiz;
import posbillui.ui.PayBillUI;
import postable.biz.ITableBiz;

public class PayBillCtrlr implements ComponentInterface, IPayBilCtrlr {

	private PayBillUI payBillUI;
	private ITableBiz tableBiz;
	private IBillBiz billBiz;

	public void bindBizServices()
	{
		if(this.tableBiz==null)
		this.tableBiz=(ITableBiz)ComponentRegistry.fetchComponent(ITableBiz.class);
		
		
		if(this.billBiz==null)
		this.billBiz=(IBillBiz)ComponentRegistry.fetchComponent(IBillBiz.class);
		
	}
	

	public void invokePayBill() {
		bindBizServices();
		payBillUI = new PayBillUI(this);
		List<Table> occupiedTables = tableBiz.getOccupiedTables();
		payBillUI.setOccupiedTables(occupiedTables);
		payBillUI.displayUI();
	}

	public void payBill(Table table) throws Exception {
		bindBizServices();
		tableBiz.canPayBill(table);
		Bill bill = billBiz.payBill(table);
		Gratuity gratuity = billBiz.getGratuityForBill(bill);
		payBillUI.printBill(bill, gratuity);
		payBillUI.displaySuccess();
	}
	
	public void invokeDisplayBills() {
		bindBizServices();
		payBillUI = new PayBillUI(this);
		List<Bill> allBills = billBiz.getAllBills();
		payBillUI.displayBills(allBills);
	}

}
