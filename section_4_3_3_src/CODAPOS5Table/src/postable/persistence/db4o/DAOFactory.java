package postable.persistence.db4o;

import postable.persistence.TableConfigDAO;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;

public class DAOFactory {
	
	static {
		EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
		db = Db4oEmbedded.openFile(config, "postable.data");

	}
	
	private static ObjectContainer db;
	private static TableConfigDAO tableConfigDAO = new TableConfigDb4oDAO(db);



	public static TableConfigDAO getTableConfigDAO() {
		return tableConfigDAO;
	}

}
