package testfinalproject;

import java.sql.SQLException;
//Libraries
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

//Creating a superclass that implements methods of the interface 
public class Implementation implements PrivateInfo {
			//Declaring a class variable
			String dayWeekText;
			
			//Creating private variables
			private String name;
			private int id;
	
	//Encapsulation
	public String getName() {
		return name;
			}
	public void setName(String name) {
		this.name = name;
			}
	public int getID() {
		return id;
			}
	public void setID(int id) {
		this.id = id;
			}

	//This method returns current date in string 
	public static String date() {
		
		//Outputs current date in yyyy-MM-dd format
		LocalDate date = LocalDate.now();
		
		//Converts date into String
		String dateString = date.toString();
		System.out.println(dateString);
		return dateString;		
	 }
	
	//This method returns day of the week in name
	public String dayAndDate() {
		
		//Initializes object with current Date 
		Date date=new Date();
		
		//getInstance() method returns the calendar using the current time zone
	    Calendar cal = Calendar.getInstance();
	    
	    //gets number of the day in a week
	    int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
	    
	   //EEEEE returns the day of the week in text
	    SimpleDateFormat dateFormat = new SimpleDateFormat("EEEEE");
	   
	    //converting and storing it in a string variable 
	    String dayWeekText =  dateFormat.format(date);	    
	     
	    System.out.println("Today is "+dayWeekText);
	    System.out.println("We are on day " + dayOfWeek + " of the week ");
	    return dayWeekText;
		}

	//The method outputs the number of days left before the membership expires
	public void membership() {
			
		System.out.println("Today is: ");
		
		//Gets date String from the date method
		String today = date();
		System.out.println(" ");
		
		//Created variables for each membership
		String gymExpDate = "2021-11-27";
		String skatingExpDate = "2021-10-29";
		String recreationExpDate = "2021-12-12";
		String tennisExpDate = "2022-01-12";
		 
		//LocalDate class represents a calendar date without time and timezone info
		//Parsing variables to return local dates
		LocalDate currentDate = LocalDate.parse(today);
		LocalDate gym = LocalDate.parse(gymExpDate);		
		LocalDate rec = LocalDate.parse(recreationExpDate);	
		LocalDate skating = LocalDate.parse(skatingExpDate);
		LocalDate tennis = LocalDate.parse(tennisExpDate);
		
		//Creating a scanner object
		Scanner scan = new Scanner(System.in);
		
		//Prompting user input
		System.out.println("Choose an option below to see how many days are left in your membership");
		System.out.println(" ");
		System.out.println("gym---->Gym Membership");
		System.out.println("skating ---->Skating Membership");
		System.out.println("rec---->Recreation Centre Membership");
		System.out.println("tennis---->Tennis Club Membership");
		System.out.println(" ");
		
		String option = scan.nextLine();
			//Calculates the days based on user input
			if(option.equals("gym")) {	
					long noOfDaysBetween = ChronoUnit.DAYS.between(currentDate, gym);		
					System.out.println("You have " + noOfDaysBetween+ " days left");
			}			
			else if(option.equals("skating")) {			
					long noOfDaysBetween = ChronoUnit.DAYS.between(currentDate, skating);
					System.out.println("You have " + noOfDaysBetween+" days left");
			}
			else if(option.equals("rec")) {			
					long noOfDaysBetween = ChronoUnit.DAYS.between(currentDate, rec);			
					System.out.println("You have " + noOfDaysBetween+" days left");
				}
			else if(option.equals("tennis")) {			
					long noOfDaysBetween = ChronoUnit.DAYS.between(currentDate, tennis);			
					System.out.println("You have " + noOfDaysBetween+" days left");
				}
			else 
			{
					System.out.println("Please enter a valid option");
			}
			
			}
	

	public void calorieCalculator() throws SQLException {
		System.out.println("This is a calorie calculator method");
	}

	
	public void workout() throws SQLException {
		System.out.println("This is a workout method");
		
	}
}		
		
		
