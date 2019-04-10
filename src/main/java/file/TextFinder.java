package file;

import reader.FileWithTextReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextFinder {

    private List<String> names;

    public TextFinder(String...fileNames){
        names = new ArrayList<>();
        names.addAll(Arrays.asList(fileNames));
    }

    public List<String> getTexts(){
        List<String> texts = new ArrayList<>();
        for (String name: names){
            try {
                texts.add(FileWithTextReader.readWholeFile(name));
            } catch (IOException e) {
                continue;
            }
        }
        return texts;
    }
}
