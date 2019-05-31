package Reader;

import java.util.ArrayList;

public class sportLevel
{
    private String name;
    private ArrayList<toggleable> toggleableList;

    public sportLevel()
    {
        name = "no input";
        toggleableList = new ArrayList<toggleable>();
    }

    public sportLevel(String inputName, ArrayList<toggleable> inputList)
    {
        name = inputName;
        toggleableList = inputList;
    }

    public void setName(String inputName)
    {
        name = inputName;
    }

    public void setToggleableList(ArrayList<toggleable> inputList)
    {
        toggleableList = inputList;
    }

    public String getName() {
        return name;
    }

    public ArrayList<toggleable> getToggleableList() {
        return toggleableList;
    }
}
