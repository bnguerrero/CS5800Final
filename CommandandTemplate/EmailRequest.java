package CS5800Final.CommandandTemplate;

public class EmailRequest extends Request
{
    public void notifyUser(DigitalAssistant sendEmail, User user)
    {
        if (validateUserRequest())
        {
            System.out.println("Email request validated.");
            logRequest();
            sendEmail.invoke(new SendEmail(null, user));
        }
        else
        {
            System.out.println("Unable to fulfill email request");
        }
    }
}
