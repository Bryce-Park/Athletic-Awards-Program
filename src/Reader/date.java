package Reader;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.Serializable;


public class date implements Serializable
{
	private static final long serialVersionUID = -5358202220484275350L;
	private String pastDate;
	private String presentDate;
	private int wasPresent;
	private int processed;

	public date(int isPresent)
	{
		wasPresent = isPresent;
		
		String pattern = "MMddyyyy";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        pastDate = format.format(new Date());
        this.reformatInputDate();
	}
	
	public date(int isPresent, String thatDate)
	{
		wasPresent = isPresent;
		pastDate = thatDate;
		boolean hasUnneededZero = true;
		String tempDate;
		
		if(pastDate.indexOf("/")>0)
		{
			if((Integer.parseInt(pastDate.substring(0,pastDate.indexOf("/")))<10)
					&& pastDate.substring(0,1).equals("0"))
			{
				pastDate = pastDate.substring(1,pastDate.length());
				hasUnneededZero = false;
			}
			tempDate = pastDate.substring(pastDate.indexOf("/")+1,pastDate.length());
			if((Integer.parseInt(tempDate.substring(0,tempDate.indexOf("/")))<10)
					&& tempDate.substring(0,1).equals("0"))
			{
				tempDate = tempDate.substring(1,tempDate.length());
				hasUnneededZero = false;
			}
			pastDate = pastDate.substring(0,pastDate.indexOf("/")+1) + tempDate;
		}
	}
	
	public void setDate(String Idate)
	{
		pastDate = Idate;
		reformatInputDate();
	}
	
	private void reformatInputDate()
	{		
		String temp = pastDate.substring(4,8) + pastDate.substring(0,4);
		processed = Integer.parseInt(temp);
		pastDate = pastDate.substring(0, 2)+"/"+pastDate.substring(2,4)+"/"+pastDate.substring(4,pastDate.length());
		
		if(pastDate.substring(0,1).equals("0"))
		{
			pastDate = pastDate.substring(1,pastDate.length());
		
			if(pastDate.substring(2,3).equals("0"))
			{
				pastDate = pastDate.substring(0,2)+pastDate.substring(3,pastDate.length());
			}
		}
		else
		{
			if(pastDate.substring(3,4).equals("0"))
			{
				pastDate = pastDate.substring(0,3)+pastDate.substring(4,pastDate.length());
			}
		}
	}
	
	public String getDate ()
	{
		return pastDate;
	}
	
	public int getWasPresent()
	{
		return wasPresent;
	}
	
	public int getValue()
	{
		return processed;
	}
}
