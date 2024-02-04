package pos.model;

public class Gratuity {
	private Bill bill;
	private double gratuityAmount;
	
	public Gratuity(Bill bill, double gratuityAmount) {
		super();
		this.bill = bill;
		this.gratuityAmount = gratuityAmount;
	}
	
	public Bill getBill() {
		return bill;
	}
	
	public double getGratuityAmount() {
		return gratuityAmount;
	}
	
}
