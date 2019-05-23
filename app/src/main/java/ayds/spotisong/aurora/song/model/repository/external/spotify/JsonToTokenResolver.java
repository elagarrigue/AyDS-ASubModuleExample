package ayds.spotisong.aurora.song.model.repository.external.spotify;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import ayds.spotisong.aurora.song.model.Song;

class JsonToTokenResolver implements SpotifyToTokenResolver {

  private final Gson gson = new Gson();

  @Override public String getTokenFromExternalData(String serviceData) {
    JsonObject tokenResp = gson.fromJson(serviceData, JsonObject.class);
    JsonElement accessToken = tokenResp.get("access_token");

    return accessToken.getAsString();
  }
}
