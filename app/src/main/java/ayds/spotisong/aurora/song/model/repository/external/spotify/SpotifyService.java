package ayds.spotisong.aurora.song.model.repository.external.spotify;

import ayds.spotisong.aurora.song.model.Song;
import ayds.spotisong.aurora.song.model.repository.external.ExternalService;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

class SpotifyService implements ExternalService {

  private final Retrofit spotifyAPIRetrofit = new Retrofit.Builder()
          .baseUrl("https://api.spotify.com/v1/")
          .addConverterFactory(ScalarsConverterFactory.create())
          .build();

  private final SpotifyAPI spotifyAPI = spotifyAPIRetrofit.create(SpotifyAPI.class);

  private final SpotifyAccountService spotifyAccountService;
  private final SpotifyToSongResolver spotifyToSongResolver;

  SpotifyService(SpotifyAccountService spotifyAccountService, SpotifyToSongResolver spotifyToSongResolver) {
    this.spotifyAccountService = spotifyAccountService;
    this.spotifyToSongResolver = spotifyToSongResolver;
  }

  @Override
  public Song getSong(String query) throws Exception {
    Response<String> callResponse = getSongFromService(query);
    return spotifyToSongResolver.getSongFromExternalData(callResponse.body());
  }

  private Response<String> getSongFromService(String query) throws Exception {
    return spotifyAPI.getTrackInfo("Bearer " + spotifyAccountService.getToken(), query)
            .execute();
  }
}
