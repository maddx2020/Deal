package by.academy;

public enum Status {
	New("Новая"), InProgress("В процессе"), Done("Готово");

	private String str;

	private Status(String str) {
		this.str = str;
	}

	public String getStr() {
		return str;
	}


}
