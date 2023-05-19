package CS5800Final.CommandandTemplate;

public class SetReminder implements Command
{
    private ReminderSetter reminderSetter;
    private Reminder reminder;

    public SetReminder(ReminderSetter reminderSetter, Reminder reminder)
    {
        this.reminderSetter = reminderSetter;
        this.reminder = reminder;
    }

    public void execute()
    {
        reminderSetter.SetReminder(reminder);
    }
}
