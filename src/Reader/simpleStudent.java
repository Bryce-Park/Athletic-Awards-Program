package Reader;

//import java.io.Serializable;
import java.util.ArrayList;

public class simpleStudent //implements Serializable
{
	//private static final long serialVersionUID = 9009336582624157865L;

	private int id;
	private int grade;
	private String firstName;
	private String lastName;
	private int years; //not sure if needed
	private String gender;
	private int gpa;
	//no sport value due to students changing sports
	
	public simpleStudent (int Iid, String IlastName, String IfirstName)
	{
		id = Iid;
		firstName = IfirstName;
		lastName = IlastName;
		
		grade = 0;
		years = 0;
		gpa = 0;
		gender = "0";
	}
	
	public simpleStudent (int Iid, String IlastName, String IfirstName, String Igender, int Igrade)
	{
		id = Iid;
		firstName = IfirstName;
		lastName = IlastName;
		gender = Igender;
		grade = Igrade;
		
		years = 0;
		gpa = 0;
	}
	
	public simpleStudent (int Iid, String IlastName, String IfirstName, int Igpa)
	{
		id = Iid;
		firstName = IfirstName;
		lastName = IlastName;
		gpa = Igpa;
		
		grade = 0;
		years = 0;
		gender = "0";
	}
	
	public simpleStudent ()
	{
		id = 0;
		firstName = "<BLANK>";
		lastName = "<BLANK>";
		
		grade = 0;
		years = 0;
		gpa = 0;
		gender = "<BLANK>";
	}
	
	
	public void addGender(String Igender)
	{
		gender = Igender;
	}
	
	public void addGPA (int Igpa)
	{
		gpa = Igpa;
	}
	
	public void addGrade (int Igrade)
	{
		grade = Igrade;
	}
	
	
	public int getId ()
	{
		return id;
	}
	
	public String getFirstName ()
	{
		return firstName;
	}
	
	public String getLastName ()
	{
		return lastName;
	}
	
	public int getGrade()
	{
		return grade;
	}
	
	
	

	/*
	public String toString()
	{
		String returner = id + " " + lastName + " " + firstName + " ";
		if(wasPresent.size()==0)
		{
			System.out.println("Nothing in date list");
		}
		for(int counter=0;counter<wasPresent.size();counter++)
		{
			returner = returner + "(" + wasPresent.get(counter).getDate()+" "+wasPresent.get(counter).getWasPresent()+") ";
		}
		return returner;
	}
	*/
}
