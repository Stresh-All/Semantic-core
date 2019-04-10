package entity;

import java.util.Iterator;
import java.util.Map;

public class DictionaryIterator implements Iterator<Map.Entry<String, Integer>> {
    Iterator <Map.Entry<String, Integer>> iterator;

    public DictionaryIterator(Dictionary dictionary){
        iterator = dictionary.entrySet().iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Map.Entry<String, Integer> next() {
        return iterator.next();
    }
}
