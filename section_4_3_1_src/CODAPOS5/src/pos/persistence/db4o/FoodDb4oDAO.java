package pos.persistence.db4o;

import java.util.List;

import pos.model.Food;
import pos.model.FoodCategory;
import pos.persistence.FoodDAO;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class FoodDb4oDAO extends BaseDb4oDAO implements FoodDAO{

	protected FoodDb4oDAO(ObjectContainer db) {
		super(db);
	}

	@Override
	public Food findFood(String foodName) {
		Food protoFood = new Food(foodName, 0, 0, null);
		ObjectSet<Food> foodSet = db.queryByExample(protoFood);
		if (foodSet.hasNext()) return foodSet.next();
		return null;
	}
	
	@Override
	public List<Food> findAllFoods() {
		return db.query(Food.class);
	}
	
	@Override
	public List<Food> findFoodsByCategory(FoodCategory foodCategory) {
		Food protoFood = new Food(null, 0, 0, foodCategory);
		return db.queryByExample(protoFood);
	}
}
