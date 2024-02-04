package pos.model;

public class OrderItem {
	
	private Food food;
	private int quantity;
	
	public OrderItem(Food food, int quantity) {
		super();
		this.food = food;
		this.quantity = quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Food getFood() {
		return food;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
}
