package by.academy;

import java.util.Date;
import java.io.Serializable;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private Date dateOfBirth;
	private String phone;
	private String email;

	public User() {
		super();

	}

	public User(String name) {
		super();
		this.name = name;

	}

	
	public User(String name, Date dateOfBirth, String phone, String email) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.phone = phone;
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
