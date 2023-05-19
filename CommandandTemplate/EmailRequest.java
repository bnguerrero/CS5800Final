package CS5800Final.CommandandTemplate;

public class EmailRequest extends Request
{
    public void notifyUser()
    {
        if (validateUserRequest())
        {
            System.out.println("Email request validated.");
        }
        else
        {
            System.out.println("Unable to fulfill email request");
        }
    }
}
