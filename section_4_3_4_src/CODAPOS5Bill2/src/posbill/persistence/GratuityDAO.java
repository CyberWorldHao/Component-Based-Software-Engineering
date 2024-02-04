package posbill.persistence;

import pos.model.Bill;
import pos.model.Gratuity;

public interface GratuityDAO extends BaseDAO {
	public Gratuity findGratuity(Bill bill);
}
