package CS5800Final.CommandandTemplate;

public abstract class Request 
{
    boolean isValid = true;

    public void processing()
    {
        validateUserRequest();
        logRequest();
        notifyUser();
    }

    public boolean validateUserRequest()
    {
        if (!isValid) 
        {
            System.out.println("Invalid user input.");
        }
        return isValid;
    }
    public void logRequest()
    {
        System.out.println("logged request.");
    }
    public void notifyUser()
    {
        if (validateUserRequest())
        {
            System.out.println("Request fulfilled");
        }
        else
        {
            System.out.println("Unable to fulfill request");
        }
        
    }

}
