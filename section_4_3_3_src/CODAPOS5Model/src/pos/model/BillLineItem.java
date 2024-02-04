package pos.model;

public class BillLineItem {

	private String foodName;
	private double unitPrice;
	private double taxRate;
	private int quantity;
	private double basePrice;
	private double tax;
	private double price;
	
	public BillLineItem(String foodName, double unitPrice, double taxRate, int quantity) {
		super();
		this.foodName = foodName;
		this.unitPrice = unitPrice;
		this.taxRate = taxRate;
		this.quantity = quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getFoodName() {
		return foodName;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public double getTaxRate() {
		return taxRate;
	}

	public int getQuantity() {
		return quantity;
	}
		
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}
	
	public double getBasePrice() {
		return basePrice;
	}
	
	public void setTax(double tax) {
		this.tax = tax;
	}
	
	public double getTax() {
		return tax;
	}
}
