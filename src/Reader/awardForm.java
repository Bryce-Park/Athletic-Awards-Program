package Reader;

import java.util.ArrayList;


public class awardForm 
{
	private ArrayList<awardFormItem> contents;
	private String sportName;
	private String sportLevel;
	private student localStudent;
	private int season;
	
	public awardForm(student inputStudent, int inputSeason)
	{
		localStudent = inputStudent;
		season = inputSeason;
		findRepeatCount(localStudent.getLevels());
		createContents(localStudent);
	}
	
	public awardForm()
	{
		sportName = "Temporary";
		sportLevel = "Temporary";
		contents = new ArrayList<awardFormItem>();
	}

	private void findRepeatCount(ArrayList<level> inputLevels)
	{
		int tracker = 0;

		System.out.println("Begin findRepeatCount test");
		System.out.print(localStudent.getLastName()+" "+localStudent.getFirstName()+": ");
		for(int counter=0;counter<inputLevels.size();counter++)
		{
			System.out.print(inputLevels.get(counter).getLevel()+" ");
		}

		System.out.println("Error Test Target Sport/Level: "+ inputLevels.get(season).getLevel());
		String referenceLevel = inputLevels.get(season).getLevel();
		if(referenceLevel.contains("MGR"))
		{
			//inputLevels.set(season,new level(inputLevels.get(season).getLevel().substring(0,inputLevels.get(season).getLevel().indexOf("MGR")))); //TODO check if working
			referenceLevel = inputLevels.get(season).getLevel().substring(0,inputLevels.get(season).getLevel().indexOf("MGR"));
			System.out.println("MGR Test: "+referenceLevel);
		}

		for(int counter=0;counter<inputLevels.size();counter++)
		{
			System.out.println("findRepeatCount Test: "+inputLevels.get(counter).getLevel());
			if(inputLevels.get(counter).getLevel().equals(referenceLevel)||inputLevels.get(counter).getLevel().equals(inputLevels.get(season).getLevel()))
			{
				tracker++;
				//studentList.get(cA).inputRepeatCount(tracker);
			}
		}
		System.out.println("tracker test: "+tracker);
		localStudent.inputRepeatCount(tracker);

	}

	private void createContents(student inputStudent)
	{
		//specific case only
		//test sample (45, Allaahverdian Artin, XC/V)
		contents = new ArrayList<awardFormItem>();
		String currentSportLevel = inputStudent.getLevels().get(season).getLevel();
		System.out.println(inputStudent);
		System.out.println("CurrentSportLevel Test: "+currentSportLevel);
		System.out.println("Season Number: "+season);
		String currentLevel = currentSportLevel.substring(currentSportLevel.indexOf("/")+1,currentSportLevel.indexOf("/")+2);
		sportLevel = currentLevel;
		//String currentLevel = currentSportLevel.substring(currentSportLevel.indexOf("/")+1,currentSportLevel.length());
		String currentSport = currentSportLevel.substring(0,currentSportLevel.indexOf("/"));

		System.out.println("Sport Test: "+currentSport);

		System.out.println("Test Ping: "+currentLevel);
		if(currentLevel.equals("V"))
		{
			System.out.println("Varsity Test Ping");
			contents = createVarsityList(inputStudent);
		}
		else if(currentLevel.equals("J"))
		{
			System.out.println("Award Form JV Test Ping: 1");
			contents = createJuniorVarsityList(inputStudent);
		}
		else if(currentLevel.equals("F"))
		{
			ArrayList<String> froshSophSports = new ArrayList<>();
			froshSophSports =  createFroshSophSportList();
			boolean isFS = false;

			for(int counter=0;counter<froshSophSports.size();counter++)
			{
				if(currentSport.equals(froshSophSports.get(counter)))
				{
					isFS = true;
				}
			}

			if(!isFS) //TODO write code to determine whether to use Frosh or FroshSoph. (Maybe ask for redesign) 3/4/19
			{
				contents = createFroshList(inputStudent);
			}
			else
			{
				contents = createFroshSophList(inputStudent,"F");
			}
		}
		else if(currentLevel.equals("S"))
		{
			contents = createFroshSophList(inputStudent,"S");
		}
	}

