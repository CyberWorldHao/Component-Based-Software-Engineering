package posorder.biz;

import java.util.List;

import pos.model.Food;
import pos.model.OrderItem;
import pos.model.Table;

public interface IOrderBiz {

	public abstract List<OrderItem> getOrderItems(Table table) throws Exception;

	public abstract void placeOrder(Table table, Food food, int quantity)
			throws Exception;

	public abstract void modifyOrderItem(Table table, OrderItem orderItem,
			int newQuantity) throws Exception;

	public abstract void cancelOrderItem(Table table, OrderItem orderItem)
			throws Exception;

}