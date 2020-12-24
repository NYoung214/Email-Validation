package Validations;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class ValidationMethods {
	List<String> emails;
	
	int arraySize = 0;
	int nextIndex = 0;
	
	// =========================== Regex Validation ===========================
	// =========================== Email Validation ===========================
	Pattern emailPattern = Pattern.compile("([^\s]+@([^\s]{2,30}\\.[a-z]{2,10}))");
	
	// =========================== User ID Validation ===========================
	Pattern userIDPattern = Pattern.compile("([a-zA-Z0-9]{2,30})\\.([a-zA-Z0-9]{2,30})");
	
	// =========================== Name Validation ===========================
	Pattern namePattern = Pattern.compile("([a-zA-Z0-9]{2,30})\\s([a-zA-Z0-9]{2,30})");
	
	
	
	
		
	// =========================== CONSTRUCTOR ===========================
	public ValidationMethods(int size) {
		this.arraySize = size;
		emails = new ArrayList<String>(size);
	}
	
	
	
	
	// =========================== ORDER OF OPERATIONS ===========================
	public boolean operate(String other) {
		if(isEmpty()) {
			System.out.println("List is empty.");
			return false;
		}
		
		String email = convert(other);
		
		if(email.equals("-1")) {
			System.out.println("Input not recognized.");
			return false;
		}
		
		if(!search(email)) {
			System.out.println(other + " was not found.");
			return false;
		}
		return true;		
	}



	// =========================== SEARCH METHODS ===========================
	private boolean search(String emailAddress) {
		for(String email : emails) {
			if(emailAddress.equalsIgnoreCase(email)) {
				System.out.println("Found email.");
				return true;
			}
		}
		return false;
	}
	
	// =========================== CONVERT INPUT TO EMAIL ==================
	private String convert(String other) {

		String email;
		Matcher emailMatcher = emailPattern.matcher(other);
		Matcher userIDMatcher = userIDPattern.matcher(other);
		Matcher nameMatcher = namePattern.matcher(other);

		if(emailMatcher.find()) {
			email = emailMatcher.group();
		}else if(userIDMatcher.find()) {
			email = buildEmail(userIDMatcher.group(1),userIDMatcher.group(2));
		}else if(nameMatcher.find()) {
			email = buildEmail(nameMatcher.group(1),nameMatcher.group(2));
		}else {
			return "-1";
		}
		return email;
	}
	

	
	// =========================== BUILD NAME ===========================
	private String buildEmail(String firstName, String lastName) {
		StringBuilder fullEmail = new StringBuilder();
		fullEmail.append(firstName);
		fullEmail.append(".");
		fullEmail.append(lastName);
		fullEmail.append("@email.com");
		return fullEmail.toString();
	}
	
	
	// =========================== ADD ===========================
	public void add(String other) {
		String email = convert(other);
		emails.add(email);
		this.nextIndex++;
	}
	
	// =========================== REMOVE ===========================
	public void remove(String other) {
		String email = convert(other);
		if(search(email)) {
			emails.remove(email);
			this.nextIndex--;
			System.out.println(other + " was successfully deleted from the email list.");
		}else {
			System.out.println(other + " was not found.");
		}

	}
	
	// =========================== isEmpty ===========================
	public boolean isEmpty() {
		return this.nextIndex == 0;
	}
	
	// =========================== Print Array ===========================
	public void printArray() {
		for(String email : emails)
			System.out.println(email);
	}
	
	
	

}
