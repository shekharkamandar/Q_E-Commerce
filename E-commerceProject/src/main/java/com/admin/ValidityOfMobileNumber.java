package com.admin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidityOfMobileNumber {

	public static boolean isValidMobileNo(String mobile)  
	{  
	
	Pattern ptrn = Pattern.compile("(0/91)?[7-9][0-9]{9}");  
	
	Matcher match = ptrn.matcher(mobile);  
	
	return (match.find() && match.group().equals(mobile));  
	
	}  
	 
}
