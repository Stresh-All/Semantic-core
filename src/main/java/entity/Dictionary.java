package entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Dictionary extends HashMap<String, Integer> {

        public Iterator <Map.Entry<String, Integer>> iterator(){
            return new DictionaryIterator(this);
        }

        public boolean put(Object object){
            try {
                Map.Entry<String, Integer> element = (Map.Entry<String, Integer>) object;
                String word = element.getKey();
                Integer currentResult = getOrDefault(word, 0);
                put(word, currentResult + element.getValue());
                return true;
            }
            catch (ClassCastException e){
                return false;
            }
        }

        public boolean contains(Object object){
            try {
                Map.Entry<String, Integer> element = (Map.Entry<String, Integer>) object;
                return containsKey(element.getKey());
            }
            catch (ClassCastException e){
                return false;
            }
        }

        public boolean putEqual(Dictionary dict, Object object){
            if (!dict.contains(object)){
                return false;
            }
            Map.Entry<String, Integer> element = (Map.Entry<String, Integer>) object;
            element.setValue(dict.get(element.getKey()));
            return put(element);
        }

        public void remove(Dictionary dictionary){
            for (String key: dictionary.keySet()){
                remove(key);
            }
        }

        public void putWord(String word){
            Integer currentResult = getOrDefault(word, 0);
            put(word, currentResult + 1);
        }
}

