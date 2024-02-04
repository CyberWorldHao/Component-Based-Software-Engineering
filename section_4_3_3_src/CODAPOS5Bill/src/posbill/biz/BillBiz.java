package posbill.biz;

import java.util.ArrayList;
import java.util.List;

import pos.model.Bill;
import pos.model.BillLineItem;
import pos.model.Food;
import pos.model.Order;
import pos.model.OrderItem;
import pos.model.Table;
import posbill.persistence.BillDAO;
import posbill.persistence.db4o.DAOFactory;
import codabook.componentmodel.ComponentInterface;

public class BillBiz implements ComponentInterface, IBillBiz{
	
	
	
	private BillDAO billDAO = DAOFactory.getBillDAO();

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

		Bill bill = new Bill(billLineItems, tableNo, noOfGuests, waiter,
				basePrice, tax, totalPrice);

		billDAO.create(bill);
		table.billPaid();
		
		return bill;
	}
	
	@Override
	public List<Bill> getAllBills() {
		return billDAO.findAllBills();
	}

}
