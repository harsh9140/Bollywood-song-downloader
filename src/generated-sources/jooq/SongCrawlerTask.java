package crawler;

import database.SongDAO;
import entity.Song;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
//import TaskManager;

import java.net.HttpURLConnection;
import java.net.URL;

public class SongCrawlerTask implements Runnable {

    private String albumUrl;

    public SongCrawlerTask(String albumUrl) {
        this.albumUrl = albumUrl;
    }

    @Override
    public void run() {

        try {

            URL url = new URL(albumUrl);

            HttpURLConnection conn =
                    (HttpURLConnection) url.openConnection();

            conn.addRequestProperty("User-Agent", "Chrome");

            Document doc = Jsoup.parse(conn.getInputStream(),
                    "UTF-8",
                    albumUrl);

            String albumName = "";

            if (doc.title() != null)
                albumName = doc.title();

            String imageLink = "";
            String cast = "";
            String composer = "";

            Elements img = doc.select("img");

            if (img.size() > 0) {
                imageLink = img.first().absUrl("src");
            }

            Elements links = doc.select("a");

            for (Element link : links) {

                String href = link.absUrl("href");

                if (href.contains(".mp3")) {

                    String songName = link.text();

                    Song song = new Song(
                            albumName,
                            imageLink,
                            cast,
                            composer,
                            songName,
                            href
                    );

                    SongDAO.insertSong(song);

                    System.out.println("Inserted : " + songName);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
