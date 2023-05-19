package CS5800Final.CommandandTemplate;

public class PhoneCallRequest extends Request 
{
    public void notifyUser(DigitalAssistant makePhoneCall, User user)
    {
        if (validateUserRequest())
        {
            System.out.println("Phone call request validated.");
            logRequest();
            makePhoneCall.invoke(new MakePhoneCall(user));
        }
        else
        {
            System.out.println("Unable to fulfill phone call request");
        }
    }
        
}
