package posadmin.controllers;

import java.util.List;

import pos.model.Food;
import pos.model.FoodCategory;
import posadmin.ui.FoodAdminUI;
import posfood.biz.IFoodBiz;
import codabook.componentmodel.ComponentRegistry;


public class FoodAdminCtrlr {

	private FoodAdminUI foodAdminUI;
	private IFoodBiz foodBiz;

	public void bindBizServices()
	{
		if(this.foodBiz==null)
		this.foodBiz=(IFoodBiz)ComponentRegistry.fetchComponent(IFoodBiz.class);
	}
	
	public void invokeFoodAdmin() {
		bindBizServices();
		foodAdminUI = new FoodAdminUI(this);
		foodAdminUI.displayUI();
	}

	public void showAllInvoked() {
		bindBizServices();
		List<Food> allFoods = foodBiz.findAllFoods();
		foodAdminUI.displayFoods(allFoods);
	}

	public void createNewInvoked() {
		bindBizServices();
		foodAdminUI.displayCreateScreen();
	}

	public void createNewFood(String foodName, double price, double taxRate,
			FoodCategory category) throws Exception {
		bindBizServices();
		foodBiz.createNewFood(foodName, price, taxRate, category);
		foodAdminUI.displayCreateSuccess();
	}

	public void editInvoked() {
		bindBizServices();
		List<Food> foods = foodBiz.findAllFoods();
		foodAdminUI.displaySelectFoodToEditScreen(foods);
	}

	public void foodSelectedForEdit(Food food) throws Exception {
		bindBizServices();
		String oldName = food.getName();

		Food modifiedFood = foodAdminUI.editFood(food);
		foodBiz.modifyFood(oldName, modifiedFood);

		foodAdminUI.displayEditSuccess();
	}

	public void deleteInvoked() {
		bindBizServices();
		List<Food> foods = foodBiz.findAllFoods();
		foodAdminUI.displaySelectFoodToDeleteScreen(foods);
	}

	public void foodSelectedForDelete(Food selectedFood) throws Exception {
		bindBizServices();
		foodBiz.deleteFood(selectedFood);
		foodAdminUI.displayDeleteSuccess();

	}

}
