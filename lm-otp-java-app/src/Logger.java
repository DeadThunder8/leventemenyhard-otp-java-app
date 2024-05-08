import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static String logPath = "application.log";

    public static void log(String message) {
        try {
            File file = new File(logPath);
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(message + "\n");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Unable to write log.");
        }

    }
}
