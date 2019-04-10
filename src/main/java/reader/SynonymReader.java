package reader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class SynonymReader {

    private Map<String, List<String>> map;
    private String separator;
    private String fileName;

    public SynonymReader(String fileName, String separator){
        map = new HashMap();
        this.separator = separator;
        this.fileName = fileName;
    }

    public Map<String, List<String>> readDictionary() throws IOException {
        Files.lines(Paths.get(fileName), StandardCharsets.UTF_8).forEach((line) -> fill(line));
        return map;
    }

    private void fill(String line){
        String[] dict = line.split(separator);
        String key = dict[0];
        List<String> value = new ArrayList<>();
        for (int i = 1; i < dict.length; i++){
           value.add(dict[i]);
        }
        map.put(key, value);
    }

}
