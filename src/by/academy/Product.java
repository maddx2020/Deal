package by.academy;

import java.io.Serializable;

@ProduserInfo(name = "Zakupka", company = "RIK", prodyctTypes = { "Eda", "Voda" }, partNumber = 179)
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
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
		builder.append("Наименование: \t");
		builder.append(name + "\t\t");
		builder.append("количество:	");
		builder.append(quantity + "\t");
		builder.append("цена за ед.:	");
		builder.append(price);
		return builder.toString();
	}

}
