package CS5800Final.CommandandTemplate;

public class PlayMusic implements Command
{
    private MusicPlayer musicPlayer;
    private Music music;

    public PlayMusic(MusicPlayer musicPlayer, Music music)
    {
        this.musicPlayer = musicPlayer;
        this.music = music;
    }

    public void execute()
    {
        musicPlayer.playMusic(music);
    }

}