	private ArrayList<awardFormItem> createVarsityList(student inputStudent)
	{
		ArrayList<awardFormItem> output = new ArrayList<>();
		int repeatCount = inputStudent.getRepeat();
		String currentSportLevel = inputStudent.getLevels().get(season).getLevel();

		output.add(new awardFormItem("CV"));
		output.add(new awardFormItem("CERT"));
		output.add(new awardFormItem("E"));
		output.add(new awardFormItem("C2"));
		output.add(new awardFormItem("C3"));
		output.add(new awardFormItem("C4"));
		output.add(new awardFormItem("MGR"));


		if(repeatCount==1)
		{
			output.get(0).setValid(true);
			output.get(1).setValid(true);
			output.get(2).setValid(true);
		}
		else if(repeatCount==2)
		{
			output.get(3).setValid(true);
		}
		else if(repeatCount==3)
		{
			output.get(4).setValid(true);
		}
		else if(repeatCount==4)
		{
			output.get(5).setValid(true);
		}
		else
		{
			System.out.println("Error: Student doesn't have corresponding sport/level");
		}

		if(currentSportLevel.indexOf("MGR")>-1)
		{
			output.get(6).setValid(true);
		}



		return output;
	}

	private ArrayList<awardFormItem> createJuniorVarsityList(student inputStudent)
	{
		System.out.println("Award Form JV Test Ping: 2");
	ArrayList<awardFormItem> output = new ArrayList<>();
	int repeatCount = inputStudent.getRepeat();
	String currentSportLevel = inputStudent.getLevels().get(season).getLevel();

	output.add(new awardFormItem("C"));
		output.add(new awardFormItem("CERT"));
		output.add(new awardFormItem("E"));
		output.add(new awardFormItem("C1"));
		output.add(new awardFormItem("C2"));
		output.add(new awardFormItem("C3"));
		output.add(new awardFormItem("JV"));

		System.out.println("Award Form JV Test Ping: Output test");
		for(int counter=0;counter<output.size();counter++)
		{
			System.out.print(output.get(counter).getItem());
		}

	if(repeatCount==1)
	{
		output.get(0).setValid(true);
		output.get(1).setValid(true);
		output.get(2).setValid(true);
		output.get(3).setValid(true);
		output.get(6).setValid(true);
	}
	else if(repeatCount==2)
	{
		output.get(4).setValid(true);
	}
	else if(repeatCount==3)
	{
		output.get(5).setValid(true);
	}
	else
	{
		System.out.println("Error: Student doesn't have corresponding sport/level");
	}

	return output;
	}

	private ArrayList<awardFormItem> createFroshList(student inputStudent)
	{
		ArrayList<awardFormItem> output = new ArrayList<>();
		int repeatCount = inputStudent.getRepeat();
		String currentSportLevel = inputStudent.getLevels().get(season).getLevel();

		output.add(new awardFormItem("C"));
		output.add(new awardFormItem("CERT"));
		output.add(new awardFormItem("E"));
		output.add(new awardFormItem("FROSH"));

		if(repeatCount==1)
		{
			output.get(0).setValid(true);
			output.get(1).setValid(true);
			output.get(2).setValid(true);
			output.get(3).setValid(true);
		}
		else
		{
			System.out.println("Error: Student doesn't have corresponding sport/level");
		}

		return output;
	}

	private ArrayList<awardFormItem> createFroshSophList(student inputStudent, String levelInput)
	{
		ArrayList<awardFormItem> output = new ArrayList<>();
		int repeatCount = inputStudent.getRepeat();
		String currentSportLevel = inputStudent.getLevels().get(season).getLevel();

		output.add(new awardFormItem("C"));
		output.add(new awardFormItem("CERT"));
		output.add(new awardFormItem("E"));
		output.add(new awardFormItem("FROSH"));
		output.add(new awardFormItem("C2"));
		output.add(new awardFormItem("SOPH"));

		if(levelInput.equals("F"))
		{
			output.get(0).setValid(true);
			output.get(1).setValid(true);
			output.get(2).setValid(true);
			output.get(3).setValid(true);
		}
		else if(levelInput.equals("S"))
		{
			output.get(4).setValid(true);
			output.get(5).setValid(true);
		}
		else
		{
			System.out.println("Error: Student doesn't have corresponding sport/level");
		}

		return output;
	}

	private ArrayList<String> createFroshSophSportList()
	{
		ArrayList<String> output = new ArrayList<>();
		output.add("BB");
		output.add("SC");
		output.add("TR");
		output.add("XC");

		return output;
	}
	
	public void addContents(ArrayList<awardFormItem> Icontents)
	{
		contents = Icontents;
	}

	public String getName()
	{
		return sportName;
	}
	
	public String getLevel()
	{
		return sportLevel;
	}



	public student getStudent ()
	{
		return localStudent;
	}
	
	public ArrayList<awardFormItem> getContents()
	{
		return contents;
	}

	public String toString()
	{
		String output;

		output = "Name: "+localStudent.getFirstName()+" "+localStudent.getLastName()+" ";
		for(int counter = 0; counter<contents.size();counter++)
		{
			output = output +"I: "+contents.get(counter).getItem()+" ";
			if(contents.get(counter).isItValid())
			{
				output = output+"T ";
			}
			else
			{
				output = output+"F ";
			}
		}

		return output;
	}
	
	

}
