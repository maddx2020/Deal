package by.academy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.academy.H2.Ex5.Validator;

public class BelarusPhoneValidator implements Validator{

	Pattern p = Pattern.compile("^\\+375(17|25|29|33|44)[\\d]{7}$");
	
	
	
	@Override
	public boolean validate(String str) {
		Matcher m = p.matcher(str);
		return m.find();
	}
	
	

}
