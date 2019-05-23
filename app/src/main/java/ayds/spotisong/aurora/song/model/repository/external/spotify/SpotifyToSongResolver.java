package ayds.spotisong.aurora.song.model.repository.external.spotify;

import ayds.spotisong.aurora.song.model.Song;

public interface SpotifyToSongResolver {

  Song getSongFromExternalData(String serviceData) throws Exception;
}

