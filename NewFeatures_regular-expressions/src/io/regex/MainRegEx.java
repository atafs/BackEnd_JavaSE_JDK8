package io.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainRegEx {
	
	//MAIN
	public static void main(String[] args) {
		
		//DATA TO ANALYSE ###############################
		String longString = "Americo Tomas  CA  AK 12345 PA (412)555-1212 johnsmith";
		String strangeString = " 1Z aaa **** *** {{{ {{ { ";
		
		//REGEX search
		/* 
		 * [A-Z]  		= any upper case letters
		 * [A-Za-z]		= any upper and lower case letters
		 * [0-9]		= numbers
		 * [^A-G]		= ^ is NOT: not A through G
		 * \\s			= white space
		 * \\S			= NOT white space
		 * {n, m}		= n(minimum) and m(max) values
		 * \\d			= digits or numbers
		 * \\D			= NOT digits or numbers
		 * {5}			= even that occur 5 times exactly
		 * |			= OR
		 * A[QWER]		= always starts with A and my have a second value (QWER)
		 * +			= what ever proceeds, must happens one or more times
		 * . ^ * + ? 	= need to backslash (protected character) 
		 * {} [] \ | ()	= need to backslash (protected character) 
		 *
		 * */
		
		//SEARCH ########################################
		//word that is 2 to 20 characters in length
		//[A-Za-z]{2,20} \\w{2,20}
		regexChecker("\\s[A-Za-z]{2,20}\\s", longString);
		
		//Zip code if 5 digits long
		//\\s\\d{5}\\s
		regexChecker("\\s\\d{5}\\s", longString);
		
		//States that start with AC or AD
		//A[KLRZ]|C[AOT]
		System.out.println("\n--------SEARCH---------");
		regexChecker("A[KLRZ] | C[AOT]", longString);
		
		//Protected character { (1 or more)
		System.out.println("\n--------SEARCH---------");
		regexChecker("(\\{{1,})", strangeString);

	}
	
	/** STATIC PROCEDURE: allow the user to search for a specific string of values */
	public static void regexChecker(String theRegEx, String str2check) {
		//API PATTERN class
		Pattern checkRegex = Pattern.compile(theRegEx);
		
		//API MATCHER class
		Matcher regexMatcher = checkRegex.matcher(str2check);
		
		//LOOP
		while (regexMatcher.find()) {
			//CONDITION: check if the string has a length
			if (regexMatcher.group().length() != 0) {
				//PRINT
				System.out.println();
				System.out.println("Word found = " + regexMatcher.group().trim() + " ###");
			}
			//PRINT API more methods
			System.out.println("Start Index = " + regexMatcher.start());
			System.out.println("End Index = " + regexMatcher.end());
		}
	}
}
