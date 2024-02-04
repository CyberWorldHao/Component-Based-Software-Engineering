package pos.controllers;

import java.util.List;

import pos.biz.BillBiz;
import pos.biz.TableBiz;
import pos.model.Bill;
import pos.model.Table;
import pos.ui.PayBillUI;

public class PayBillCtrlr {

	private PayBillUI payBillUI;
	private TableBiz tableBiz = TableBiz.getInstance();
	private BillBiz billBiz = BillBiz.getInstace();

	public void invokePayBill() {
		payBillUI = new PayBillUI(this);
		List<Table> occupiedTables = tableBiz.getOccupiedTables();
		payBillUI.setOccupiedTables(occupiedTables);
		payBillUI.displayUI();
	}

	public void payBill(Table table) throws Exception {

		tableBiz.canPayBill(table);
		Bill bill = billBiz.payBill(table);
		payBillUI.printBill(bill);
		payBillUI.displaySuccess();
	}
	
	public void invokeDisplayBills() {
		payBillUI = new PayBillUI(this);
		List<Bill> allBills = billBiz.getAllBills();
		payBillUI.displayBills(allBills);
	}

}
