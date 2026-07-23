import java.io.File;
import java.util.*;
import java.util.Map.Entry;
public class FileReaderRunnable implements Runnable  {
    private String filePath;

    public FileReaderRunnable(String filePath) {

        this.filePath = filePath;
    }

    @Override
    public void run() {

        HashMap<String, Integer> wordCount = new HashMap<>();

        Scanner scanner = null;

        try {

            File file = new File(filePath);

            scanner = new Scanner(file);

            while (scanner.hasNext()) {

                String word = scanner.next();

                // convert to lowercase
                word = word.toLowerCase();

                // remove punctuation
                word = word.replaceAll("[^a-z0-9]", "");

                if (!word.isEmpty()) {

                    wordCount.put(word,
                            wordCount.getOrDefault(word, 0) + 1);
                }
            }

            // Convert map to list
            List<Entry<String, Integer>> list =
                    new ArrayList<>(wordCount.entrySet());

            // Sort descending
            list.sort((a, b) -> b.getValue() - a.getValue());

            System.out.println("\nall Keywords:\n");

            for (int i = 0;  i < list.size(); i++) {

                Entry<String, Integer> entry = list.get(i);

                System.out.println(i+" "+
                        entry.getKey() + " : " + entry.getValue());
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
