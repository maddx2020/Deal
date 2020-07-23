package by.academy;

@ProduserInfo(name = "Zakupka", company = "RIK", prodyctTypes = { "Eda", "Voda" }, partNumber = 179)
public class Product {

	private String name;
	protected int quantity;
	protected double price;

	public Product() {
		super();
	}

	public Product(String name, int quantity, double price) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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

	public double fullSum() {
		return price * quantity;

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\nНаименование: \t");
		builder.append(name);
		builder.append("\tколичество: ");
		builder.append(quantity);
		builder.append("\t цена за ед.: ");
		builder.append(price);
		return builder.toString();
	}

}
