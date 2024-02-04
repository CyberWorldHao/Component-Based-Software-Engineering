package posfood.biz;

import java.util.List;

import pos.model.Food;
import pos.model.FoodCategory;

public interface IFoodBiz {

	public abstract void createNewFood(String name, double price,
			double taxRate, FoodCategory category) throws Exception;

	public abstract void modifyFood(String oldName, Food modifiedFood)
			throws Exception;

	public abstract void deleteFood(Food food) throws Exception;

	public abstract List<Food> findAllFoods();

	public abstract List<Food> findFoodsByCategory(FoodCategory foodCategory);

	public abstract FoodCategory[] getFoodCategories();

}