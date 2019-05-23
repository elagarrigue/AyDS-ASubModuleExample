package ayds.spotisong.aurora.song.model.repository.external.spotify;

import ayds.spotisong.aurora.song.model.Song;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

class JsonToSongResolver implements SpotifyToSongResolver {

  private final Gson gson = new Gson();

  @Override
  public Song getSongFromExternalData(String serviceData) throws Exception {
    try {
      JsonObject jobj = gson.fromJson(serviceData, JsonObject.class);
      JsonObject tracks = jobj.get("tracks").getAsJsonObject();
      JsonArray items = tracks.get("items").getAsJsonArray();
      JsonObject item = items.get(0).getAsJsonObject();

      JsonObject album = item.get("album").getAsJsonObject();
      String albumName = album.get("name").getAsString();

      JsonObject artist = item.get("artists").getAsJsonArray().get(0).getAsJsonObject();
      String artistName = artist.get("name").getAsString();

      JsonObject externalUrl = item.get("external_urls").getAsJsonObject();
      String url = externalUrl.get("spotify").getAsString();

      String songName = item.get("name").getAsString();

      return new Song(songName, artistName, albumName, url);
    } catch (Exception e) {
      throw new Exception("No results");
    }
  }
}
