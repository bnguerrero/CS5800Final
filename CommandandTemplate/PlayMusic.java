package CS5800Final.CommandandTemplate;

public class PlayMusic 
{
    private User user;
    private Music music;

    public PlayMusic(User user, Music music)
    {
        this.user = user;
        this.music = music;
    }

    public void execute()
    {
        user.playMusic(music);
    }

}
