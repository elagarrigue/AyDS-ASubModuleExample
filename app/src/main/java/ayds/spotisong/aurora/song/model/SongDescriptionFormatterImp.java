package ayds.spotisong.aurora.song.model;

class SongDescriptionFormatterImp implements SongDescriptionFormatter {

  @Override
  public String getSongDescription(Song song) {
    return "Song: " + song.getSongName() + ".\n" +
            "Artist: " + song.getArtistName() + ".\n" +
            "Album: " + song.getAlbumName() + ".\n";
  }
}
