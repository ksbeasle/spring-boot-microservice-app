package com.icart.SellerMS.Validator;

public class Validator {

	
	public static boolean validateName(String name) {
		if(name.isEmpty()) {
			return false;
		}
		return name.matches("[a-zA-Z]+");
	}
}
