package ayds.spotisong.aurora.song.model.repository.external.spotify;


import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.*;

interface SpotifyAPI {

  @POST("token")
  Call<String> getToken(@Header("Authorization") String credential, @Body RequestBody tokenRequest);

  @GET("search?type=track")
  Call<String> getTrackInfo(@Header("Authorization") String token, @Query("q") String query);

}
