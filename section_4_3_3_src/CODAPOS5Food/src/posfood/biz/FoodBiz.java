package posfood.biz;

import java.util.List;

import pos.model.Food;
import pos.model.FoodCategory;
import posfood.persistence.FoodDAO;
import posfood.persistence.db4o.DAOFactory;
import codabook.componentmodel.ComponentInterface;

public class FoodBiz implements ComponentInterface, IFoodBiz{

		private FoodDAO foodDAO = DAOFactory.getFoodDAO();

	@Override
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

	@Override
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

	@Override
	public void deleteFood(Food food) throws Exception {

		if (food == null) {
			throw new Exception("Food does not exist");
		}

		foodDAO.delete(food);
	}

	@Override
	public List<Food> findAllFoods() {
		return foodDAO.findAllFoods();
	}

	@Override
	public List<Food> findFoodsByCategory(FoodCategory foodCategory) {
		return foodDAO.findFoodsByCategory(foodCategory);
	}

	@Override
	public FoodCategory[] getFoodCategories() {
		return FoodCategory.values();
	}
}
