package Reader;

import java.util.ArrayList;

public class alphabetizer {
	
	public alphabetizer()
	{
		
	}
	
	public double assignAlphVal (String input)
	{
		int x;
		double returner = 0;
		double temp = 10;
		for(int i = 0;i<input.length();i++)
		{
			if(input.substring(i, i+1).equals("a"))
			{
				x = 1;
			}
			if(input.substring(i, i+1).equals("b"))
			{
				x = 2;
			}
			if(input.substring(i, i+1).equals("c"))
			{
				x = 3;
			}
			if(input.substring(i, i+1).equals("d"))
			{
				x = 4;
			}
			if(input.substring(i, i+1).equals("e"))
			{
				x = 5;
			}
			if(input.substring(i, i+1).equals("f"))
			{
				x = 6;
			}
			if(input.substring(i, i+1).equals("g"))
			{
				x = 7;
			}
			if(input.substring(i, i+1).equals("h"))
			{
				x = 8;
			}
			if(input.substring(i, i+1).equals("i"))
			{
				x = 9;
			}
			if(input.substring(i, i+1).equals("j"))
			{
				x = 10;
			}
			if(input.substring(i, i+1).equals("k"))
			{
				x = 11;
			}
			if(input.substring(i, i+1).equals("l"))
			{
				x = 12;
			}
			if(input.substring(i, i+1).equals("m"))
			{
				x = 13;
			}
			if(input.substring(i, i+1).equals("n"))
			{
				x = 14;
			}
			if(input.substring(i, i+1).equals("o"))
			{
				x = 15;
			}
			if(input.substring(i, i+1).equals("p"))
			{
				x = 16;
			}
			if(input.substring(i, i+1).equals("q"))
			{
				x = 17;
			}
			if(input.substring(i, i+1).equals("r"))
			{
				x = 18;
			}
			if(input.substring(i, i+1).equals("s"))
			{
				x = 19;
			}
			if(input.substring(i, i+1).equals("t"))
			{
				x = 20;
			}
			if(input.substring(i, i+1).equals("u"))
			{
				x = 21;
			}
			if(input.substring(i, i+1).equals("v"))
			{
				x = 22;
			}
			if(input.substring(i, i+1).equals("w"))
			{
				x = 23;
			}
			if(input.substring(i, i+1).equals("x"))
			{
				x = 24;
			}
			if(input.substring(i, i+1).equals("y"))
			{
				x = 25;
			}
			if(input.substring(i, i+1).equals("z"))
			{
				x = 26;
			}
			else
			{
				x = (Integer) null;
				System.out.println("Please double check that "+ input + " only consists of letters");
			}
			
			for(int z=0;z<i;z++)
			{
				temp *= 0.01;
			}
			
			temp *= x;
			returner += x;
		}
		return returner;
	}

	public ArrayList<student> sortProvidedList(ArrayList<student> providedList) //probably has flaws
	{
		int n = providedList.size();
	    student temp = new student();
		
	    for (int c1 = 0; c1 < n; c1++) 
		{
	        for (int j = 1; j < (n - c1); j++) 
			{
	            if (providedList.get(j-1).getLastVal() > providedList.get(j).getLastVal()) 
				{
	                temp = providedList.get(j-1);
	                providedList.set(j - 1,providedList.get(j));
	                providedList.set(j,temp);
	            }

	            else if (providedList.get(j-1).getLastVal() == providedList.get(j).getLastVal()) 
				{
		            if (providedList.get(j-1).getFirstVal() > providedList.get(j).getFirstVal()) 
					{
		                temp = providedList.get(j-1);
		                providedList.set(j - 1,providedList.get(j));
		                providedList.set(j,temp);
		            }
	            }
	        }
	    }
	    
	    return providedList;
	}
}
