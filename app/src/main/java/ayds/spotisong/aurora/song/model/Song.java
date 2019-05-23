package ayds.spotisong.aurora.song.model;

public class Song {

  private String songName;
  private String artistName;
  private String albumName;
  private String url;

  public Song(String songName, String artistName, String albumName, String url) {
    this.songName = songName;
    this.artistName = artistName;
    this.albumName = albumName;
    this.url = url;
  }

  public void setSongName(String songName) {
    this.songName = songName;
  }

  public String getSongName() {
    return songName;
  }

  public String getArtistName() {
    return artistName;
  }

  public String getAlbumName() {
    return albumName;
  }

  public String getUrl() {
    return url;
  }
}
