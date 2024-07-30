import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private FileWriter fileWriter;

    public Logger(String fileName) throws IOException {
        fileWriter = new FileWriter(fileName, true); // Append mode
    }

    public void log(String message) {
        try {
            fileWriter.write(message + "\n");
            fileWriter.flush();
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }

    public void close() {
        try {
            if (fileWriter != null) {
                fileWriter.close();
            }
        } catch (IOException e) {
            System.err.println("Error closing log file: " + e.getMessage());
        }
    }
}
