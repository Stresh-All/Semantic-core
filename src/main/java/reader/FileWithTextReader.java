package reader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWithTextReader {
    public static String readWholeFile(String fileName) throws IOException {
      // return Files.lines(Paths.get(fileName), StandardCharsets.UTF_8).reduce("", String::concat);
       return new String(Files.readAllBytes(Paths.get(fileName)));
    }
}
