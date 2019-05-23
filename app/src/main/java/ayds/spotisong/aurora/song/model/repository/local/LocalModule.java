package ayds.spotisong.aurora.song.model.repository.local;

import android.content.Context;

import ayds.spotisong.aurora.song.model.repository.local.room.RoomModule;

public class LocalModule {

  private static LocalModule instance;

  private LocalModule() { }

  public static LocalModule getInstance() {
    if (instance == null) {
      instance = new LocalModule();
    }
    return instance;
  }

  public LocalDB getLocalDB(Context context) {
    return RoomModule.getInstance().getLocalDB(context);
  }
}
