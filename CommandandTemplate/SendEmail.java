package CS5800Final.CommandandTemplate;

public class SendEmail implements Command
{
    private User user;
    private EmailSender emailSender;

    public SendEmail(EmailSender emailSender, User user)
    {
        this.user = user;
        this.emailSender = emailSender;
    }

    public void execute()
    {
        emailSender.sendEmail(user);
    }
}
