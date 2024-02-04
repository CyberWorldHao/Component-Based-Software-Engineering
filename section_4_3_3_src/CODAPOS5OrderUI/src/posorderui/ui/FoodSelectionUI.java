package posorderui.ui;

import java.util.List;

import pos.model.Food;
import pos.model.FoodCategory;

public class FoodSelectionUI extends BaseUI {

	public FoodCategory selectFoodCategory(FoodCategory[] foodCategories) {

		System.out.println("----------------------");
		System.out.println("Select a Food Category");
		System.out.println("----------------------");

		int runIndex = 1;
		for (FoodCategory category : foodCategories) {
			System.out.println(runIndex++ + ". " + category);
		}

		System.out.print(">>");
		int selection = scanInt();

		if (selection < 1 || selection > runIndex - 1)
			return null;

		return foodCategories[selection - 1];

	}
	
	public Food selectFood(List<Food> foods) {
		
		System.out.println("----------------------");
		System.out.println("    Select a Food   ");
		System.out.println("----------------------");
		
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
		System.out.println("Select Food Item");
		System.out.println(">>");
		int choice = scanInt();

		if (choice < 1 || choice > runIndex - 1)
			return null;

		return foods.get(choice - 1);
	}
	
	private String foodToString(Food food) {

		String string = center(food.getName(), 20);
		string += formatNumber(food.getPrice(), 10);
		string += formatNumber(food.getTaxRate(), 15);
		string += center(food.getCategory().toString(), 15);

		return string;
	}

	@Override
	protected boolean doDisplayUI() {
		return false;
	}
}
