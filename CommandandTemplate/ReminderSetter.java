package CS5800Final.CommandandTemplate;

public class ReminderSetter 
{
    public void SetReminder(Reminder reminder)
    {
        System.out.println("Set reminder : " + reminder.content + " at: " + reminder.geTimeStamp());
    }
}
