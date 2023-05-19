package CS5800Final.CommandandTemplate;

public class MakePhoneCall implements Command
{
    private PhoneDialer phoneDialer;
    private User user;

    public MakePhoneCall(PhoneDialer phoneDialer, User user)
    {
        this.phoneDialer = phoneDialer;
        this.user = user;
    }

    @Override
    public void execute() 
    {
        phoneDialer.makePhoneCall(user);
    }
    
}
