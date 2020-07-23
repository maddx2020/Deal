package by.academy;

import java.util.Arrays;

public class Deal {
	private User seller;
	private User buyer;
	private Product[] products;
	private Status status;

	public Deal() {
		super();
	}

	public Deal(User seller, User buyer, Product[] products) {
		super();
		this.seller = seller;
		this.buyer = buyer;
		this.products = products;
		this.status = Status.New;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}

	public User getSeller() {
		return seller;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}

	public User getBuyer() {
		return buyer;
	}

	public void setProducts(Product[] products) {
		this.products = products;
	}

	public Product[] getProducts() {
		return products;
	}

	public double fullPrice() {
		double fullprice = 0;
		for (Product p : products) {
			fullprice += p.fullSum();
		}
		return fullprice;
	}

	@SuppressWarnings("static-access")
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Статус сделки: ");
		builder.append(status.New.getStr() + "\n");
		builder.append("Накладная \n\nПродавец: ");
		builder.append(seller);
		builder.append("\nПокупатель: ");
		builder.append(buyer);
		builder.append("\n\nСтатус сделки: ");
		builder.append(status.InProgress.getStr() + "\n");
		builder.append("Информация по товарам:\n");
		builder.append(Arrays.toString(products) + "\n");
		builder.append("\nСтатус сделки: ");
		builder.append(Status.Done.getStr()+ "\n");
		builder.append("Итоговая сумма сделки: ");
		builder.append(fullPrice());
		return builder.toString();
	}

}
