package by.academy;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;;

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
	Scanner sc = new Scanner(System.in);

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

	public void zapros() {
		System.out.println("Желаете: 1.Добавить покупки 2.Удалить покупки 3.Получить чек");
		switch (sc.nextInt()) {
		case 1: {
			addProduct();
			System.out.println();
			for (int i = 0; i < products.length; i++) {
				System.out.println(i + 1 + ". " + products[i]);
			}
			System.out.println();
		}
			zapros();
			break;
		case 2: {
			delProduct();
			System.out.println();
			for (int i = 0; i < products.length; i++) {
				System.out.println(i + 1 + ". " + products[i]);
			}
			System.out.println();
		}
			zapros();
			break;
		default:
			System.out.println("\n\n" + toString());
			break;
		}
	}

	public void addProduct() {
		Product[] products1 = new Product[products.length + 1];
		Product prod = new Product();
		System.out.print("Введите название продукта: ");
//		String s = sc.next();
		prod.setName(sc.next());
		System.out.print("Введите количество: ");
		prod.setQuantity(sc.nextInt());
		System.out.print("Введите цену продукта: ");
		prod.setPrice(sc.nextDouble());
		for (int i = 0; i < products.length; i++) {
			products1[i] = products[i];
		}
		products1[products.length] = prod;
		this.products = products1;
	}

	public void delProduct() {
		int i = -1;
		Product[] products1 = new Product[products.length - 1];
		System.out.print("Выберете номер продукта который желаете удалить:");
		int n = sc.nextInt();
		for (int j = 0; j < products1.length; j++) {
			i++;
			if (i != n - 1) {
				products1[j] = products[i];
			} else {
				i++;
				products1[j] = products[i];
			}
		}
		this.products = products1;
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
		for (Product p : products) {
			builder.append(p);
			builder.append("\n");
		}
		builder.append("\n\nСтатус сделки: ");
		builder.append(Status.Done.getStr() + "\n");
		builder.append("Итоговая сумма к оплате: ");
		builder.append(fullPrice());
		return builder.toString();
	}

}
