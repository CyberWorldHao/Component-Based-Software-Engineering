package codabook.virtualstore;

import java.util.ArrayList;
import java.util.HashMap;
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
public class Inventory {

	Map<Product, Integer> products = new HashMap<Product, Integer>();
	
	public void addProduct(Product product, int stock) {
		products.put(product, stock);
	}
	
	public void reduceStock(Product product, int quantity) {
		int oldStock = products.get(product);
		int newStock = oldStock - quantity;
		products.put(product, newStock);
	}
	
	public void increaseStock(Product product, int quantity) {
		int oldStock = products.get(product);
		int newStock = oldStock + quantity;
		products.put(product, newStock);
	}
	
	public List<Product> getAvailableProducts() {
		
		List<Product> availableProducts = new ArrayList<Product>();
		for (Product product : products.keySet()) {
			if (products.get(product) > 0)
				availableProducts.add(product);
		}
		
		return availableProducts;
	}
	
	public int getStock(Product product) {
		return products.get(product);
	}
	
	public Map<Product, Integer> getAllProductsStock() {
		return products;
	}

	
}
