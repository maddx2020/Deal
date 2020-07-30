package by.academy;

public class Chees extends Product {

	private static final long serialVersionUID = 1L;
	int discount;

	public Chees(String name, int quantity, double price) {
		super(name, quantity, price);
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int discount() {

		if (quantity < 3) {
			discount = 5;
		} else {
			if (quantity >= 5 && quantity <= 10) {
				discount = 7;
			} else {
				discount = 10;
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
