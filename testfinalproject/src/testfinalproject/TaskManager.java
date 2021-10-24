package testfinalproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Statement;
import java.util.Scanner;

//Creating a subclass 
public class TaskManager extends Implementation{
	
		//Scanner object creation
		Scanner sc = new Scanner(System.in);
		
	
	//Overloaded Constructor 
	public TaskManager(String userName, int id) {
		//Calling superclass constructor
		super();
		
		//Accessing superclass private variables
		setName(userName);
		setID(id);
		System.out.println("Welcome "+userName);
		System.out.println("You ID number is "+id);
				
		//Prompting user input
		System.out.println("Please enter your name");
		String name = sc.next();
		System.out.println("Hi "+name+ "!");
	}
		//Default constructor
		public TaskManager() {		
	
	}
	
	//This method suggests workouts based on the calorie intake
	public void workout() throws SQLException {	
		
			System.out.println("Enter the number of days");					
			
			//Reading user input
			int number = sc.nextInt();
		
			//Creating string array to get days
			String days[]= new String[number];
		
			//Creating int array to get calories
			int calorie[]=new int[number];
		
			//iterates to the number of days
			for(int i=0;i<number;i++) {
			
			System.out.println("Enter day: ");			
			//Gets string values and adds to the array
			days[i] = sc.next();
					
			System.out.println("Enter calorie: ");			
			//Gets int values and adds to the array
			calorie[i] = sc.nextInt();	
			System.out.println();
			}		
			//iterates to number of days and adding values to the array
				System.out.println("Summary: ");
			for(int i=0;i<number;i++) {
				System.out.println(days[i]+ " "+ calorie[i]+ " ");
				System.out.println();
				
				//1.Create connection
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","Mysql@a1");
				
				//2. Create statement/query
				Statement smt = con.createStatement();
				String s = "INSERT INTO CALORIES VALUES ('"+days[i]+"','"+calorie[i]+"')";
				//3.Execute Statement/Query
				smt.execute(s);		
				//4.Close connection
				con.close();
				
				System.out.println("Query executed");				
		}		
			
			//this for loop checks all the conditions for each entry of calories
			for(int i=0;i<number;i++) {
		
				//if the calories less than or equal to 2200
				if(calorie[i]<=2200){
					System.out.println("Intake of " + calorie[i]+ " calories a day is healthy!");
					System.out.println("Just 30 minutes of walking will be enough to keep energy levels high");
					System.out.println(" ");
				}
				//if the calories greater than 2200 and less than or equal to 3000
				if(calorie[i]>2200 && calorie[i]<=3000)  {
					System.out.println("Intake of " + calorie[i]+ " calories is a bit higher than the average daily intake ");
					System.out.println("45 minutes of jogging can help you burn the extra calories");
					System.out.println(" ");
				}
				//if the calories greater than 3100 and less than or equal to 4000
				if(calorie[i]>3100 && calorie[i]<=4000) {
					System.out.println("Intake of " + calorie[i]+ " calories is more than the average daily intake ");
					System.out.println("A 45 minute jog along with some full-body exercises will help you burn the calories");
					System.out.println(" ");
				}
				//if the calories greater than or equal to 4100 and less than or equal to 5000
				if(calorie[i]>=4100 && calorie[i]<=5000) {
					System.out.println("Intake of " + calorie[i]+ " calories is much more than average daily intake ");
					System.out.println("60 minutes of jogging along with some full-body exercises will help you burn the calories");
					System.out.println(" ");
				}
				//if the calories greater than 5000
				if(calorie[i]>5000){
					System.out.println("Intake of " + calorie[i]+ " calories is very high ");
					System.out.println("60 minutes of jogging along with some high intensity exercises will help you burn the calories");
					System.out.println(" ");
				}
			}
	}	
	
