package CS5800Final.CommandandTemplate;

public class MakePhoneCall implements Command
{
    private User user;

    public MakePhoneCall(User user)
    {
        this.user = user;
    }

    @Override
    public void execute() 
    {
        user.makePhoneCall();
    }
    
}
