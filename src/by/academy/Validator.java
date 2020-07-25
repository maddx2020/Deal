/* Сделал новый валидатор т.к. валидатор из домашки лежит в другом проекте и я его не могу импортировать.
 * Методы переопределил в классе User. Паттерны и матчеры лежат там же.
 */

package by.academy;

public interface Validator {

	public boolean phoneValidate(String phoneNumber);

	public boolean emailValidate(String email);

	public boolean dateOfBirthday(String dateOfBirth);

}
