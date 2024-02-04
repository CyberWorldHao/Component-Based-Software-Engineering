package posorderui.controllers;

import pos.model.Food;
import pos.model.FoodCategory;
import pos.model.OrderItem;
import pos.model.Table;

public interface IOrderCtrlr {

	public abstract void invokeOrders();

	public abstract void tableSelected(Table table) throws Exception;

	public abstract void showOrderItemsInvoked(Table table) throws Exception;

	public abstract void placeOrderInvoked(Table table);

	public abstract void placeOrder(Table table, Food food, int quantity)
			throws Exception;

	public abstract void modifyOrderInvoked(Table table) throws Exception;

	public abstract void modifyOrderItem(Table table, OrderItem orderItem,
			int newQuantity) throws Exception;

	public abstract void cancelOrderInvoked(Table table) throws Exception;

	public abstract void cancelOrder(Table table, OrderItem orderItem)
			throws Exception;

	public abstract void foodCategorySelected(FoodCategory category);

}