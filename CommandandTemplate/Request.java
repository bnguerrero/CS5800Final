package CS5800Final.CommandandTemplate;

public abstract class Request 
{
    boolean isValid = true;
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
    public void notifyUser(User user, Command command)
    {
        if (validateUserRequest())
        {
            System.out.println("Request fulfilled");
            logRequest();
            command.execute();
        }
        else
        {
            System.out.println("Unable to fulfill request");
        }
        
    }
}
