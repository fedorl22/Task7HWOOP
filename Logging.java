import java.io.FileWriter;
import java.io.IOException;

public class Logging {
    private String fileName;

    public Logging(String fileName) {
        this.fileName = fileName;
    }

    public void log(String message) {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(message + "n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clear() {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write("");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
