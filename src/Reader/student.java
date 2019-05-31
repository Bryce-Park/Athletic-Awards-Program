package Reader;

//import java.io.Serializable;
import java.io.IOException;
import java.util.ArrayList;

public class student //implements Serializable
{
	//private static final long serialVersionUID = 9009336582624157865L;

	private int id;
	private int grade; //
	private String firstName; //
	private String lastName; //
	private ArrayList<level> levels;
	private boolean ASB;
	private int years; //not sure if needed
	private double firstVal;
	private double lastVal;
	private String gender; //
	private boolean isHeader = false;
	private int repeat;
	//no sport value due to students changing sports
	
	public student (int Iid, String IfirstName, String IlastName, int Igrade, boolean IASB)
	{
		id = Iid;
		grade = Igrade;
		firstName = IfirstName;
		lastName = IlastName;
		levels = new ArrayList<level>();
		ASB = IASB;
		gender = "0";
	}
	
	public student (int Iid, String IfirstName, String IlastName, int Igrade, ArrayList<level> Ilevels,boolean IASB, double IfirstVal, double IlastVal)
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
		gender = "0";

	}
	
	public student(int Iid, String IfirstName, String IlastName, ArrayList<level> Ilevels, boolean IASB, double IfirstVal, double IlastVal)
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
		gender = "0";
	}
	
	public student (int Iid, String IlastName,String IfirstName, String Igender)
	{
		id = Iid;
		grade = 0;
		firstName = IfirstName;
		lastName = IlastName;
		levels = new ArrayList<level>();
		ASB = false;
		firstVal = 0;
		lastVal = 0;
		gender = Igender;
	}

	public student (ArrayList<String> input)
	{
		if(input.get(0).equals(" "))
		{
			input.remove(0);
		}


		for(int counter=0;counter<input.size();counter++)
		{
			//System.out.println("Input Test "+counter+": "+input.get(counter));
		}

		lastName = input.get(0);
		firstName = input.get(1);
		gender = input.get(2);
		System.out.println("Grade Test: "+input.get(3));
		grade = Integer.parseInt(input.get(3).substring(0,input.get(3).indexOf(".")));

		levels = new ArrayList<level>();
		int counter = 4;
		System.out.println("Begin Level Test");
		for(int tester=0;tester<input.size();tester++)
		{
			System.out.print(input.get(tester)+" ");
		}
		System.out.println();
		while(counter < input.size())
		{
			levels.add(new level(input.get(counter)));

			System.out.print(levels.get(counter-4).getLevel()+" ");

			counter++;

		}
		System.out.println("Level list size: "+ levels.size());
	}

	public void convertToHeader (ArrayList<String> input)
	{
		lastName = input.get(0);
		firstName = input.get(1);
		gender = input.get(2);
		grade = 0;

		levels = new ArrayList<level>();
		int counter = 4;
		while(counter < input.size())
		{
			levels.add(new level(input.get(counter)));
			counter++;
		}
		System.out.println("Level list size: "+ levels.size());
		isHeader = true;
	}
	
	public student ()
	{
		id = 0;
		grade = 0;
		firstName = "0";
		lastName = "0";
		levels = new ArrayList<level>();
		ASB = false;
		firstVal = 0;
		lastVal = 0;
		gender = "0";
	}

	public void inputRepeatCount(int repeatValue)
	{
		repeat = repeatValue;
	}

	public int getRepeat()
	{
		return repeat;
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
	
	public void addGender(String Igender)
	{
		gender = Igender;
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
	
	public String getGender()
	{
		return gender;
	}

	public String toString()
	{
		String output = new String();

		output = "grade: " + grade +" firstName: " + firstName + " lastName: " + lastName + " gender: " + gender;
		for(int counter = 0; counter<levels.size();counter++)
		{
			output = output + " L: " + levels.get(counter).getLevel();
		}
		return output;

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
