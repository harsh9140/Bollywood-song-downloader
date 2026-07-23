import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionExample {

    public static String sendGet(String urlString) throws Exception {

        URL url = new URL(urlString);

        HttpURLConnection con =
                (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");

        // IMPORTANT
        con.setRequestProperty(
                "User-Agent",
                "Mozilla/5.0"
        );

        int responseCode = con.getResponseCode();

        System.out.println("Response Code: " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));

        String inputLine;

        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {

            response.append(inputLine);
            response.append("\n");
        }

        in.close();

        return response.toString();
    }
}