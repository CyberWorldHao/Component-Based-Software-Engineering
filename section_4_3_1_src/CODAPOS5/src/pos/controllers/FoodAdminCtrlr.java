package pos.controllers;

import java.util.List;

import pos.biz.FoodBiz;
import pos.model.Food;
import pos.model.FoodCategory;
import pos.ui.FoodAdminUI;

public class FoodAdminCtrlr {

	private FoodAdminUI foodAdminUI;
	private FoodBiz foodBiz = FoodBiz.getInstance();

	public void invokeFoodAdmin() {
		foodAdminUI = new FoodAdminUI(this);
		foodAdminUI.displayUI();
	}

	public void showAllInvoked() {
		List<Food> allFoods = foodBiz.findAllFoods();
		foodAdminUI.displayFoods(allFoods);
	}

	public void createNewInvoked() {
		foodAdminUI.displayCreateScreen();
	}

	public void createNewFood(String foodName, double price, double taxRate,
			FoodCategory category) throws Exception {
		foodBiz.createNewFood(foodName, price, taxRate, category);
		foodAdminUI.displayCreateSuccess();
	}

	public void editInvoked() {
		List<Food> foods = foodBiz.findAllFoods();
		foodAdminUI.displaySelectFoodToEditScreen(foods);
	}

	public void foodSelectedForEdit(Food food) throws Exception {
		String oldName = food.getName();

		Food modifiedFood = foodAdminUI.editFood(food);
		foodBiz.modifyFood(oldName, modifiedFood);

		foodAdminUI.displayEditSuccess();
	}

	public void deleteInvoked() {
		List<Food> foods = foodBiz.findAllFoods();
		foodAdminUI.displaySelectFoodToDeleteScreen(foods);
	}

	public void foodSelectedForDelete(Food selectedFood) throws Exception {
		
		foodBiz.deleteFood(selectedFood);
		foodAdminUI.displayDeleteSuccess();

	}

}