	//This method calculates calories based on food intake
	public void calorieCalculator() throws SQLException {
		//Create connection with DB
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","Mysql@a1");
		
		//Create statement/query
		Statement smt = con.createStatement();
		
			System.out.println("Calorie intake can be calculated based on the foods you ate.");
			System.out.println(" ");
			
			//Declaring final variable
			final int calorieNeeds = 2000;	
			
			//Initializing local variables
			int foodNumber=1, total=0, temp =0, diff=0;
		
		//Do while for displaying options until the condition is satisfied
		do {
		
			//User options
			System.out.println("Enter the food number corresponding to the food to calculate the calories");
			System.out.println(" ");
			System.out.println("1.Pizza Slice");
			System.out.println("2.Hamburger");
			System.out.println("3.French Fries");
			System.out.println("4.Ice Cream Sundae");
			System.out.println("5.Chicken Sandwich");
			System.out.println("6.Celery Soup");
			System.out.println("7.Vegetable Salad");
			System.out.println("8.Carrot Juice");
			System.out.println("9.Green Tea");
			System.out.println("10.Exit");
			System.out.println("***********************************");		
		
			//Reading the food number
			foodNumber= sc.nextInt();
		
			//if food number equals to 10, then exits the loop
			 if(foodNumber==10) {
				 System.out.println("It is generally recommended to consume 2,000 calories a day for women and 2,500 calories a day  for men");
				 System.out.println(" ");
				 System.out.println("Your total calorie intake for today was " + temp);
				 System.out.println("Thank you!");				
				 break;
			 }
		
			 //if food number greater than 10, then prompt for a valid number
			 if(foodNumber>=11) {
				 System.out.println("Please enter a valid number");
				 break;		
			}
		
		    else {
		    	System.out.println("Enter the quantity");
		
		    int quantity = sc.nextInt();	
		
		    //switch case gets the food number and calculates corresponding calories with quantity
		    switch(foodNumber) { 
		    	case 1:
					total=285*quantity;
					System.out.println("There are " + total+ " calories in " + quantity+ " slices of pizza ");
					break;
			      
				case 2:	
					total=295*quantity;
					System.out.println("There are " + total+ " calories in " + quantity+ " hamburgers");
					break;
		
				case 3:
					total=312*quantity;
					System.out.println("There are " + total+ " calories in " + quantity+ " sets of fries");  
					break;
			
				case 4:
					total=180*quantity;
					System.out.println("There are " + total+ " calories in " + quantity+ " ice cream sundaes");  
					break;
		
				case 5:
					total=283*quantity;
					System.out.println("There are " + total+ " calories in " + quantity+ " Chicken Sandwiches");  
					break;
		
				case 6:
					total=183*quantity;
					System.out.println("There are " + total+ " calories in " + quantity+ " celery soups");  
					break;
			
				case 7:
					total=33*quantity;
					System.out.println("There are " + total+ " calories in " + quantity+ " vegetable salads");  
					break;
			
				case 8:
					total=93*quantity;
					System.out.println("There are " + total+ " calories in " + quantity+ " carrot juices");  
					break;
		
				case 9:
					total=2*quantity;
					System.out.println("There are " + total+ " calories in " + quantity+ " green tea");  
					break;
				}		
		    //Storing calories in temp variable
		    temp=total+temp;	
		    
		    //Update Command for quantity
		    String s = "UPDATE CALCULATOR SET Quantity = '"+quantity+"' WHERE number = '"+foodNumber+"'";
		    smt.execute(s);
		    
		    //Update Command for calories
		    String s1 = "UPDATE CALCULATOR SET Calories = '"+total+"' WHERE number = '"+foodNumber+"'";
		    smt.execute(s1);
		    
		    //Select command to retrieve entire row of corresponding food column
		    String s2 = "SELECT * FROM Calculator WHERE number = '"+foodNumber+"'";
			
		    ResultSet result = smt.executeQuery(s2);
			
		    while(result.next()) {
		    	
		    	//Getting column names
				int num = result.getInt("Number");
				String food = result.getString("Food_Items");
				int quan = result.getInt("Quantity");
				int cal = result.getInt("Calories");
				System.out.println(" ");
				System.out.println("Your Order: ");
				
				//Printing field values
				System.out.println(num+"  "+food+" "+quan+" "+cal);				
			}					 
		}
			 System.out.println(" ");
			 //Compares the consumed calories with calorieNeeds
			if(temp<=calorieNeeds ) {					
					System.out.println("You consumed " + temp + " calories and stayed within your daily calorie limit");
					System.out.println(" ");
					System.out.println("That's great! If you wish to calculate more, please select the corresponding number or choose 10 to exit");
					System.out.println("");
		}		
			else {
			//Finds the difference between consumed calories and calorieNeeds
			diff = temp - calorieNeeds;
			System.out.println("Your exceeded your daily calorie limit by "+ diff);
			System.out.println(" ");
			System.out.println("If you wish to calculate more, please select the corresponding number or choose 10 to exit"); 
			System.out.println(" ");
		}	
			
		} while (foodNumber<10);//Do while ends here
		  con.close();
	}
		}
	
				
		
	
		

