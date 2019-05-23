package ayds.spotisong.aurora.song.view;

import ayds.spotisong.aurora.song.presenter.SearchSongPresenter;

public interface SearchSongView {

  String getQuery();

  void setSongDescription(String description);

  void enableActionButtons();

  void disableActionButtons();

  void setSearchSongPresenter(SearchSongPresenter presenter);

  void openExternalUrl(String url);
}
