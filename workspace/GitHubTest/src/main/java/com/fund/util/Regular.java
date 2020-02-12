package com.fund.util;

public class Regular {
	public static final String EMAIL = "^[a-zA-Z][a-zA-Z0-9]*@[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+){1,2}$" ;
	//public static final String PASSWORD = "^(?=.*\\d)(?=.*[a-zA-Z])[a-zA-Z0-9_]{6,18}$" ;
	public static final String PASSWORD = "^(?=^.{6,12}$)((?=.*[0-9])(?=.*[a-z|A-Z]))^.*$";
	public static final String TWID = "^[A-Z]\\d{9}$";
	public static final String PHONE = "^09[0-9]{8}$";
}
