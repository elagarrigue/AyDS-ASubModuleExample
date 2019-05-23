package ayds.spotisong.aurora.song.model.repository;

import android.content.Context;

import ayds.spotisong.aurora.song.model.repository.external.ExternalModule;
import ayds.spotisong.aurora.song.model.repository.local.LocalModule;

public class RepositoryModule {

  private static RepositoryModule instance;

  private RepositoryModule() { }

  public static RepositoryModule getInstance() {
    if (instance == null) {
      instance = new RepositoryModule();
    }
    return instance;
  }

  public SongRepository getSongRepository(Context context) {
    return new SongRepositoryImp(
        ExternalModule.getInstance().getExternalService(),
        LocalModule.getInstance().getLocalDB(context)
    );
  }
}
