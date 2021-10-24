package testfinalproject;

import java.sql.SQLException;
import java.util.Scanner;

public class Test {
	//Main method
	public static void main(String[] args) throws SQLException {			
	
		//creating class variables
		int i = 0;
		int option;
	
		//Calling overloaded constructor
		//TaskManager obj = new TaskManager("Guest", 1234);
	
		//Calling method of the subclass with superclass reference variable
		//Achieving run time polymorphism
		Implementation childObj = new TaskManager();		
	
		//Calling dayAndDate method and storing returned value in a string variable
		String day = childObj.dayAndDate();
		
		//Do while loop to output the options until the condition is satisfied
		do{
			//Checks the day with user input string
			if(day.equals("Saturday")){
				 System.out.println("===============================================");
				 System.out.println("Choose one of the options below");
				 System.out.println("1. Membership");
				 System.out.println("2. Workout");				 
				 System.out.println("3. Calorie Calculator");				
				 System.out.println("4. Exit");
				 System.out.println("===============================================");
				 
				 Scanner scanner = new Scanner(System.in);
				 //Reads user input
				 option = scanner.nextInt();
				 
				 System.out.println("Your choice is " + option);
				 System.out.println(" ");
				 				
				 //calls the membership method if the option is 1
				 if (option==1) {
					 childObj.membership();
				 }
				//calls the workout method if the option is 2
				 else if(option==2) {
					 childObj.workout();
					 
				 }
				//calls the calorieCalculator method if the option is 3
				 else if(option==3) {
					 childObj.calorieCalculator();					 
				 }
				 
				//prints if the option is 4
				else if (option==4) {
					 System.out.println("Thank you!");
					 break;
				}
				 }
			}while (i<=4);//Do while loop ends here
			
		}
	
	}

