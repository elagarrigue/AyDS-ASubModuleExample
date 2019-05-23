package ayds.spotisong.aurora.song.model.repository.local.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {SongEntity.class}, version = 1)
public abstract class SongDataBase extends RoomDatabase {
  public abstract SongDao songDao();
}
