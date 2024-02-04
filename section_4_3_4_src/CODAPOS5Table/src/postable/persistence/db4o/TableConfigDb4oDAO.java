package postable.persistence.db4o;

import pos.model.TableConfig;
import postable.persistence.TableConfigDAO;

import com.db4o.ObjectContainer;

public class TableConfigDb4oDAO extends BaseDb4oDAO implements TableConfigDAO {
	
	protected TableConfigDb4oDAO(ObjectContainer db) {
		super(db);
	}

	@Override
	public TableConfig findTableConfig() {
		if (db.query(TableConfig.class).hasNext())
			return db.query(TableConfig.class).next();
		return null;
	}

}
