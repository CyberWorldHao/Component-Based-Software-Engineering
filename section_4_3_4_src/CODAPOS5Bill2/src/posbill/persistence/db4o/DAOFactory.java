package posbill.persistence.db4o;

import posbill.persistence.BillDAO;
import posbill.persistence.GratuityDAO;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;

public class DAOFactory {
	
	static {
		EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
		db = Db4oEmbedded.openFile(config, "posbill.data");

	}
	
	private static ObjectContainer db;
	private static BillDAO billDAO = new BillDb4oDAO(db);
	private static GratuityDAO gratuityDAO = new GratuityDb4oDAO(db);
	
	public static BillDAO getBillDAO() {
		return billDAO;
	}
	
	public static GratuityDAO getGratuityDAO() {
		return gratuityDAO;
	}
}
