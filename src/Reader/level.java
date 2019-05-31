package Reader;

public class level 
{
	private int year;
	private String Level;
	private String team;
	private String original;
	
	public level(int Iyear, String ILevel, String Iteam)
	{
		year = Iyear;
		Level = ILevel;
		team = Iteam;
	}

	public level(String input, int inputYear)
	{
		year = inputYear;
		original = input;
	}

	public level(String ILevel)
	{
		Level = ILevel;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public String getLevel()
	{
		return Level;
	}
	
	public String getTeam()
	{
		return team;
	}

	public String getOriginal()
	{
		return original;
	}
}
