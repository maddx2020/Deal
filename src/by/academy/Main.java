package by.academy;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String line = new String();
		Scanner scanner = new Scanner(System.in);

		User user1 = new User();
		User user2 = new User();
		Validator phone = new User();
		Validator email = new User();
		Validator birth = new User();

//Для быстрого ввода(раскомментровать)		
//		
//		user1 = new User("Вова", "01-02-1900", "+375172233444", "tut@nikogo.net");
//		user2 = new User("Васька", "29.02.2001", "+375334455666", "mozgov@tut.net");

		User[] users = { user1, user2 };
		for (User u : users) {
			System.out.print("Введите имя участника сделки: ");
			u.setName(scanner.nextLine());
			System.out.print("Введите номер телефона: ");
			line = scanner.nextLine();
			while (phone.phoneValidate(line)) {
				System.out.print("Неверный номер. Введите повторно: ");
				line = scanner.nextLine();
			}
			u.setPhoneNumber(line);
			System.out.print("Введите email адрес: ");
			line = scanner.nextLine();
			while (email.emailValidate(line)) {
				System.out.print("Неверный адрес. Введите повторно: ");
				line = scanner.nextLine();
			}
			u.setEmail(line);
			System.out.print("Введите дату рождения: ");
			line = scanner.nextLine();
			while (birth.dateOfBirthday(line)) {
				System.out.print("Неверная дата. Введите повторно: ");
				line = scanner.nextLine();
			}
			u.setDateOfBirth(line);
			System.out.println();
		}
		Product prod1 = new Product("Хлеб", 1, 1.40);
		Product prod2 = new Product("Молоко", 3, 2.11);
		Apple prod3 = new Apple("Яблоко", 2, 1.50);
		Vino prod4 = new Vino("Вино", 5, 8);
		Chees prod5 = new Chees("Сыр", 5, 3);

		ArrayList<Product> prodList = new ArrayList<Product>();
		prodList.add(prod1);
		prodList.add(prod2);
		prodList.add(prod3);
		prodList.add(prod4);
		prodList.add(prod5);

		Deal deal = new Deal(user1, user2, prodList);

		deal.deal();

		scanner.close();
	}

}
