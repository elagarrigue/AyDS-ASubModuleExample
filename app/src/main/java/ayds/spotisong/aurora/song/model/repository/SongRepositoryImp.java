package ayds.spotisong.aurora.song.model.repository;

import ayds.spotisong.aurora.song.model.Song;
import ayds.spotisong.aurora.song.model.repository.external.ExternalService;
import ayds.spotisong.aurora.song.model.repository.local.LocalDB;

class SongRepositoryImp implements SongRepository {

  final private ExternalService externalService;
  final private LocalDB localDB;

  private Song lastSong;

  SongRepositoryImp(ExternalService externalService, LocalDB localDB) {
    this.externalService = externalService;
    this.localDB = localDB;
  }

  @Override
  public void searchSong(String query, SearchSongListener listener, SearchSongErrorListener errorListener){
    new Thread(() -> {
      try {
        Song song = localDB.getSong(query);

        if (song != null) {
          song.setSongName("[*] " + song.getSongName());
        } else {
          song = externalService.getSong(query);
          localDB.saveSong(song);
        }

        lastSong = song;

        listener.onSongFound(song);
      } catch (Exception e) {
        errorListener.onError(e);
      }
    }).start();
  }

  @Override
  public Song lastSongFound() {
    return lastSong;
  }
}
