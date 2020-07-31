package by.academy;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;;

public class Deal implements Serializable {

	private static final long serialVersionUID = 1L;
	private User seller;
	private User buyer;
	private ArrayList<Product> prodList;
	private Status status;
	private Date deadline;
	private int i;
	final Date date = new Date();
	final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	Scanner sc = new Scanner(System.in);

	public Deal() {
		super();
		deadline();
	}

	public Deal(User seller, User buyer, /* Product[] products */ ArrayList<Product> prodList) {
		super();
		this.seller = seller;
		this.buyer = buyer;
		this.prodList = prodList;
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

	public ArrayList<Product> getProdList() {
		return prodList;
	}

	public void setProdList(ArrayList<Product> prodList) {
		this.prodList = prodList;
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
		for (Product p : prodList) {
			fullprice += p.fullSum();
		}
		return fullprice;
	}

	public void zapros() {
		System.out.println("Желаете: 1.Добавить покупки 2.Удалить покупки 3.Получить чек");
		switch (sc.nextInt()) {
		case 1: {
			addProduct();
			productInfo();
		}
			zapros();
			break;
		case 2: {
			delProduct();
			if (prodList.size() != 0) {
				productInfo();
			} else {
				System.out.println("\nУ вас пустая корзина!\n");
			}
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

	
	
	
	
	public void productInfo() {
		System.out.println("\nКорзина покупок: \n");
//		for (int i = 0; i < products.length; i++) {
//			System.out.println(i + 1 + ". " + products[i]);
//		}
//		System.out.println("\nЦена за покупки: " + fullPrice() + "\n");
//	}

		for (Product p : prodList) {
			System.out.println(++i + ". " + p);
		}
		System.out.println("\nЦена за покупки: " + fullPrice() + "\n");
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
		for (Product p : prodList) {
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
