package posbill.persistence.db4o;

import pos.model.Bill;
import pos.model.Gratuity;
import posbill.persistence.GratuityDAO;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class GratuityDb4oDAO extends BaseDb4oDAO implements GratuityDAO {

	protected GratuityDb4oDAO(ObjectContainer db) {
		super(db);
	}

	@Override
	public Gratuity findGratuity(Bill bill) {
		Gratuity protoGratuity = new Gratuity(bill, 0);
		ObjectSet<Gratuity> gratuities = db.queryByExample(protoGratuity);
		if (gratuities.hasNext()) return gratuities.next();
		return null;
	}



}
