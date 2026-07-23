package crawler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class SongListReader {

    public static List<String> getAllUrls() {

        List<String> urls = new ArrayList<>();

        try {

            BufferedReader br =
                    new BufferedReader(
                            new FileReader("songlist.txt")
                    );

            String line;

            while ((line = br.readLine()) != null) {

                line = line.trim();

                if (!line.isEmpty()) {
                    urls.add(line);
                }
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return urls;
    }
}
