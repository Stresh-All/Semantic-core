package synonym;

import reader.SynonymReader;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class SynonymCreator {

    private static final int max_deep = 15;

    public static Synonym createSynonym(String dictionary, String separator){
        Synonym synonym = new Synonym();
        try {
            SynonymReader synonymReader = new SynonymReader(dictionary, separator);
            Map<String, List<String>> dict = synonymReader.readDictionary();
            while (!dict.isEmpty()){
                Deque <String> queue = new ArrayDeque<>();
                Map.Entry<String, List<String>> currentElement = dict.entrySet().iterator().next();
                String value = currentElement.getKey();
                dict.remove(value);
                fillSynonym(queue, synonym, currentElement.getValue());
                int counter = 0;
                while (!queue.isEmpty()){
                    String current = queue.removeFirst();
                    if (current.equals("#")){
                        counter++;
                        continue;
                    }
                    if (counter >= max_deep){
                        continue;
                    }
                    synonym.setPair(current, value);
                    List<String> values = dict.get(current);
                    if (values != null){
                        fillSynonym(queue, synonym, values);
                        dict.remove(current);
                    }
                }
            }
            return synonym;
        } catch (IOException e) {
            return synonym;
        }
    }
    private static void fillSynonym(Deque<String> deque, Synonym map, List<String> list){
        for (String s: list){
            if (!map.containsKey(s) && !deque.contains(s)){
                deque.add(s);
            }
        }
        deque.add("#");
    }
}
