package by.academy;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
	final Date date = new Date();
	final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	final DecimalFormat df = new DecimalFormat(".##");
	Scanner sc = new Scanner(System.in);

	public Deal() {
		super();
		deadline();
	}

	public Deal(User seller, User buyer, ArrayList<Product> prodList) {
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
			if (prodList.size() != 0) {
				delProduct();
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
		Product prod = new Product();
		System.out.print("Введите название продукта: ");
		prod.setName(sc.next());
		System.out.print("Введите количество: ");
		prod.setQuantity(sc.nextInt());
		System.out.print("Введите цену продукта: ");
		prod.setPrice(sc.nextDouble());
		prodList.add(prod);
	}

	public void delProduct() {
		System.out.print("Выберете номер продукта который желаете удалить:");
		prodList.remove(sc.nextInt() - 1);
	}

	public void productInfo() {
		System.out.println("\nКорзина покупок: \n");
		for (int i = 0; i < prodList.size(); i++) {
			System.out.println(i + 1 + ". " + prodList.get(i));
		}

		System.out.println("\nЦена за покупки: " + df.format(fullPrice()) + "\n");
	}

	public void deal() {
		productInfo();
		zapros();
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
		builder.append(df.format(fullPrice()));
		return builder.toString();
	}

}
