package CS5800Final.CommandandTemplate;

public class MusicPlayer 
{
    public void playMusic(Music music)
    {
       System.out.println("Playing album: " + music.getAlbum() + " artist: " + music.getArtist() + " song: " + music.getName());
    }
}
