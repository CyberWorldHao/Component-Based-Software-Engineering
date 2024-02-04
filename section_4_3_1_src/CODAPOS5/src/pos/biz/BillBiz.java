package pos.biz;

import java.util.ArrayList;
import java.util.List;

import pos.model.Bill;
import pos.model.BillLineItem;
import pos.model.Food;
import pos.model.Order;
import pos.model.OrderItem;
import pos.model.Table;
import pos.persistence.BillDAO;
import pos.persistence.db4o.DAOFactory;

public class BillBiz {
	
	private static BillBiz instace = new BillBiz();
	
	private BillBiz() {}
	
	public static BillBiz getInstace() {
		return instace;
	}
	
	private BillDAO billDAO = DAOFactory.getBillDAO();

	public Bill payBill(Table table) throws Exception {

		int tableNo = table.getTableNo();
		int noOfGuests = table.getNoOfGuests();
		String waiter = table.getWaiter();
		Order order = table.getOrder();
		double basePrice = 0;
		double tax = 0;
		double totalPrice = 0;
		List<BillLineItem> billLineItems = new ArrayList<BillLineItem>();

		for (OrderItem orderItem : order.getOrderedItems()) {
			Food food = orderItem.getFood();
			int quantity = orderItem.getQuantity();
			BillLineItem billLineItem = new BillLineItem(food.getName(),
					food.getPrice(), food.getTaxRate(), quantity);

			double itemBasePrice = billLineItem.getUnitPrice()
					* billLineItem.getQuantity();
			double itemTax = itemBasePrice * billLineItem.getTaxRate() / 100;
			double itemPrice = itemBasePrice + itemTax;

			billLineItem.setBasePrice(itemBasePrice);
			billLineItem.setTax(itemTax);
			billLineItem.setPrice(itemPrice);

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
	
	public List<Bill> getAllBills() {
		return billDAO.findAllBills();
	}

}
