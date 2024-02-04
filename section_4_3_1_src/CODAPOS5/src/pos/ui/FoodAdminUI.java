package pos.ui;

import java.util.List;

import pos.controllers.FoodAdminCtrlr;
import pos.model.Food;
import pos.model.FoodCategory;

public class FoodAdminUI extends BaseUI {

	private FoodAdminCtrlr foodAdminCtrlr;

	public FoodAdminUI(FoodAdminCtrlr foodAdminCtrlr) {
		super();
		this.foodAdminCtrlr = foodAdminCtrlr;
	}

	@Override
	protected boolean doDisplayUI() {

		System.out.println("\n-------------------");
		System.out.println("Food Administration");
		System.out.println("------------------\n");
		System.out.println("Select an operation:\n");

		System.out.println("1. Show existing foods");
		System.out.println("2. Create new food");
		System.out.println("3. Edit existing food");
		System.out.println("4. Delete existing food");
		System.out.println("0. Exit\n");

		System.out.print(">>");
		int selection = scanInt();

		switch (selection) {
		case 1:
			foodAdminCtrlr.showAllInvoked();
			break;

		case 2:
			foodAdminCtrlr.createNewInvoked();
			break;

		case 3:
			foodAdminCtrlr.editInvoked();
			break;

		case 4:
			foodAdminCtrlr.deleteInvoked();
			break;

		default:
			return false;

		}

		return true;
	}

	public void displayFoods(List<Food> foods) {

		System.out.println("CURRENT FOOD CATALOG");
		String indexTitle = center("No.", 5);
		String itemTitle = center("Food Name", 20);
		String priceTitle = center("Price", 10);
		String taxTitle = center("Tax Rate (%)", 15);
		String categoryTitle = center("Category", 15);

		System.out
				.println("\n-------------------------------------------------------------------");
		System.out.println(indexTitle + itemTitle + priceTitle + taxTitle
				+ categoryTitle);
		System.out
				.println("-------------------------------------------------------------------");

		int runIndex = 1;
		for (Food food : foods) {
			String indexField = center(runIndex + ".", 5);
			System.out.println(indexField + foodToString(food));
			runIndex++;
		}
		System.out
				.println("-------------------------------------------------------------------");
	}

	public void displayCreateScreen() {
		System.out.println("\n-------------");
		System.out.println("Create New Food");
		System.out.println("------------\n");

		System.out.println("Name of the food item?");
		System.out.print(">>");
		String name = scanString();
		if (name == null) {
			displayError("Invalid food name");
			return;
		}

		System.out.println("\nPrice of the food item?");
		System.out.print(">>");
		Double price = scanDouble();
		if (price == null) {
			displayError("Invalid Price");
			return;
		}

		System.out.println("\nTax Rate (in % - example 10.50)?");
		System.out.print(">>");
		Double taxRate = scanDouble();
		if (taxRate == null) {
			displayError("Invalid Tax Rate");
			return;
		}

		System.out.println("\nFood belongs to which category?");
		FoodSelectionUI selectFoodCategoryUI = new FoodSelectionUI();
		FoodCategory category = selectFoodCategoryUI
				.selectFoodCategory(FoodCategory.values());
		if (category == null) {
			displayError("Invalid food category");
			return;
		}

		try {
			foodAdminCtrlr.createNewFood(name, price, taxRate, category);
		} catch (Exception e) {
			displayError(e.getMessage());
		}
	}

	public void displayCreateSuccess() {
		System.out.println("\n**** SUCCESS - New food item created successfully ****\n");
	}

	public void displaySelectFoodToEditScreen(List<Food> foods) {
		System.out.println("\n---------");
		System.out.println("Edit Food");
		System.out.println("----------\n");

		displayFoods(foods);

		System.out.println("\nSelect the item no. to edit: (0 to cancel)");
		System.out.print(">>");
		int selection = scanInt();

		if (selection == 0 || selection > foods.size()) {
			displayError("Wrong selection");
			return;
		}

		Food selectedFood = foods.get(selection - 1);
		try {
			foodAdminCtrlr.foodSelectedForEdit(selectedFood);
		} catch (Exception e) {
			displayError(e.getMessage());
		}
	}

	public Food editFood(Food food) {

		System.out.println("\n--------------------");
		System.out.println("Entering Edit Mode");
		System.out.println("---------------------\n");

		System.out.println("Press Enter to retain current value\n");
		System.out.println("Name of the food item? [" + food.getName() + "]");
		System.out.print(">>");
		String name = scanString();
		if (name != null) {
			food.setName(name);
		}

		System.out.println("\nPrice of the food item? [" + food.getPrice()
				+ "]");
		System.out.print(">>");
		Double price = scanDouble();
		if (price != null) {
			food.setPrice(price);
		}

		System.out.println("\nTax Rate (in % - example 10.50)? ["
				+ food.getTaxRate() + "]");
		System.out.print(">>");
		Double taxRate = scanDouble();
		if (taxRate != null) {
			food.setTaxRate(taxRate);
		}

		System.out.println("\nFood category? [" + food.getCategory() + "]");
		FoodSelectionUI selectFoodCategoryUI = new FoodSelectionUI();
		FoodCategory category = selectFoodCategoryUI
				.selectFoodCategory(FoodCategory.values());
		if (category != null) {
			food.setCategory(category);
		}

		return food;
	}

	public void displayEditSuccess() {
		System.out.println("\n**** SUCCESS - Food successfully modified ****\n");
	}

	public void displaySelectFoodToDeleteScreen(List<Food> foods) {
		System.out.println("\n-----------");
		System.out.println("Delete Food");
		System.out.println("------------\n");

		displayFoods(foods);

		System.out.println("\nSelect the item no. to delete: (0 to cancel)");
		System.out.print(">>");
		int selection = scanInt();

		if (selection == 0 || selection > foods.size()) {
			displayError("Wrong selection");
			return;
		}

		Food selectedFood = foods.get(selection - 1);
		try {
			foodAdminCtrlr.foodSelectedForDelete(selectedFood);
		} catch (Exception e) {
			displayError(e.getMessage());
		}
	}

	private String foodToString(Food foodItem) {

		String string = center(foodItem.getName(), 20);
		string += formatNumber(foodItem.getPrice(), 10);
		string += formatNumber(foodItem.getTaxRate(), 15);
		string += center(foodItem.getCategory().toString(), 15);

		return string;
	}

	public void displayDeleteSuccess() {
		System.out.println("\n**** SUCCESS - Food successfully deleted ****\n");
		
	}

}
