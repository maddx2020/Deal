package by.academy;

public class Vino extends Product {

	private static final long serialVersionUID = 1L;
	private int discount;

	public Vino(String name, int quantity, double price) {
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
			discount = 10;
		} else {
			if (quantity >= 5 && quantity <= 10) {
				discount = 15;
			} else {
				discount = 20;
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
