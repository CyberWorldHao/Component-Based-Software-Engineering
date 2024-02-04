package pos.ui;

import java.util.List;

import pos.controllers.OrderCtrlr;
import pos.model.Food;
import pos.model.FoodCategory;
import pos.model.OrderItem;
import pos.model.Table;

public class OrderUI extends BaseUI {

	private Table table;
	private OrderCtrlr orderCtrlr;
	private List<Table> occupiedTables;

	public OrderUI(OrderCtrlr orderCtrlr) {
		this.orderCtrlr = orderCtrlr;
		this.table = null;
	}

	public void setOccupiedTables(List<Table> occupiedTables) {
		this.occupiedTables = occupiedTables;
	}

	@Override
	protected boolean doDisplayUI() {
		try {
			if (table == null) {
				System.out.println("\n----------------------");
				System.out.println("  ORDER MANAGEMENT  ");
				System.out.println("----------------------\n");

				System.out
						.println("Please select a table whose orders are to be managed");
				TableSelectionUI tableSelectionUI = new TableSelectionUI();

				if (occupiedTables.size() == 0) {
					displayError("SORRY - No table is occupied to take order from");
					return false;
				}

				table = tableSelectionUI.selectTable(occupiedTables);

				if (table == null) {
					displayError("Invalid table");
					return false;
				}
			}

			System.out.println("\n---------------------------------------");
			System.out.println("    ORDER MANAGEMENT FOR TABLE "
					+ table.getTableNo());
			System.out.println("---------------------------------------\n");
			System.out.println("Select an operation:\n");
			System.out.println("1. List current orders");
			System.out.println("2. Place new order");
			System.out.println("3. Modify existing order");
			System.out.println("4. Cancel existing order");
			System.out.println("0. Exit\n");

			System.out.print(">>");
			int selection = scanInt();

			switch (selection) {
			case 1:
				orderCtrlr.showOrderItemsInvoked(table);
				break;

			case 2:
				orderCtrlr.placeOrderInvoked(table);
				break;

			case 3:
				orderCtrlr.modifyOrderInvoked(table);
				break;

			case 4:
				orderCtrlr.cancelOrderInvoked(table);
				break;

			default:
				return false;
			}

			return true;
		} catch (Exception e) {
			displayError(e.getMessage());
			return false;
		}
	}

	public void displayOrderItems(List<OrderItem> orderedItems) {

		if (orderedItems.size() == 0) {
			System.out.println("\n**** NO CURRENT ORDERS **** \n");
			return;
		}

		System.out.println("\n-------------------------");
		System.out.println("       CURRENT ORDERS      ");
		System.out.println("-------------------------");

		String noHeader = center("No.", 5);
		String nameHeader = center("Food Name", 20);
		String quantityHeader = center("Quantity", 10);

		System.out.println("------------------------------------------");
		System.out.println(noHeader + nameHeader + quantityHeader);
		System.out.println("------------------------------------------");

		int runIndex = 1;
		for (OrderItem item : orderedItems) {
			System.out.println(center(runIndex + ".", 5)
					+ center(item.getFood().getName(), 20)
					+ center(String.valueOf(item.getQuantity()), 10));
			runIndex++;
		}
		System.out.println("------------------------------------------");

	}

	public void displayNewOrderScreen() {
		System.out.println("\n----------------------");
		System.out.println("      New Order      ");
		System.out.println("----------------------");
	}
	
	public void selectFoodCategory(FoodCategory[] categories) {

		FoodSelectionUI foodSelectionUI = new FoodSelectionUI();
		FoodCategory category = foodSelectionUI.selectFoodCategory(categories);
		orderCtrlr.foodCategorySelected(category);
	}
	
	
	public void selectFoodAndPlaceOrder(List<Food> foods) {
		
		FoodSelectionUI foodSelectionUI = new FoodSelectionUI();
		Food food = foodSelectionUI.selectFood(foods);

		if (food != null) {
			System.out.println("Enter Quantity");
			System.out.println(">>");
			int quantity = scanInt();

			try {
				orderCtrlr.placeOrder(table, food, quantity);
			} catch (Exception e) {
				displayError(e.getMessage());
			}
		}
	}

	public void displayPlaceOrderSuccess() {
		System.out
				.println("\n**** SUCCESS - New order placed successfully ****\n");

	}

	public void displayModifyOrderScreen(List<OrderItem> orderItems) {
		System.out.println("\n------------------------");
		System.out.println("      Modify Order      ");
		System.out.println("------------------------");

		if (orderItems.size() == 0) {
			displayError("SORRY - No existing orders found");
			return;
		}

		displayOrderItems(orderItems);
		System.out.println("Which order item you want to edit?");
		System.out.print(">>");
		int choice = scanInt();
		if (choice < 1 || choice > orderItems.size()) {
			displayError("Invalid item selection");
			return;
		}

		OrderItem orderItem = orderItems.get(choice - 1);

		System.out.println("Food Name: " + orderItem.getFood().getName());
		System.out.println("Quantity: " + orderItem.getQuantity());
		System.out.println("New quantity?");
		System.out.print(">>");
		int newQuantity = scanInt();

		try {
			orderCtrlr.modifyOrderItem(table, orderItem, newQuantity);
		} catch (Exception e) {
			displayError(e.getMessage());
		}
	}

	public void displayModifyOrderSuccess() {
		System.out
				.println("\n**** SUCCESS - Order modified successfully ****\n");
	}

	public void displayCancelOrderScreen(List<OrderItem> orderItems) {
		System.out.println("\n------------------------");
		System.out.println("        Cancel Order      ");
		System.out.println("------------------------");

		if (orderItems.size() == 0) {
			displayError("SORRY - No current orders found");
			return;
		}
		displayOrderItems(orderItems);
		System.out.println("Which order item you want to cancel?");
		System.out.print(">>");
		int choice = scanInt();
		if (choice < 1 || choice > orderItems.size()) {
			displayError("Invalid item selection");
			return;
		}

		OrderItem orderItem = orderItems.get(choice - 1);
		try {
			orderCtrlr.cancelOrder(table, orderItem);
		} catch (Exception e) {
			displayError(e.getMessage());
		}
	}

	public void displayCancelOrderSuccess() {
		System.out
				.println("\n**** SUCCESS - Order canceled successfully ****\n");
	}

}
