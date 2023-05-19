package CS5800Final.CommandandTemplate;

public class Driver 
{
     // recievers
     private static PhoneDialer phoneDialer = new PhoneDialer();
     private static EmailSender emailSender = new EmailSender();
     private static MusicPlayer musicPlayer = new MusicPlayer();
     private static ReminderSetter reminderSetter = new ReminderSetter();
    public static void main(String[] args) 
    {
        User bri = new User("bri", "911", "bnguerrero@cpp.edu");
        
        DigitalAssistant makePhoneCall = new DigitalAssistant();
        DigitalAssistant sendEmail = new DigitalAssistant();
        DigitalAssistant playMusic = new DigitalAssistant();
        DigitalAssistant setReminder = new DigitalAssistant();

        PhoneCallRequest phoneCallRequest = new PhoneCallRequest();
        EmailRequest emailRequest = new EmailRequest();
        MusicRequest musicRequest = new MusicRequest();
        ReminderRequest reminderRequest = new ReminderRequest();
        
        phoneCallRequest.processing();
        makePhoneCall.invoke(new MakePhoneCall(phoneDialer, bri));

        emailRequest.processing();
        sendEmail.invoke(new SendEmail(emailSender, bri));

        musicRequest.processing();
        playMusic.invoke(new PlayMusic(musicPlayer, new Music("Song1", "Artist1", "Album1")));

        reminderRequest.processing();
        setReminder.invoke(new SetReminder(reminderSetter, new Reminder("walk the dog", "2023-05-19 14:30:00")));
    }
}
