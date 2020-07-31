package by.academy;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User implements Serializable, Validator {

	private static final long serialVersionUID = 1L;
	private String name;
	private String dateOfBirth;
	private String phoneNumber;
	private String email;
	private Pattern p = Pattern.compile("^\\+375(17|25|29|33|44)\\d{7}$");
	private Pattern p1 = Pattern.compile("[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,64}");
	private Pattern p2 = Pattern
			.compile("([0]?[1-9]|[1|2][0-9]|[3]|[0|1])(\\.|/|-)([0]?[1-9]|1[0-2])(\\.|/|-)\\d{2,4}");

	public User() {
		super();
		
	}

	public User(String name, String dateOfBirth, String phoneNumber, String email) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;

	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public boolean phoneValidate(String phoneNumber) {
		Matcher m = p.matcher(phoneNumber);
		return !m.find();
	}

	@Override
	public boolean emailValidate(String email) {
		Matcher m1 = p1.matcher(email);
		return !m1.find();
	}

	@Override
	public boolean dateOfBirthday(String dateOfBirth) {
		Matcher m2 = p2.matcher(dateOfBirth);
		return !m2.find();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\t" + name + "\t");
		builder.append("\t Контактная информация: тел. ");
		builder.append(phoneNumber + ", \t");
		builder.append("email: ");
		builder.append(email);
		return builder.toString();
	}

}
