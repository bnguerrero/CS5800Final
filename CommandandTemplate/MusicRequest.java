package CS5800Final.CommandandTemplate;

public class MusicRequest extends Request
{
    public void notifyUser(DigitalAssistant playMusic, User user, Music music)
    {
        if (validateUserRequest())
        {
            System.out.println("Play music request validated.");
        }
        else
        {
            System.out.println("Unable to fulfill play music request");
        }
    }
}
