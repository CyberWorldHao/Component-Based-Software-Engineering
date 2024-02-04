package posbill.biz;

import java.util.ArrayList;
import java.util.List;

import codabook.componentmodel.ComponentInterface;

import pos.model.Bill;
import pos.model.BillLineItem;
import pos.model.Gratuity;
import pos.model.Food;
import pos.model.Order;
import pos.model.OrderItem;
import pos.model.Table;
import posbill.persistence.BillDAO;
import posbill.persistence.GratuityDAO;
import posbill.persistence.db4o.DAOFactory;

public class BillBiz implements ComponentInterface, IBillBiz{

	
	private BillDAO billDAO = DAOFactory.getBillDAO();
	private GratuityDAO gratuityDAO = DAOFactory.getGratuityDAO();

	/* (non-Javadoc)
	 * @see posbill.biz.IBillBiz#payBill(pos.model.Table)
	 */
	@Override
	public Bill payBill(Table table) throws Exception {

		int tableNo = table.getTableNo();
		int noOfGuests = table.getNoOfGuests();
		String waiter = table.getWaiter();
		Order order = table.getOrder();
		double basePrice = 0;
		double tax = 0;
		double totalPrice = 0;
		List<BillLineItem> billLineItems = new ArrayList<BillLineItem>();

		//Create a bill line item for each order item and calculate its price components
		for (OrderItem orderItem : order.getOrderedItems()) {
			Food food = orderItem.getFood();
			int quantity = orderItem.getQuantity();
			BillLineItem billLineItem = new BillLineItem(food.getName(),
					food.getPrice(), food.getTaxRate(), quantity);

			//Calculate price for individual bill line item
			double itemBasePrice = billLineItem.getUnitPrice()
					* billLineItem.getQuantity();
			double itemTax = itemBasePrice * billLineItem.getTaxRate() / 100;
			double itemPrice = itemBasePrice + itemTax;

			billLineItem.setBasePrice(itemBasePrice);
			billLineItem.setTax(itemTax);
			billLineItem.setPrice(itemPrice);

			//Calculate price components for whole bill
			basePrice += itemBasePrice;
			tax += itemTax;
			totalPrice += itemPrice;

			billLineItems.add(billLineItem);
		}

		//Additional logic to calculate gratuity
		double gratuityAmount = 0;

		if (noOfGuests >= 8) {
			gratuityAmount = basePrice * 0.15;
			totalPrice += gratuityAmount;
		}

		Bill bill = new Bill(billLineItems, tableNo, noOfGuests, waiter,
				basePrice, tax, totalPrice);
		billDAO.create(bill);
		table.billPaid();

		if (noOfGuests >= 8) {
			Gratuity gratuityObj = new Gratuity(bill, gratuityAmount);
			gratuityDAO.create(gratuityObj);
		}

		return bill;
	}

	/* (non-Javadoc)
	 * @see posbill.biz.IBillBiz#getAllBills()
	 */
	@Override
	public List<Bill> getAllBills() {
		return billDAO.findAllBills();
	}
	
	/* (non-Javadoc)
	 * @see posbill.biz.IBillBiz#getGratuityForBill(pos.model.Bill)
	 */
	@Override
	public Gratuity getGratuityForBill(Bill bill) {
		return gratuityDAO.findGratuity(bill);
	}

}
