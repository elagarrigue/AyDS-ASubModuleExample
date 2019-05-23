package ayds.spotisong.aurora.song.presenter;

import ayds.spotisong.aurora.song.model.Song;

public interface SearchSongPresenter {

  void onSongSearch();

  void onOpenUrl();

  void onSongFound(Song song);

  void onError(Exception e);

  void onDestroy();
}
