package pos.persistence.db4o;

import pos.persistence.BillDAO;
import pos.persistence.FoodDAO;
import pos.persistence.TableConfigDAO;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;

public class DAOFactory {
	
	static {
		EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
		db = Db4oEmbedded.openFile(config, "pos.data");

	}
	
	private static ObjectContainer db;
	private static FoodDAO foodDAO = new FoodDb4oDAO(db);
	private static TableConfigDAO tableConfigDAO = new TableConfigDb4oDAO(db);
	private static BillDAO billDAO = new BillDb4oDAO(db);
	
	public static FoodDAO getFoodDAO() {
		return foodDAO;
	}

	public static TableConfigDAO getTableConfigDAO() {
		return tableConfigDAO;
	}

	public static BillDAO getBillDAO() {
		return billDAO;
	}
}
