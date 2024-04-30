package proxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RealServer implements SongService {
    private HashMap<Integer, Song> songMapId = new HashMap<>();

    public RealServer() {
        // Preload the song map with hardcoded songs
        songMapId.put(0, new Song("Kiss", "Prince", "Parade", 346));
        songMapId.put(1, new Song("Apparently", "J. Cole", "2014FHD", 453));
        songMapId.put(2, new Song("Human Nature", "Michael Jackson", "Thriller", 406));
        songMapId.put(3, new Song("Stronger", "Kanye West", "Graduation", 512));
        songMapId.put(4, new Song("Chicago", "Michael Jackson", "XSCAPE", 405));
    }

    @Override
    public Song searchById(Integer songID) {
        delay("Searching by songID...");
        return songMapId.get(songID);
    }

    @Override
    public List<Song> searchByTitle(String title) {
        delay("Searching by title...");
        List<Song> songResults = new ArrayList<>();
        for (Song song : songMapId.values()) {
            if (song.getTitle().equals(title)) {
                songResults.add(song);
            }
        }
        return songResults;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        delay("Searching by album...");
        List<Song> songResults = new ArrayList<>();
        for (Song song : songMapId.values()) {
            if (song.getAlbum().equals(album)) {
                songResults.add(song);
            }
        }
        return songResults;
    }

    private void delay(String message) {
        System.out.println(message);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
}
