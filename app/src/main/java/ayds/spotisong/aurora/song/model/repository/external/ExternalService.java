package ayds.spotisong.aurora.song.model.repository.external;

import ayds.spotisong.aurora.song.model.Song;

public interface ExternalService {

  Song getSong(String query) throws Exception;
}
