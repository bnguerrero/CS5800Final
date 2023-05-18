package CS5800Final.CommandandTemplate;

public class SendEmail implements Command
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
