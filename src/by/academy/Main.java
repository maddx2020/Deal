package by.academy;

public class Main {
	public static void main(String[] args) {

		User user1 = new User("Вася");
		User user2 = new User("Леха");
		user1.setDateOfBirth("01.12.1900");
		user1.setPhone("+375291122333");
		user1.setEmail("tut@nikogo.net");
		user2.setPhone("+375295556677");
		user2.setEmail("mozgov@tut.net");

//		System.out.println(user1.getDateOfBirth());

		Product prod1 = new Product("Хлеб Нарочанский", 1, 1.40);
		Product prod2 = new Product("Молоко 3%", 3, 2.11);
		Apple prod3 = new Apple("Яблоко Golden", 2, 1.50);
		Vino prod4 = new Vino("Портвейн 777", 5, 8);
		Chees prod5 = new Chees("сырок Дружба", 5, 3);

		Product[] products = { prod1, prod2, prod3, prod4, prod5 };

		Deal deal = new Deal(user1, user2, products);

//		System.out.println("Первая сделка: " + deal.fullPrice());

		Product[] products1 = { prod4, prod5 };
		Deal deal1 = new Deal(user1, user2, products1);

//		System.out.println("Вторая сделка: " + deal1.fullPrice());
//
//		System.out.println("Сумма всех сделок: " + (deal1.fullPrice() + deal.fullPrice()));

		System.out.println(deal1.toString());

	}

}
