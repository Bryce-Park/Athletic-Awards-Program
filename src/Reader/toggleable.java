package Reader;

public class toggleable
{
    private String name;
    private boolean isThere;
    public toggleable()
    {
        name = "no input";
        isThere = false;
    }

    public toggleable(String inputName, boolean inputToggle)
    {
        name = inputName;
        isThere = inputToggle;
    }

    public void changeName(String inputName)
    {
        name = inputName;
    }

    public void setToggle(boolean inputToggle)
    {
        isThere = inputToggle;
    }

    public void toggle()
    {
        if(isThere == true)
        {
            isThere = false;
        }
        else
        {
            isThere = true;
        }
    }

    public String getName()
    {
        return name;
    }

    public boolean getToggle()
    {
        return isThere;
    }
}
