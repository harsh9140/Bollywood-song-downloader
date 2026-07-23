package crawler;

import entity.Song;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AlbumPageParser {

    public static List<Song> parseAlbum(
            String albumUrl) {

        List<Song> songs = new ArrayList<>();

        try {

            URL url = new URL(albumUrl);

            HttpURLConnection conn =
                    (HttpURLConnection)
                            url.openConnection();

            conn.addRequestProperty(
                    "User-Agent",
                    "Chrome"
            );

            Document doc =
                    Jsoup.parse(
                            conn.getInputStream(),
                            "UTF-8",
                            albumUrl
                    );

            String albumName = "";

            if (doc.title() != null) {
                albumName = doc.title();
            }

            String imageLink = "";
            String cast = "";
            String composer = "";

            Elements images = doc.select("img");

            if (images.size() > 0) {
                imageLink =
                        images.first().absUrl("src");
            }

            Elements links = doc.select("a");

            for (Element link : links) {

                String href =
                        link.absUrl("href");

                if (href.contains(".mp3")) {

                    String songName =
                            link.text();

                    Song song = new Song(
                            albumName,
                            imageLink,
                            cast,
                            composer,
                            songName,
                            href
                    );

                    songs.add(song);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return songs;
    }
}
