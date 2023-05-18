package CS5800Final.CommandandTemplate;

import java.sql.Timestamp;

public class Reminder 
{
    public String content;
    public Timestamp time;
    
    public Reminder(String content, String timeStamp)
    {
        this.content = content;
        time = Timestamp.valueOf(timeStamp);
    }
    public String getContent()
    {
        return content;
    }
    public Timestamp geTimeStamp()
    {
        return time;
    }
}
