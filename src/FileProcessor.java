import java.io.*;

/**
 * Created by Nikhil on 1/27/2016.
 */
public class FileProcessor {
    String fileName;
    public BufferedReader reader = null;

    /**
     * Constructor will initiate buffer reader object provided file name
     * @param fileName
     * @throws FileNotFoundException
     */
    public FileProcessor(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        File file = new File(this.fileName);
        reader = new BufferedReader(new FileReader(file.getAbsolutePath()));
        //Logger.writeMessage("In FileProcessor Constructor.", Logger.DebugLevel.CONSTRUCTOR);
        //scanner = new Scanner(new FileReader(file.getAbsolutePath()));
    }

    /**
     * It will read each line; one line at a time.
     * @return line String
     * @throws IOException
     */
    public synchronized String readLineFromFile() throws IOException {
        String line = reader.readLine();
        //line = scanner.nextLine();
        return line;
    }
}
