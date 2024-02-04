package posfood.persistence;

import java.util.List;

import pos.model.Food;
import pos.model.FoodCategory;

public interface FoodDAO extends BaseDAO{
	public Food findFood(String foodName) ;
	public List<Food> findAllFoods();
	public List<Food> findFoodsByCategory(FoodCategory foodCategory);
}
