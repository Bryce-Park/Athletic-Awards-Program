package Reader;

import java.util.ArrayList;
//import java.io.Serializable;


public class header //implements Serializable 
{
	/**
	 * 
	 */
	//private static final long serialVersionUID = 4822139227948683121L;
	private String id;
	private String firstName;
	private String lastName;
	private ArrayList<level> levels;
	
	public header(String Iid, String IfirstName, String IlastName, ArrayList<level> Ilevels)
	{
		id = Iid;
		firstName = IfirstName;
		lastName = IlastName;
		levels = Ilevels;
	}
	public header(ArrayList<level> Ilevels)
	{
		id = "ID Number";
		firstName = "First Name";
		lastName = "Last Name";
		levels = Ilevels;
	}
	public header()
	{
		id = "ID Number";
		firstName = "First Name";
		lastName = "Last Name";
		levels = new ArrayList<level>();
	}
	
	public void sortDateList()
	{
		int n = levels.size();
	    level temp;
		
	    for (int c1 = 0; c1 < n; c1++) 
		{
	        for (int j = 1; j < (n - c1); j++) 
			{
	            if (levels.get(j-1).getYear() > levels.get(j).getYear()) 
				{
	                temp = levels.get(j-1);
	                levels.set(j - 1,levels.get(j));
	                levels.set(j,temp);
	            }
	        }
	    }
	}
	
	public void addNewLevelList(ArrayList<level> newLevelList)
	{
		levels = newLevelList;
	}
	
	public void addToLevelList(level ILevel)
	{
		levels.add(ILevel);
	}
	
	public String getId()
	{
		return id;
	}
	public String getLastName()
	{
		return lastName;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public ArrayList<level> getLevelList()
	{
		return levels;
	}
	public String toString()
	{
		String returner = id+" "+lastName+" "+firstName+" ";
		for(int counter=0;counter<levels.size();counter++)
		{
			returner = returner+" "+levels.get(counter).getYear()+" ";
		}
		return returner;
	}
}
