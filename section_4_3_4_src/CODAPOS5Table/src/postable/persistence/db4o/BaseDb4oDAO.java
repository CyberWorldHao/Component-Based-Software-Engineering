package postable.persistence.db4o;

import postable.persistence.BaseDAO;

import com.db4o.ObjectContainer;

public abstract class BaseDb4oDAO implements BaseDAO {

	protected ObjectContainer db;

	protected BaseDb4oDAO(ObjectContainer db) {
		this.db = db;
	}

	@Override
	public void create(Object obj) {
		db.store(obj);
		db.commit();
	}

	@Override
	public void update(Object obj) {
		db.store(obj);
		db.commit();
	}
	
	@Override
	public void delete(Object obj) {
		db.delete(obj);
		db.commit();
	}

}
