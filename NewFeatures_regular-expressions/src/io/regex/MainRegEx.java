package io.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainRegEx {
	
	//MAIN
	public static void main(String[] args) {
		
		//DATA TO ANALYSE ###############################
		String longString = "Americo Tomas  CA  AK 12345 PA (412)555-1212 atafs@iscte-iul.com";
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
		 * \\w			= type caracter
		 * \\W			= NOT any type carater
		 * *			= happen 0 or more times
		 * ?			= could exit or not (uncertain)
		 * */
		
		//BASIC SEARCH ########################################
		
		//word that is 2 to 20 characters in length
		//[A-Za-z]{2,20} \\w{2,20}
		regexChecker("\\s[A-Za-z]{2,20}\\s", longString);
		
		//Zip code if 5 digits long
		//\\s\\d{5}\\s
		regexChecker("\\s\\d{5}\\s", longString);
		
		//States that start with AC or AD
		//A[KLRZ]|C[AOT]
		System.out.println("\n--------SEARCH A[KLRZ] | C[AOT] ---------");
		regexChecker("A[KLRZ] | C[AOT]", longString);
		
		//Protected character { (1 or more)
		System.out.println("\n--------SEARCH {1,}---------");
		regexChecker("(\\{{1,})", strangeString);
		
		//Protected character { (1 or more)
		System.out.println("\n--------SEARCH + ---------");
		regexChecker("(\\{+)", strangeString);
		
		//Anything . (3 or more)
		System.out.println("\n--------SEARCH .{3} ---------");
		regexChecker(".{3}", strangeString);
		
		//word type caracter \\w
		System.out.println("\n--------SEARCH .{3} ---------");
		regexChecker(".{3}", strangeString);
		
		//ADVANCED SEARCH ########################################
		
		//email address: xxx@yyy.zzzz
		//can have: [A-Za-z0-9.%-]
		//have the symbol: @
		System.out.println("\n--------SEARCH email ---------");
		regexChecker("[A-Za-z0-9.%-]+@[A-Za-z0-9.%-]+.[A-Za-z]{2,4}", longString);
		
		//phone number
		//(xxx)yyy-yyyy
		//combinations possible: 1-(412)555-1212 (412)555-1212 412-555-1234 412 555-1234
		System.out.println("\n--------SEARCH phone ---------");
		regexChecker("([0-9]( |-)?)?(\\(?[0-9]{3}\\)?|[0-9]{3})( |-)?([0-9]{3}( |-)?[0-9]{4}|[a-zA-Z0-9]{7})", longString);
		
		//BASIC REPLACE ########################################
		
		System.out.println("\n--------REPLACE VOID space by comma ---------");
		regexReplace(longString);
		System.out.println("Initial Data: " + longString);
		
		System.out.println("\n--------REPLACE RETURN space by comma ---------");
		String s = regexReplaceReturnString(longString);
		System.out.println();
		System.out.println("Function Method: " + s);
		System.out.println("Initial Data: " + longString);
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
	
	/** STATIC PROCEDURE: replace all spaces (\\s) with comma and spaces (, ) */
	public static void regexReplace(String str2replace) {
		//API PATTERN class
		Pattern replace = Pattern.compile("\\s+");
		
		//API MATCHER class
		Matcher regexMatcher = replace.matcher(str2replace.trim());
		
		//PRINT
		System.out.println();
		System.out.println("Void Method: " + regexMatcher.replaceAll(", "));
	}
	
	/** STATIC FUNCTION: replace all spaces (\\s) with comma and spaces (, ) and returns a String */
	public static String regexReplaceReturnString(String str2replace) {
		//API PATTERN class
		Pattern replace = Pattern.compile("\\s+");
		
		//API MATCHER class
		Matcher regexMatcher = replace.matcher(str2replace.trim());
		
		//RETURN
		return regexMatcher.replaceAll(", ");
	}
}
