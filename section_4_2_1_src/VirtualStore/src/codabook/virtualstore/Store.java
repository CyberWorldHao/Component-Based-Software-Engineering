package codabook.virtualstore;

import java.util.List;
import java.util.Map;
/*************************************************************************************************
*
* COMPANION CODE FOR THE BOOK “Component Oriented Development & Assembly – CODA Using Java”
* 
* @author – Piram Manickam, Sangeetha S, Subrahmanya S V
* @see -  http://www.codabook.com
* 
* <br><br><b>CODE CONTRIBUTORS</b> – <p>- Vishal Verma, Shikhar Johari, Soumya Bardhan, Rohit Jain,
* Karthika Nair, Vibhuti Pithwa, Vaasavi Lakshmi</p>

**************************************************************************************************/
public class Store {
	Inventory inventory = new Inventory();
	ShoppingCart shoppingCart = new ShoppingCart();
	UI ui;

	public Store(UI ui) {
		this.ui = ui;
		init();
	}

	public void init() {
		Product iPadProduct = new Product("New IPad", 400.00);
		inventory.addProduct(iPadProduct, 100);

		Product iPhoneProduct = new Product("IPhone 5", 500.00);
		inventory.addProduct(iPhoneProduct, 200);

		Product galaxyPadProduct = new Product("Galaxy Tab 2", 300.00);
		inventory.addProduct(galaxyPadProduct, 300);
	}

	public List<Product> getAvailableProducts() {
		return inventory.getAvailableProducts();
	}

	public Map<Product, Integer> getShoppedProducts() {
		return shoppingCart.getShoppedProducts();
	}
	
	public Map<Product, Integer> getAllProductsStock() {
		return inventory.getAllProductsStock();
	}

	public void addItemToCart(Product product, int quantity) {

		if (product == null)
			return;

		if (inventory.getStock(product) >= quantity) {
			shoppingCart.addItem(product, quantity);
			inventory.reduceStock(product, quantity);
			ui.purchaseSuccess(product, quantity);
		} else {
			ui.purchaseFail(product, inventory.getStock(product));
		}
	}

	public void removeItemsFromCart(Product product, int quantity) {

		if (product == null)
			return;
		if (quantity == 0)
			return;
		inventory.increaseStock(product, quantity);
		shoppingCart.removeItem(product, quantity);
	}

	public double getShoppingCartPrice() {
		return shoppingCart.getPrice();
	}

	public void checkOut() {
		shoppingCart.empty();
	}

}
