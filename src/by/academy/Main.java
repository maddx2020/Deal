package by.academy;

public class Main {
	public static void main(String[] args) {

		User user1 = new User("Вася");
		User user2 = new User("Леха");
		user1.setDateOfBirth("01.13.1900");

		System.out.println(user1.getDateOfBirth());

		Product prod1 = new Product("хлеб", 1, 1.40);
		Product prod2 = new Product("молоко", 3, 2.11);
		Apple prod3 = new Apple("яблоко", 2, 1.50);
		Vino prod4 = new Vino("777", 5, 8);
		Chees prod5 = new Chees("дружба", 5, 3);

		Product[] products = { prod1, prod2, prod3, prod4, prod5 };

		Deal deal = new Deal(user1, user2, products);

		System.out.println("Первая сделка: " + deal.fullPrice());

		Product[] products1 = { prod4, prod5 };
		Deal deal1 = new Deal(user1, user2, products1);

		System.out.println("Вторая сделка: " + deal1.fullPrice());

		System.out.println("Сумма всех сделок: " + (deal1.fullPrice() + deal.fullPrice()));

		System.out.println(deal1.toString());
		
		System.out.println(deal.getBuyer().getName());
		
	}

}
