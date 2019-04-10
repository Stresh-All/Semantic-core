package synonym;

import action.Porter;
import textprepare.impl.StemmingText;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Synonym extends HashMap<String, String> {

    public void setPair(String key, String value){
        if (!key.equals(value)) {
            this.put(key, value);
        }
    }

    public void stemDictionary(Porter porter){
        Iterator<Map.Entry<String, String>> iterator = this.entrySet().iterator();
        Map<String, String> afterStemming = new HashMap<>();
        while (iterator.hasNext()){
            Map.Entry<String, String> entry = iterator.next();
            String key = entry.getKey();
            String value = entry.getValue();
            String newKey = porter.stem(key);
            String newValue = porter.stem(value);
            iterator.remove();
            afterStemming.put(newKey, newValue);
        }
        this.putAll(afterStemming);
    }
}
