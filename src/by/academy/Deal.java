package by.academy;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;;

public class Deal implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User seller;
	private User buyer;
	private Product[] products;
	private Status status;
	private Date deadline;
	final Date date = new Date();
	final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

	public Deal() {
		super();
		deadline();
	}

	public Deal(User seller, User buyer, Product[] products) {
		super();
		this.seller = seller;
		this.buyer = buyer;
		this.products = products;
		this.setStatus(Status.New);
		deadline();
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getDeadline() {
		return deadline;
	}

	private void deadline() {
		Calendar s = new GregorianCalendar();
		s.add(Calendar.DAY_OF_MONTH, 10);
		this.deadline = s.getTime();
	}

	public double fullPrice() {
		double fullprice = 0;
		for (Product p : products) {
			fullprice += p.fullSum();
		}
		return fullprice;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Статус сделки: ");
		builder.append(Status.New.getStr());
		builder.append("\n\tДата начала сделки: ");
		builder.append("\t" + sdf.format(date));
		builder.append("\n\tДата окончания сделки: ");
		builder.append("\t" + sdf.format(deadline) + "\n\n");
		builder.append("Накладная \nПродавец: ");
		builder.append(seller);
		builder.append("\nПокупатель: ");
		builder.append(buyer);
		builder.append("\n\nСтатус сделки: ");
		builder.append(Status.InProgress.getStr() + "\n");
		builder.append("Информация по товарам:\n");
		builder.append(Arrays.toString(products) + "\n");
		builder.append("\nСтатус сделки: ");
		builder.append(Status.Done.getStr() + "\n");
		builder.append("Итоговая сумма сделки к оплате: ");
		builder.append(fullPrice());
		return builder.toString();
	}

}
