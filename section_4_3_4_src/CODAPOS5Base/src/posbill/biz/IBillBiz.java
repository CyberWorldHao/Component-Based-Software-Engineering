package posbill.biz;

import java.util.List;

import pos.model.Bill;
import pos.model.Gratuity;
import pos.model.Table;

public interface IBillBiz {

	public abstract Bill payBill(Table table) throws Exception;

	public abstract List<Bill> getAllBills();

	public abstract Gratuity getGratuityForBill(Bill bill);

}