package reader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.TreeSet;

public class IrrelevantWordReader {

    public static Set<String> irrelevantWordSetReader(String fileName) throws IOException {
        Set <String> wordSet = new TreeSet();
        Files.lines(Paths.get(fileName), StandardCharsets.UTF_8).forEach((line) -> wordSet.add(line));
        return wordSet;
    }
}
