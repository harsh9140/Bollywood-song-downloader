package crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MainCrawler {

    public static void main(String[] args) {

        Connection connection = null;

        try {

            // PostgreSQL Connection
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/twitter",
                    "postgres",
                    "123"
            );

            System.out.println("Database Connected Successfully\n");

            // Websites to crawl
            String[] websites = {
                    "https://books.toscrape.com/",
                    "https://quotes.toscrape.com/",
                    "https://news.ycombinator.com/"
            };

            // Loop through websites
            for (String website : websites) {

                try {

                    System.out.println("Opening Page: " + website);

                    // Connect to website
                    Document document = Jsoup.connect(website)
                            .timeout(10000)
                            .get();

                    // Print title
                    System.out.println("Page Title: " + document.title());

                    // Get all links
                    Elements links = document.select("a[href]");

                    System.out.println("Total Links Found: " + links.size());

                    // Loop through all links
                    for (Element link : links) {

                        try {

                            // Get absolute URL
                            String absUrl = link.absUrl("href");

                            // Skip empty links
                            if (absUrl == null || absUrl.isEmpty()) {
                                continue;
                            }

                            System.out.println("Found Link: " + absUrl);

                            // Insert query
                            String sql =
                                    "INSERT INTO public.crawled_links(url, source) VALUES (?, ?)";

                            PreparedStatement ps =
                                    connection.prepareStatement(sql);

                            ps.setString(1, absUrl);
                            ps.setString(2, website);

                            // Execute insert
                            ps.executeUpdate();

                            // Close PreparedStatement
                            ps.close();

                            // Optional filter
                            if (absUrl.toLowerCase().contains("music")
                                    || absUrl.toLowerCase().contains("song")) {

                                System.out.println(
                                        "Song Related Link Found: " + absUrl
                                );
                            }

                        } catch (Exception e) {

                            System.out.println("Insert Failed");

                            e.printStackTrace();
                        }
                    }

                    System.out.println();

                } catch (Exception e) {

                    System.out.println("Failed To Open: " + website);

                    e.printStackTrace();
                }
            }

            System.out.println("\nCrawler Finished.");

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            try {

                if (connection != null) {
                    connection.close();
                }

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }
}