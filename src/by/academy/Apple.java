package by.academy;

public class Apple extends Product {

	private static final long serialVersionUID = 1L;
	private int discount;

	public Apple(String name, int quantity, double price) {
		super(name, quantity, price);
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int discount() {

		if (quantity < 5) {
			discount = 1;
		} else {
			if (quantity >= 5 && quantity <= 10) {
				discount = 3;
			} else {
				discount = 5;
			}
		}
		return discount;
	}

	@Override
	public double fullSum() {
		discount();
		return price * quantity * (100 - discount) / 100;
	}

}