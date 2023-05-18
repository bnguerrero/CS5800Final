package CS5800Final.CommandandTemplate;

public class Music 
{
    public String name;
    public String artist;
    public String album;
    
    public Music(String name, String artist, String album)
    {
        this.name = name;
        this.artist = artist;
        this.album = album;
    }
    public String getName()
    {
        return name;
    }
    public String getArtist()
    {
        return artist;
    }
    public String getAlbum()
    {
        return album;
    }
}
