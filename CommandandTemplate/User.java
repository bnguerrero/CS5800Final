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
    public String getName()
    {
        return name;
    }
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    public String getEmail()
    {
        return email;
    }
}
