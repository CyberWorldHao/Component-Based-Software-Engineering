package pos.biz;

import java.util.List;

import pos.model.Food;
import pos.model.FoodCategory;
import pos.persistence.FoodDAO;
import pos.persistence.db4o.DAOFactory;

public class FoodBiz {

	private static FoodBiz instance = new FoodBiz();
	
	private FoodBiz() {}
	
	public static FoodBiz getInstance() {
		return instance;
	}
	
	private FoodDAO foodDAO = DAOFactory.getFoodDAO();

	public void createNewFood(String name, double price, double taxRate,
			FoodCategory category) throws Exception {

		if (name == null || category == null) {
			throw new Exception("Invalid parameters for create food");
		}

		if (foodDAO.findFood(name) != null) {
			throw new Exception("Food with that name already exists");
		}

		Food food = new Food(name, price, taxRate, category);
		foodDAO.create(food);

	}

	public void modifyFood(String oldName, Food modifiedFood) throws Exception {

		String modifiedName = modifiedFood.getName();

		// If the modified name is new, check if another food with that name
		// exists
		if (!modifiedName.equalsIgnoreCase(oldName)) {
			if (foodDAO.findFood(modifiedName) != null)
				throw new Exception(
						"Food with the proposed name already exists");
		}

		foodDAO.update(modifiedFood);
	}

	public void deleteFood(Food food) throws Exception {

		if (food == null) {
			throw new Exception("Food does not exist");
		}

		foodDAO.delete(food);
	}

	public List<Food> findAllFoods() {
		return foodDAO.findAllFoods();
	}

	public List<Food> findFoodsByCategory(FoodCategory foodCategory) {
		return foodDAO.findFoodsByCategory(foodCategory);
	}

	public FoodCategory[] getFoodCategories() {
		return FoodCategory.values();
	}
}
