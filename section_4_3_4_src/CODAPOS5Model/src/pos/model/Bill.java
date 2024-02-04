package pos.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Bill {

	private List<BillLineItem> lineItems = new ArrayList<BillLineItem>();
	private int tableNo;
	private int noOfGuests;
	private String waiter;
	private double basePrice;
	private double tax;
	private double totalPrice;
	private Date date;
	
	public Bill(List<BillLineItem> lineItems, int tableNo, int noOfGuests,
			String waiter, double basePrice, double tax, double totalPrice) {
		super();
		this.lineItems = lineItems;
		this.tableNo = tableNo;
		this.noOfGuests = noOfGuests;
		this.waiter = waiter;
		this.totalPrice = totalPrice;
		this.basePrice = basePrice;
		this.tax = tax;
		this.date = new Date();
	}

	public List<BillLineItem> getLineItems() {
		return lineItems;
	}

	public int getTableNo() {
		return tableNo;
	}

	public int getNoOfGuests() {
		return noOfGuests;
	}

	public String getWaiter() {
		return waiter;
	}
	
	public double getBasePrice() {
		return basePrice;
	}
	
	public double getTax() {
		return tax;
	}

	public double getTotalPrice() {
		return totalPrice;
	}
	
	public Date getDate() {
		return date;
	}
}
