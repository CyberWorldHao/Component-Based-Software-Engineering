package pos.model;

public class Food {

	private String name;
	private double price;
	private double taxRate;
	private FoodCategory category;

	public FoodCategory getCategory() {
		return category;
	}

	public void setCategory(FoodCategory category) {
		this.category = category;
	}

	public Food(String name, double price, double taxRate,
			FoodCategory category) {
		super();
		this.name = name;
		this.price = price;
		this.taxRate = taxRate;
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}

}
