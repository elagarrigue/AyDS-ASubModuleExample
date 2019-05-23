package ayds.spotisong.aurora.song.model.repository.local;

import ayds.spotisong.aurora.song.model.Song;

public interface LocalDB {

  void saveSong(Song song);

  Song getSong(String name);
}
