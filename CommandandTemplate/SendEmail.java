package CS5800Final.CommandandTemplate;

public class SendEmail 
{
    private User user;

    public SendEmail(User user)
    {
        this.user = user;
    }

    public void execute()
    {
        user.sendEmail();
    }
}
