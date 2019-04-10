package textprepare.impl;

import reader.IrrelevantWordReader;
import textprepare.Preparing;

import java.io.IOException;
import java.util.Set;

public class IrrelevantWordDeleter implements Preparing {

    private final static String FILE_NAME = "irrelevantWord.txt";

    @Override
    public String[] prepare(String[] text) {
        int n = text.length;
        int irrelevantWordCounter = 0;
        try {
            Set<String> irrelevantDictionary = IrrelevantWordReader.irrelevantWordSetReader(FILE_NAME);
            for (String word: text){
                if (irrelevantDictionary.contains(word)){
                    irrelevantWordCounter++;
                }
            }
            String[] prepare = new String[n - irrelevantWordCounter];
            int i = 0;
            for (String word: text){
                if (!irrelevantDictionary.contains(word)){
                    prepare[i] = word;
                    i++;
                }
            }
            return prepare;
        } catch (IOException e) {
            return text;
        }
    }
}
