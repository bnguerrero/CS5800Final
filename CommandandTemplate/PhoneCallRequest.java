package CS5800Final.CommandandTemplate;


public class PhoneCallRequest extends Request 
{

    public void processing()
    {
        validateUserRequest();
        logRequest();
        notifyUser();
    }

    public void notifyUser()
    {
        if (validateUserRequest())
        {
            System.out.println("Phone call request validated.");
        }
        else
        {
            System.out.println("Unable to fulfill phone call request");
        }
    }
        
}
