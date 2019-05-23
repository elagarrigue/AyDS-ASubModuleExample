package ayds.spotisong.aurora.song.model;

import ayds.spotisong.aurora.song.model.repository.SongRepository;
import ayds.spotisong.aurora.song.presenter.SearchSongPresenter;

class SearchSongModelImp implements SearchSongModel {

  final private SongRepository repository;
  final private SearchSongPresenter presenter;
  final private SongDescriptionFormatter songDescriptionFormatter;

  SearchSongModelImp(SongRepository repository, SearchSongPresenter presenter, SongDescriptionFormatter songDescriptionFormatter) {
    this.repository = repository;
    this.presenter = presenter;
    this.songDescriptionFormatter = songDescriptionFormatter;
  }

  @Override
  public void searchSong(String query) {
    repository.searchSong(query, presenter::onSongFound, presenter::onError);
  }

  @Override
  public Song lastSongFound() {
    return repository.lastSongFound();
  }

  @Override
  public String getSongDescription(Song song) {
    return songDescriptionFormatter.getSongDescription(song);
  }
}
