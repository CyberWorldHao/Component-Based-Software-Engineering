package pos.model;

public class Table {

	private int tableNo;
	private int noOfGuests;
	private String waiter;
	private Order order;
	private boolean occupied;

	public Table(int tableNo) {
		this.tableNo = tableNo;
	}

	public void occupy(int noOfGuests, String waiter, Order order) {
		this.noOfGuests = noOfGuests;
		this.waiter = waiter;
		this.order = order;
		this.occupied = true;
	}
	
	public void unOccupy() {
		this.noOfGuests = 0;
		this.waiter = null;
		this.order = null;
		this.occupied = false;
	}

	public int getTableNo() {
		return tableNo;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public int getNoOfGuests() {
		return noOfGuests;
	}

	public String getWaiter() {
		return waiter;
	}

	public Order getOrder() {
		return order;
	}
	
	public void billPaid() {
		this.order = null;
	}

}
