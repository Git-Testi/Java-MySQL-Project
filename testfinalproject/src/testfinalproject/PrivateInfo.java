package testfinalproject;

import java.sql.SQLException;

//Creating an interface
public interface PrivateInfo {
	
	//abstract methods	
	//this method returns a string
	public String dayAndDate();		
	public void membership();	
	public void workout() throws SQLException;
	public void calorieCalculator() throws SQLException;
	
}
