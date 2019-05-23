package ayds.spotisong.aurora.song.model.repository.external;

import ayds.spotisong.aurora.song.model.repository.external.spotify.SpotifyModule;

public class ExternalModule {

  private static ExternalModule instance;

  private ExternalModule() {
  }

  public static ExternalModule getInstance() {
    if (instance == null) {
      instance = new ExternalModule();
    }
    return instance;
  }

  public ExternalService getExternalService() {
    return SpotifyModule.getInstance().getExternalService();
  }
}
