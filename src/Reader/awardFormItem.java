package Reader;

public class awardFormItem 
{
	private String item;
	private boolean isValid;
	
	public awardFormItem(String name, boolean has)
	{
		item = name;
		isValid = has;
	}
	
	public awardFormItem(String name)
	{
		item = name;
		isValid = false;
	}
	
	public awardFormItem()
	{
		item = null;
		isValid = false;
	}
	
	public void setName(String name)
	{
		item = name;
	}
	
	public void setValid(boolean input)
	{
		isValid = input;
	}
	
	public String getItem()
	{
		return item;
	}
	
	public boolean isItValid()
	{
		return isValid;
	}
}
