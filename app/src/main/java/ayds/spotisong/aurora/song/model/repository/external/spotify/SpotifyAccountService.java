package ayds.spotisong.aurora.song.model.repository.external.spotify;

import android.util.Base64;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

class SpotifyAccountService {

  private Retrofit spotifyAccountRetrofit = new Retrofit.Builder()
      .baseUrl("https://accounts.spotify.com/api/")
      .addConverterFactory(ScalarsConverterFactory.create())
      .build();

  private final SpotifyAPI spotifyTokenAPI = spotifyAccountRetrofit.create(SpotifyAPI.class);

  private final String clientId = "7db5d794e42845028ccabd50009e631f";
  private final String clientSecret = "dc3db8626d86471b92662b72f5eff8ad";

  private String token = null;

  private final SpotifyToTokenResolver resolver;

  SpotifyAccountService(SpotifyToTokenResolver resolver) {
    this.resolver = resolver;
  }

  String getToken() throws Exception {
    if (token == null) {
      Response<String> tokenResponse = getTokenFromService();
      token = getStringToken(tokenResponse);
    }
    return token;
  }

  private Response<String> getTokenFromService() throws Exception {
    return spotifyTokenAPI.getToken(getAuthorizationHeader(), getAuthorizationBody()).execute();
  }

  private RequestBody getAuthorizationBody() {
    return RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"),
                              "grant_type=client_credentials");
  }

  private String getAuthorizationHeader() {
    String encodedData = Base64.encodeToString((clientId + ":" + clientSecret).getBytes(), Base64.NO_WRAP);
    return "Basic " + encodedData;
  }

  private String getStringToken(Response<String> tokenResponse) throws Exception {
    return resolver.getTokenFromExternalData(tokenResponse.body());
  }
}
