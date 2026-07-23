public class Main {
    public static void main(String[] args) {

        //String filePath =
                //"C:\\Users\\harsh\\OneDrive\\Desktop\\NationalAnthem.txt";
                String filePath =  "C:\\Users\\harsh\\OneDrive\\Desktop\\java\\data\\practice\\file\\create-File.txt";

        ThreadManager threadManager = new ThreadManager(1);

        FileReaderRunnable fileReaderRunnable =
                new FileReaderRunnable(filePath);

        threadManager.execute(fileReaderRunnable);

        threadManager.shutdown();
    }
}
