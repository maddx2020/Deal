package by.academy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
	private String name;
	private String dateOfBirth;
	private String phone;
	private String email;

	public User() {
		super();

	}

	public User(String name) {
		super();
		this.name = name;

	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDateOfBirth(String dateOfBirth) {
		Pattern p = Pattern
				.compile("([0]?[1-9]|[1|2][0-9]|[3]|[0|1])([\\.]|[/]|[-])([0]?[1-9]|1[0-2])([\\.]|[/]|[-])\\d{4}");
		Matcher m = p.matcher(dateOfBirth);
		if (m.find()) {
			this.dateOfBirth = dateOfBirth;
		} else {
			System.out.println("Неверная дата рождения");
			return;
		}

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\t"+name);
		builder.append("\t Контактная информация: тел. ");
		builder.append(phone);
		builder.append(", email: ");
		builder.append(email);
		return builder.toString();
	}

}
