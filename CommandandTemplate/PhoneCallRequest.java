package CS5800Final.CommandandTemplate;

public class PhoneCallRequest extends Request 
{
    Command command;
    public void notifyUser(DigitalAssistant makePhoneCall, User user)
    {
        if (validateUserRequest())
        {
            System.out.println("Phone call request fulfilled");
            logRequest();
            makePhoneCall.invoke(new MakePhoneCall(user));
        }
        else
        {
            System.out.println("Unable to fulfill phone call request");
        }
    }
        
}
