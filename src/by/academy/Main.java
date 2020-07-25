package by.academy;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String line = new String();
		Scanner scanner = new Scanner(System.in);

		User user1 = new User();
		User user2 = new User();
		User[] users = { user1, user2 };
		Validator phone = new User();
		Validator email = new User();
		Validator birth = new User();

		user1 = new User("Вова", "01-02-1900", "+375172233444", "tut@nikogo.net");
		user2 = new User("Васька", "29.02.2001", "+375334455666", "mozgov@tut.net");

//		for (User u : users) {
//			System.out.print("Введите имя участника сделки: ");
//			u.setName(scanner.nextLine());
//			System.out.print("Введите номер телефона: ");
//			line = scanner.nextLine();
//			while (phone.phoneValidate(line)) {
//				System.out.print("Неверный номер. Введите повторно: ");
//				line = scanner.nextLine();
//			}
//			u.setPhoneNumber(line);
//			System.out.print("Введите email адрес: ");
//			line = scanner.nextLine();
//			while (email.emailValidate(line)) {
//				System.out.print("Неверный адрес. Введите повторно: ");
//				line = scanner.nextLine();
//			}
//			u.setEmail(line);
//			System.out.print("Введите дату рождения: ");
//			line = scanner.nextLine();
//			while (birth.dateOfBirthday(line)) {
//				System.out.print("Неверная дата. Введите повторно: ");
//				line = scanner.nextLine();
//			}
//			u.setDateOfBirth(line);
//			System.out.println();
//		}

		Product prod1 = new Product("Хлеб", 1, 1.40);
		Product prod2 = new Product("Молоко", 3, 2.11);
		Product prod3 = new Apple("Яблоко", 2, 1.50);
		Product prod4 = new Vino("Вино", 5, 8);
		Product prod5 = new Chees("Сыр", 5, 3);

		Product[] products = { prod1, prod2, prod3, prod4, prod5 };
		Deal deal = new Deal(user1, user2, products);

//		Product[] products1 = { prod4, prod5 };
//		Deal deal1 = new Deal(user1, user2, products1);

//		System.out.println(deal.toString());

		System.out.println("Корзина покупок: \n");
		for (int i = 0; i < products.length; i++) {
			System.out.println(i + 1 + ". " + products[i]);
		}
		System.out.println();
		deal.zapros();
		scanner.close();
	}

}
