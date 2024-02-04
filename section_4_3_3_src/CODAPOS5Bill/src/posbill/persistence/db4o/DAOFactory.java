package posbill.persistence.db4o;

import posbill.persistence.BillDAO;

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
	
	public static BillDAO getBillDAO() {
		return billDAO;
	}
}
