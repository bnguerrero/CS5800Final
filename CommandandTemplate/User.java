package CS5800Final.CommandandTemplate;

public class User 
{
    public String name;
    public String phoneNumber;
    public String email;
    public Music music;

    public User(String name, String phoneNumber, String email)
    {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public void makePhoneCall()
    {
        System.out.println("Making phone call for " + name);
    }
    public void sendEmail()
    {
        System.out.println("Sending email for "+ name);
    }
    public void playMusic(Music music)
    {
       System.out.println("Playing" + music.getName() +  "for " + name);
    }
}
