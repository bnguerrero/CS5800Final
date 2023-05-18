package CS5800Final.CommandandTemplate;

public class SetReminder implements Command
{
    private User user;
    private Reminder reminder;

    public SetReminder(User user, Reminder reminder)
    {
        this.user = user;
        this.reminder = reminder;
    }

    public void execute()
    {
        user.SetReminder(reminder);
    }
}
