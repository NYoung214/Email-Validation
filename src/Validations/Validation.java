package Validations;

import java.util.Scanner;

public class Validation {

	public static void main(String[] args) {
		//create ArrayList of emails
		ValidationMethods emailList = new ValidationMethods(5);
		
		//add emails to ArrayList
		emailList.add("nathaniel.young@email.com");
		emailList.add("john.doe@email.com");
		emailList.add("jane.doe@email.com");
		emailList.add("johan.rohan@email.com");
		emailList.add("john.jones@email.com");
		emailList.add("mountain.lion@email.com");
		emailList.add("paul.pierce@email.com");
		emailList.add("roy.williams@email.com");
		emailList.add("jenny.ginger@email.com");
		emailList.add("ricky.martin@email.com");
		emailList.add("brittney.spears@email.com");
		emailList.add("whitney.houston@email.com");
		emailList.add("george.washington@email.com");
		emailList.add("leonard.nimoy@email.com");
		
		// 	// =========================== PRINT THE UI ===========================
		//ask user for input
		Scanner input = new Scanner(System.in);
		String choice,user,loop = "1";
		
		
		while(loop.equals("1")) {
			System.out.println("\nSelect an option below:\n1:\tSearch for User\n2:\tAdd User\n3:\tDelete User\n4:\tPrint Users\n0:\tExit\n");
			choice = input.nextLine();
			if(choice.equals("0")) {
				break;
			}
			else if(choice.equals("4")) {
				emailList.printArray();
				continue;
			}
			else if(choice.equals("1") || choice.equals("2") || choice.equals("3")) {
				System.out.println("\n\nEnter a User's Full Name, Email Address, or User ID:\n"
						+ "========== Example =========="
						+ "\nUser Name:\tJohn Doe\nEmail:\t\tJohn.Doe@email.com\nUser ID:\tJohn.Doe\n");
				user = input.nextLine();
				switch(choice) {
				case "1":
					emailList.operate(user);
					break;
				case "2":
					emailList.add(user.toLowerCase());
					System.out.println(user + " was successfully added to the email list.");
					break;
				case "3":
					emailList.remove(user);
					break;
				}			
			}else {
				System.out.println("Please select a number.");
			}			
		}


		
		
		
		
		
		

		
		
		

		input.close();
	}

}
