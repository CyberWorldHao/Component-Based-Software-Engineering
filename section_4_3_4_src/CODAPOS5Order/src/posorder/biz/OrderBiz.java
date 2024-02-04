package posorder.biz;

import java.util.List;

import pos.model.Food;
import pos.model.Order;
import pos.model.OrderItem;
import pos.model.Table;
import codabook.componentmodel.ComponentInterface;

public class OrderBiz implements ComponentInterface, IOrderBiz {

	
	
	@Override
	public List<OrderItem> getOrderItems(Table table) throws Exception {

		if (table == null) {
			throw new Exception("Invalid Table");
		}

		if (!table.isOccupied()) {
			throw new Exception("Table is not occupied");
		}

		if (table.getOrder() == null) {
			throw new Exception("Table does not have active order");
		}

		return table.getOrder().getOrderedItems();
	}

	@Override
	public void placeOrder(Table table, Food food, int quantity)
			throws Exception {

		if (table == null) {
			throw new Exception("Invalid Table");
		}

		if (!table.isOccupied()) {
			throw new Exception("Table is not occupied");
		}

		if (table.getOrder() == null) {
			throw new Exception("Table does not have active order");
		}

		Order order = table.getOrder();
		OrderItem orderItem = new OrderItem(food, quantity);
		order.addOrderItem(orderItem);
	}

	@Override
	public void modifyOrderItem(Table table, OrderItem orderItem,
			int newQuantity) throws Exception {

		if (table == null) {
			throw new Exception("Invalid Table");
		}

		if (!table.isOccupied()) {
			throw new Exception("Table is not occupied");
		}

		if (table.getOrder() == null) {
			throw new Exception("Table does not have active order");
		}

		Order order = table.getOrder();
		if (!order.getOrderedItems().contains(orderItem)) {
			throw new Exception("Order item not found");
		}

		orderItem.setQuantity(newQuantity);
	}

	@Override
	public void cancelOrderItem(Table table, OrderItem orderItem)
			throws Exception {

		if (table == null) {
			throw new Exception("Invalid Table");
		}

		if (!table.isOccupied()) {
			throw new Exception("Table is not occupied");
		}

		if (table.getOrder() == null) {
			throw new Exception("Table does not have active order");
		}

		Order order = table.getOrder();
		if (!order.getOrderedItems().contains(orderItem)) {
			throw new Exception("Order item not found");
		}

		order.removeOrderItem(orderItem);

	}

}
