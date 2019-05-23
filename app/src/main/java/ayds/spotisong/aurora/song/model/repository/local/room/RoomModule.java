package ayds.spotisong.aurora.song.model.repository.local.room;

import android.content.Context;

import ayds.spotisong.aurora.song.model.repository.local.LocalDB;

public class RoomModule {

  private static RoomModule instance;

  private RoomModule() { }

  public static RoomModule getInstance() {
    if (instance == null) {
      instance = new RoomModule();
    }
    return instance;
  }

  public LocalDB getLocalDB(Context context) {
    return new RoomDB(context);
  }
}
