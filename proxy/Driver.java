package proxy;

import java.util.List;

public class Driver {

    public static void main(String[] args) {
        RealServer realServer = new RealServer();
        SongService proxy = new ProxyServer(realServer);

        // serach by id
        System.out.println(proxy.searchById(4));
        System.out.println("Item cached");
        System.out.println(proxy.searchById(0));

        // search by title
        List<Song> songTitle = proxy.searchByTitle("Chicago");
        System.out.println(songTitle);
        songTitle = proxy.searchByTitle("Chicago");
        System.out.println("Item cached");
        System.out.println(songTitle);

        // search by album
        List<Song> albumList = proxy.searchByAlbum("Graduation");
        System.out.println(albumList);
        albumList = proxy.searchByAlbum("Graduation");
        System.out.println("Item cached");
        System.out.println(albumList);

    }

}