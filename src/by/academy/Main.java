package by.academy;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String line = new String();
		Scanner scanner = new Scanner(System.in);

		User user1 = new User();
		User user2 = new User();
		User[] users = { user1, user2 };
		Validat phone = new User();
		Validat email = new User();

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
			System.out.println();
		}

		scanner.close();

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
//
//		System.out.println();

//		public void setDateOfBirth(String dateOfBirth) {
//			Pattern p = Pattern
//					.compile("([0]?[1-9]|[1|2][0-9]|[3]|[0|1])([\\.]|[/]|[-])([0]?[1-9]|1[0-2])([\\.]|[/]|[-])\\d{4}");
//			Matcher m = p.matcher(dateOfBirth);
//			if (m.find()) {
//				this.dateOfBirth = dateOfBirth;
//			} else {
//				System.out.println("Неверная дата рождения");
//				return;
//			}
//
//		}
	}

}
