package posorderui.controllers;

import java.util.List;

import pos.model.Food;
import pos.model.FoodCategory;
import pos.model.OrderItem;
import pos.model.Table;
import posfood.biz.IFoodBiz;
import posorder.biz.IOrderBiz;
import posorderui.ui.OrderUI;
import postable.biz.ITableBiz;
import codabook.componentmodel.ComponentInterface;
import codabook.componentmodel.ComponentRegistry;

public class OrderCtrlr implements ComponentInterface, IOrderCtrlr {

	private OrderUI orderUI;
	private ITableBiz tableBiz;
	private IFoodBiz foodBiz;
	private IOrderBiz orderBiz;
	
	public void bindBizServices()
	{
		if(this.tableBiz==null)
		this.tableBiz=(ITableBiz)ComponentRegistry.fetchComponent(ITableBiz.class);
		
		if(this.foodBiz==null)
		this.foodBiz=(IFoodBiz)ComponentRegistry.fetchComponent(IFoodBiz.class);
		
		if(this.orderBiz==null)
		this.orderBiz=(IOrderBiz)ComponentRegistry.fetchComponent(IOrderBiz.class);
		
	}
	
	@Override
	public void invokeOrders() {
		bindBizServices();
		orderUI = new OrderUI(this);
		List<Table> occupiedTables = tableBiz.getOccupiedTables();
		orderUI.setOccupiedTables(occupiedTables);
		orderUI.displayUI();
	}

	@Override
	public void tableSelected(Table table) throws Exception {
		bindBizServices();
		tableBiz.canTableTakeOrders(table);
	}

	@Override
	public void showOrderItemsInvoked(Table table) throws Exception {
		bindBizServices();
		List<OrderItem> orderItems = orderBiz.getOrderItems(table);
		orderUI.displayOrderItems(orderItems);
	}

	@Override
	public void placeOrderInvoked(Table table) {
		bindBizServices();
		FoodCategory[] categories = foodBiz.getFoodCategories();
		orderUI.displayNewOrderScreen();
		orderUI.selectFoodCategory(categories);
	}

	@Override
	public void placeOrder(Table table, Food food, int quantity)
			throws Exception {
		bindBizServices();
		orderBiz.placeOrder(table, food, quantity);
		orderUI.displayPlaceOrderSuccess();
	}

	@Override
	public void modifyOrderInvoked(Table table) throws Exception {
		bindBizServices();
		List<OrderItem> orderItems = orderBiz.getOrderItems(table);
		orderUI.displayModifyOrderScreen(orderItems);
	}

	@Override
	public void modifyOrderItem(Table table, OrderItem orderItem, int newQuantity) throws Exception {
		bindBizServices();
		orderBiz.modifyOrderItem(table, orderItem, newQuantity);
		orderUI.displayModifyOrderSuccess();
	}

	@Override
	public void cancelOrderInvoked(Table table) throws Exception {
		bindBizServices();
		List<OrderItem> orderedItems = orderBiz.getOrderItems(table);
		orderUI.displayCancelOrderScreen(orderedItems);
	}

	@Override
	public void cancelOrder(Table table, OrderItem orderItem) throws Exception {
		bindBizServices();
		orderBiz.cancelOrderItem(table, orderItem);
		orderUI.displayCancelOrderSuccess();
	}

	@Override
	public void foodCategorySelected(FoodCategory category) {
		bindBizServices();
		List<Food> foods = foodBiz.findFoodsByCategory(category);
		orderUI.selectFoodAndPlaceOrder(foods);
	}

}
