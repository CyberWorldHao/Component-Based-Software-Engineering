package posbill.persistence;

import java.util.List;

import pos.model.Bill;

public interface BillDAO extends BaseDAO {
	public List<Bill> findAllBills();
}
