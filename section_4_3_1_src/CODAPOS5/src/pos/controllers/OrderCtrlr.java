package pos.controllers;

import java.util.List;

import pos.biz.FoodBiz;
import pos.biz.OrderBiz;
import pos.biz.TableBiz;
import pos.model.Food;
import pos.model.FoodCategory;
import pos.model.OrderItem;
import pos.model.Table;
import pos.ui.OrderUI;

public class OrderCtrlr {

	private OrderUI orderUI;
	private TableBiz tableBiz = TableBiz.getInstance();
	private FoodBiz foodBiz = FoodBiz.getInstance();
	private OrderBiz orderBiz = OrderBiz.getInstance();
	
	public void invokeOrders() {
		orderUI = new OrderUI(this);
		List<Table> occupiedTables = tableBiz.getOccupiedTables();
		orderUI.setOccupiedTables(occupiedTables);
		orderUI.displayUI();
	}

	public void tableSelected(Table table) throws Exception {
		tableBiz.canTableTakeOrders(table);
	}

	public void showOrderItemsInvoked(Table table) throws Exception {
		List<OrderItem> orderItems = orderBiz.getOrderItems(table);
		orderUI.displayOrderItems(orderItems);
	}

	public void placeOrderInvoked(Table table) {
		FoodCategory[] categories = foodBiz.getFoodCategories();
		orderUI.displayNewOrderScreen();
		orderUI.selectFoodCategory(categories);
	}

	public void placeOrder(Table table, Food food, int quantity)
			throws Exception {
		orderBiz.placeOrder(table, food, quantity);
		orderUI.displayPlaceOrderSuccess();
	}

	public void modifyOrderInvoked(Table table) throws Exception {
		List<OrderItem> orderItems = orderBiz.getOrderItems(table);
		orderUI.displayModifyOrderScreen(orderItems);
	}

	public void modifyOrderItem(Table table, OrderItem orderItem, int newQuantity) throws Exception {
		orderBiz.modifyOrderItem(table, orderItem, newQuantity);
		orderUI.displayModifyOrderSuccess();
	}

	public void cancelOrderInvoked(Table table) throws Exception {
		List<OrderItem> orderedItems = orderBiz.getOrderItems(table);
		orderUI.displayCancelOrderScreen(orderedItems);
	}

	public void cancelOrder(Table table, OrderItem orderItem) throws Exception {
		orderBiz.cancelOrderItem(table, orderItem);
		orderUI.displayCancelOrderSuccess();
	}

	public void foodCategorySelected(FoodCategory category) {
		List<Food> foods = foodBiz.findFoodsByCategory(category);
		orderUI.selectFoodAndPlaceOrder(foods);
	}

}
