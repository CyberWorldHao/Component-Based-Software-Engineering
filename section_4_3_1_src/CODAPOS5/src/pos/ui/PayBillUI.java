package pos.ui;

import java.util.List;

import pos.controllers.PayBillCtrlr;
import pos.model.Bill;
import pos.model.BillLineItem;
import pos.model.Table;

public class PayBillUI extends BaseUI {

	private PayBillCtrlr payBillCtrlr;
	private List<Table> occupiedTables;

	public PayBillUI(PayBillCtrlr payBillCtrlr) {
		super();
		this.payBillCtrlr = payBillCtrlr;
	}

	public void setOccupiedTables(List<Table> occupiedTables) {
		this.occupiedTables = occupiedTables;
	}

	@Override
	protected boolean doDisplayUI() {
		System.out.println("------------------------------");
		System.out.println(center("Pay Bill", 30));
		System.out.println("------------------------------");

		if (occupiedTables.size() == 0) {
			displayError("SORRY - No table is occupied - Can't pay bill");
			return false;
		}

		TableSelectionUI tableSelectionUI = new TableSelectionUI();
		Table table = tableSelectionUI.selectTable(occupiedTables);
		try {
			payBillCtrlr.payBill(table);
		} catch (Exception e) {
			displayError(e.getMessage());
		}
		return false;
	}

	public void displayBills(List<Bill> bills) {
		System.out.println(center("------------------", 60));

		System.out.println(center("Past Collections", 60));

		System.out.println(center("------------------", 60));

		String indexTitle = center("No.", 5);
		
		String dateTitle = center("Date", 20);

		String waiterTitle = center("Waiter", 20);

		String tableNoTitle = center("Table", 7);

		String priceTitle = center("Amount", 7);
		
		System.out
		.println("----------------------------------------------------------------");

		System.out.println(indexTitle + dateTitle + waiterTitle + tableNoTitle + priceTitle);
		

System.out
		.println("----------------------------------------------------------------");

		int runIndex = 1;
		for (Bill bill : bills) {
			String line = center(runIndex + ".", 5);
			line += center(bill.getDate().toString(), 20);
			line += center(bill.getWaiter(), 20);
			line +=  center(String.valueOf(bill.getTableNo()), 7);
			line += formatNumber(bill.getTotalPrice(), 7);

			System.out.println(line);

			runIndex++;
		}
	}
	
	public void printBill(Bill bill) {

		System.out.println(center("------------------", 60));

		System.out.println(center("Bill", 60));

		System.out.println(center("------------------", 60));

		String indexTitle = center("No.", 5);

		String itemTitle = center("Food", 20);

		String quantityTitle = center("Qty", 7);

		String priceTitle = center("Price", 7);

		String amountTitle = center("Amount", 7);

		String taxTitle = center("Tax ", 7);

		System.out.println("Table No : " + bill.getTableNo());

		System.out.println("No of Guests : " + bill.getNoOfGuests());

		System.out.println("Waiter Name : " + bill.getWaiter());

		System.out
				.println("------------------------------------------------------------");

		System.out.println(indexTitle + itemTitle + quantityTitle + priceTitle
				+ amountTitle + taxTitle);

		System.out
				.println("------------------------------------------------------------");

		int runIndex = 1;

		for (BillLineItem lineItem : bill.getLineItems()) {

			String indexField = center(runIndex + ".", 5);

			System.out.println(indexField + generateLineItemString(lineItem));

			runIndex++;

		}

		System.out
				.println("------------------------------------------------------------");

		String totalString = center("Base: ", 11);
		totalString += formatNumber(bill.getBasePrice(), 7);

		totalString += center("Tax: ", 7);
		totalString += formatNumber(bill.getTax(), 7);

		totalString += center("Total: ", 10);
		totalString += formatNumber(bill.getTotalPrice(), 7);

		System.out.println(totalString);

	}

	private String generateLineItemString(BillLineItem lineItem) {

		String bliString = "";
		bliString += center(lineItem.getFoodName(), 20);
		bliString += center(String.valueOf(lineItem.getQuantity()), 7);
		bliString += formatNumber(lineItem.getUnitPrice(), 7);
		bliString += formatNumber(lineItem.getBasePrice(), 7);
		bliString += formatNumber(lineItem.getTax(), 7);
		return bliString;

	}

	public void displaySuccess() {
		System.out.println("\n**** Bill paid successfully! ****");

	}

}
