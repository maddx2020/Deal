package by.academy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
	private String name;
	private String dateOfBirth;
	private Pattern p = Pattern.compile("([0]?[1-9]|[1|2][0-9]|[3]|[0|1])([\\.]|[/]|[-])([0]?[1-9]|1[0-2])([\\.]|[/]|[-])\\d{4}");

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

	public void setDateOfBirth(String dateOfBirth) {
		Matcher m = p.matcher(dateOfBirth);
		if(m.find()) {
			this.dateOfBirth = dateOfBirth;
		}else {
			System.out.println("Неверная дата рождения");
			return;
		}
	}

}
