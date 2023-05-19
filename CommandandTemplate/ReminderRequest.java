package CS5800Final.CommandandTemplate;

public class ReminderRequest extends Request
{
    public void notifyUser(DigitalAssistant playMusic, User user, Music music)
    {
        if (validateUserRequest())
        {
            System.out.println("Reminder request validated.");
        }
        else
        {
            System.out.println("Unable to fulfill reminder request");
        }
    }
}
