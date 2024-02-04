package posbill.persistence.db4o;

import java.util.List;

import pos.model.Bill;
import posbill.persistence.BillDAO;

import com.db4o.ObjectContainer;

public class BillDb4oDAO extends BaseDb4oDAO implements BillDAO {

	protected BillDb4oDAO(ObjectContainer db) {
		super(db);
	}

	@Override
	public List<Bill> findAllBills() {
		return db.query(Bill.class);
	}

}
