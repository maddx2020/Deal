package by.academy;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main {
	public static void main(String[] args) {

		User user1 = new User("Вася");
		User user2 = new User("Леха");
		user1.setDateOfBirth("01.12.1900");
		user1.setPhone("+375291122333");
		user1.setEmail("tut@nikogo.net");
		user2.setPhone("+375295556677");
		user2.setEmail("mozgov@tut.net");

		Product prod1 = new Product("Хлеб Черный", 1, 1.40);
		Product prod2 = new Product("Молоко 3%", 3, 2.11);
		Apple prod3 = new Apple("Яблоко Golden", 2, 1.50);
		Vino prod4 = new Vino("Портвейн 777", 5, 8);
		Chees prod5 = new Chees("сырок Дружба", 5, 3);

		Product[] products = { prod1, prod2, prod3, prod4, prod5 };

		Deal deal = new Deal(user1, user2, products);

//		Product[] products1 = { prod4, prod5 };
//		Deal deal1 = new Deal(user1, user2, products1);

		System.out.println(deal.toString());

		System.out.println();
		

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Calendar s = Calendar.getInstance();
		s.add(Calendar.DAY_OF_MONTH,10);
		System.out.println(sdf.format(s.getTime()));
		
		
		//		Date date = new Date();
//		System.out.println(date);
//		System.out.print(a.getTime() + " + 10 дней ");
//		a.add(Calendar.DAY_OF_MONTH, 10);
//		System.out.println(a.getTime());
	}

}
