package posfood.persistence.db4o;

import posfood.persistence.FoodDAO;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;

public class DAOFactory {
	
	static {
		EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
		db = Db4oEmbedded.openFile(config, "posfood.data");

	}
	
	private static ObjectContainer db;
	private static FoodDAO foodDAO = new FoodDb4oDAO(db);
	
	public static FoodDAO getFoodDAO() {
		return foodDAO;
	}

}
