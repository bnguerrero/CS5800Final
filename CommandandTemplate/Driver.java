package CS5800Final.CommandandTemplate;

public class Driver 
{
    public static void main(String[] args) 
    {
        User bri = new User("bri", "911", "bnguerrero@cpp.edu");
        DigitalAssistant makePhoneCall = new DigitalAssistant();
        //DigitalAssistant sendEmail = new DigitalAssistant();
        //DigitalAssistant playMusic = new DigitalAssistant();
       // DigitalAssistant setReminder = new DigitalAssistant();
        
        PhoneCallRequest phoneCallRequest = new PhoneCallRequest();

        phoneCallRequest.notifyUser(makePhoneCall, bri);
       
        //makePhoneCall.invoke(new MakePhoneCall(bri));
        //sendEmail.invoke(new SendEmail(bri));
       // playMusic.invoke(new PlayMusic(bri, new Music("Song1", "Artist1", "Album1")));
        //setReminder.invoke(new SetReminder(bri, new Reminder("walk the dog", "2023-05-19 14:30:00")));
    }


}
