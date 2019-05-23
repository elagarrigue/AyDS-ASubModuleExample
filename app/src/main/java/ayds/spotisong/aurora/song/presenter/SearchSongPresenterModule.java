package ayds.spotisong.aurora.song.presenter;

import android.content.Context;

import ayds.spotisong.aurora.song.model.SearchSongModel;
import ayds.spotisong.aurora.song.model.SearchSongModelModule;
import ayds.spotisong.aurora.song.view.SearchSongView;
import ayds.spotisong.aurora.song.view.SearchSongViewModule;

public class SearchSongPresenterModule {

  private static SearchSongPresenterModule instance;

  private SearchSongPresenterModule() { }

  public static SearchSongPresenterModule getInstance() {
    if (instance == null) {
      instance = new SearchSongPresenterModule();
    }
    return instance;
  }

  public SearchSongPresenter getSearchSongPresenter(SearchSongView view, Context context) {
    SearchSongPresenterImp presenter = new SearchSongPresenterImp();
    SearchSongModel model = SearchSongModelModule.getInstance().getSearchSongModel(presenter, context);
    presenter.setView(view);
    presenter.setModel(model);
    return presenter;
  }
}
