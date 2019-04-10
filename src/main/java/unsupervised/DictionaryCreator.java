package unsupervised;

import entity.Dictionary;
import entity.Text;

public class DictionaryCreator {

    public static void create(Text text){
        String[] preparedText = text.getPreparedText();
        Dictionary dictionary = new Dictionary();
        for (String word: preparedText){
            dictionary.putWord(word);
        }
        text.setDictionary(dictionary);
    }
}
