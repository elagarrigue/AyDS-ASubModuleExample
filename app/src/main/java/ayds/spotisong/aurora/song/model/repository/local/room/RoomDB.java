package ayds.spotisong.aurora.song.model.repository.local.room;

import android.arch.persistence.room.Room;
import android.content.Context;

import ayds.spotisong.aurora.song.model.Song;
import ayds.spotisong.aurora.song.model.repository.local.LocalDB;

class RoomDB implements LocalDB {

  private SongDataBase db;

  RoomDB(Context context) {
    db = Room.databaseBuilder(context, SongDataBase.class, "songs.db").build();
  }

  @Override public void saveSong(Song song) {
    SongEntity entity = new SongEntity();
    entity.setName(song.getSongName());
    entity.setAlbum(song.getAlbumName());
    entity.setArtist(song.getArtistName());
    entity.setUrl(song.getUrl());
    db.songDao().insert(entity);
  }

  @Override public Song getSong(String name) {
    SongEntity entity = db.songDao().findByName(name);
    if (entity != null) {
      return new Song(entity.getName(), entity.getArtist(), entity.getAlbum(), entity.getUrl());
    }
    return null;
  }
}