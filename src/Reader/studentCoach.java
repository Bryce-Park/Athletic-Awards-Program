package Reader;

//import java.io.Serializable;
import java.util.ArrayList;

public class studentCoach //implements Serializable
{
	//private static final long serialVersionUID = 9009336582624157865L;

	private int id;
	private int grade;
	private String firstName;
	private String lastName;
	private ArrayList<level> levels;
	private boolean ASB;
	private int years; //not sure if needed
	private double firstVal;
	private double lastVal;
	//no sport value due to students changing sports
	
	public studentCoach (int Iid, String IfirstName, String IlastName, int Igrade, boolean IASB)
	{
		id = Iid;
		grade = Igrade;
		firstName = IfirstName;
		lastName = IlastName;
		levels = new ArrayList<level>();
		ASB = IASB;
	}
	
	public studentCoach (int Iid, String IfirstName, String IlastName, int Igrade, ArrayList<level> Ilevels,boolean IASB, double IfirstVal, double IlastVal)
	{
		id = Iid;
		grade = Igrade;
		firstName = IfirstName;
		lastName = IlastName;
		levels = new ArrayList<level>();
		levels = Ilevels;
		ASB = IASB;
		firstVal = IfirstVal;
		lastVal = IlastVal;

	}
	
	public studentCoach(int Iid, String IfirstName, String IlastName, ArrayList<level> Ilevels, boolean IASB, double IfirstVal, double IlastVal)
	{
		id = Iid;
		grade = 0;
		firstName = IfirstName;
		lastName = IlastName;
		levels = new ArrayList<level>();
		levels = Ilevels;
		ASB = IASB;
		firstVal = IfirstVal;
		lastVal = IlastVal;

	}
	
	public studentCoach ()
	{
		id = 0;
		grade = 0;
		firstName = "0";
		lastName = "0";
		levels = new ArrayList<level>();
		ASB = false;
		firstVal = 0;
		lastVal = 0;
	}
	
	public int getId()
	{
		return id;
	}
	
	public int getGrade()
	{
		return grade;
	}
	
	public String getFirstName()
	{
		return firstName;
	}

	public String getLastName()
	{
		return lastName;
	}
	
	public void changeId(int replace)
	{
		id = replace;
	}
	
	public void changeGrade(int replace)
	{
		grade = replace;
	}
	
	public void changeFirstName(String replace)
	{
		firstName = replace;
	}

	public void changeLastName(String replace)
	{
		lastName = replace;
	}
	
	public void addLevel(level Ilevel)
	{
		levels.add(Ilevel);
	}
	
	public level getLevel(int Iindex)
	{
		return levels.get(Iindex);
	}
	
	public ArrayList<level> getLevels()
	{
		return levels;
	}
	
	public boolean getASB()
	{
		return ASB;
	}
	
	public double getFirstVal()
	{
		return firstVal;
	}
	
	public double getLastVal()
	{
		return lastVal;
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
