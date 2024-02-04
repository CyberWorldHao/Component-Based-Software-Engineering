package codabook.virtualstore;

import java.util.HashMap;
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
public class ShoppingCart {

	private Map<Product, Integer> shoppedProducts = new HashMap<Product, Integer>();

	public void addItem(Product product, int quantity) {
		if (shoppedProducts.containsKey(product)) {
			quantity += shoppedProducts.get(product);
		}
		shoppedProducts.put(product, quantity);
	}
	
	public Map<Product, Integer> getShoppedProducts() {
		return shoppedProducts;
	}
	
	public void removeItem(Product product, int quantity) {
		if (!shoppedProducts.containsKey(product)) return;
		int oldQuantity = shoppedProducts.get(product);
		int newQuantity = oldQuantity - quantity;
		if (newQuantity > 0)
			shoppedProducts.put(product, newQuantity);
		else
			shoppedProducts.remove(product);
	}

	public void empty() {
		shoppedProducts.clear();
	}
	
	public double getPrice() {
		double totalPrice = 0;
		for (Product product : shoppedProducts.keySet()) {
			double unitPrice = product.getPrice();
			int quantity = shoppedProducts.get(product);
			double subTotal = unitPrice * quantity;
			totalPrice += subTotal;
		}
		return totalPrice;
	}

}
