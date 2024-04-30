package proxy;

import java.util.HashMap;
import java.util.List;

public class ProxyServer implements SongService {
    private SongService realServer;
    private HashMap<Integer, Song> songMapId;
    private HashMap<String, List<Song>> songMapTitle;
    private HashMap<String, List<Song>> songMapAlbum;

    public ProxyServer(SongService songService) {
        this.realServer = songService;
        this.songMapId = new HashMap<>();
        this.songMapTitle = new HashMap<>();
        this.songMapAlbum = new HashMap<>();
    }

    @Override
    public Song searchById(Integer id) {

        if (!this.songMapId.containsKey(id)) {
            this.songMapId.put(id, this.realServer.searchById(id));
        }

        return this.songMapId.get(id);
    }

    @Override
    public List<Song> searchByTitle(String title) {
        if (!this.songMapTitle.containsKey(title)) {
            this.songMapTitle.put(title, this.realServer.searchByTitle(title));
        }

        return this.songMapTitle.get(title);
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        if (!this.songMapAlbum.containsKey(album)) {
            this.songMapAlbum.put(album, this.realServer.searchByAlbum(album));
        }

        return this.songMapAlbum.get(album);
    }
}