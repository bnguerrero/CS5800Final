package CS5800Final.CommandandTemplate;

public class User 
{
    public String name;
    public String phoneNumber;
    public String email;

    public User(String name, String phoneNumber, String email)
    {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public void makePhoneCall()
    {
        System.out.println(name + " making phone call ");
    }
    public void sendEmail()
    {
        System.out.println( email + " sending email");
    }
    public void playMusic(Music music)
    {
       System.out.println("Playing " + music.getName() +  " for " + name);
    }
    public void SetReminder(Reminder reminder)
    {
        System.out.println("Set reminder : " + reminder.content + " at: " + reminder.geTimeStamp());
    }
}
