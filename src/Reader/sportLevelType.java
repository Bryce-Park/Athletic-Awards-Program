package Reader;

public class sportLevelType
{
    private int identity;
    private String identityName;

    public sportLevelType()
    {
        identity = -1;
        determineName();
    }

    public sportLevelType(int input)
    {
        identity = input;
        determineName();
    }

    public void inputNewIdentity(int input)
    {
        identity = input;
        determineName();
    }

    private void determineName()
    {
        if(identity == 0)
        {
            identityName = "frosh";
        }
        else if(identity == 1)
        {
            identityName = "froshJv";
        }
        else if (identity == 2)
        {
            identityName = "froshSoph";
        }
        else if (identity == 3)
        {
            identityName = "jv";
        }
        else if (identity == 4)
        {
            identityName = "varsity";
        }
        else
        {
            identityName = "Effor: invalid input";
        }
    }

    public int getIdentity()
    {
        return identity;
    }

    public String getIdentityName()
    {
        return identityName;
    }



}
