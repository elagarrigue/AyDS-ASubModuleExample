package ayds.spotisong.aurora.song.model.repository.local.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface SongDao {

  @Query("SELECT * FROM SongEntity")
  List<SongEntity> getAll();

  @Query("SELECT * FROM SongEntity WHERE name LIKE :name LIMIT 1")
  SongEntity findByName(String name);

  @Insert(onConflict = REPLACE)
  void insert(SongEntity songEntity);
}
