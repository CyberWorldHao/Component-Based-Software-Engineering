package pos.model;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private List<OrderItem> orderedItems = new ArrayList<OrderItem>();

	public List<OrderItem> getOrderedItems() {
		return orderedItems;
	}

	public void addOrderItem(OrderItem orderItem) {
		this.orderedItems.add(orderItem);
	}

	public void removeOrderItem(OrderItem orderItem) {
		this.orderedItems.remove(orderItem);
	}
}
