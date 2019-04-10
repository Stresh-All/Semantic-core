package action;

import entity.Dictionary;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DictionaryAnalyzer {

    public Dictionary union(Dictionary dict1, Dictionary dict2){
        Dictionary result = new Dictionary();
        result.putAll(dict1);
        Iterator iterator = dict2.iterator();
        while (iterator.hasNext()){
            result.put(iterator.next());
        }
        return result;
    }

    public Dictionary intersection(Dictionary dict1, Dictionary dict2){
        Dictionary result = new Dictionary();
        Iterator iterator = dict1.iterator();
        while (iterator.hasNext()) {
            result.putEqual(dict2, iterator.next());
        }
        return result;
    }

    public Dictionary intersectionAll(List<Dictionary> dictionaries){
        if (dictionaries == null || dictionaries.isEmpty()){
            return new Dictionary();
        }
        Dictionary result = dictionaries.get(0);
        for (Dictionary dictionary: dictionaries){
            result = intersection(result, dictionary);
        }
        return result;
    }

    public void residual(Dictionary dictionary, Dictionary trash){
        dictionary.remove(trash);
    }

    public void residualAll(List<Dictionary> dictionaries, Dictionary trash){
        for (Dictionary dictionary: dictionaries){
            residual(dictionary, trash);
        }
    }

    public double coveringPerCent(Dictionary dictionary1, Dictionary dictionary2){
        Dictionary interSect = intersection(dictionary1, dictionary2);
        return Math.max(Math.max((interSect.size()*1.0)/(dictionary1.size()+dictionary2.size()),(interSect.size()*1.0)/(dictionary1.size())),(interSect.size()*1.0)/(dictionary2.size()));
    }

    public Dictionary unionAll(List<Dictionary> dictionaries){
        if (dictionaries == null || dictionaries.isEmpty()){
            return new Dictionary();
        }
        Dictionary result = dictionaries.get(0);
        for (Dictionary dictionary: dictionaries){
            result = union(result, dictionary);
        }

        int commonWordNumber = 0;
        Iterator iterator = result.iterator();
        while (iterator.hasNext()){
            commonWordNumber += ((Map.Entry<String, Integer>)iterator.next()).getValue();
        }
        Dictionary finalResult = new Dictionary();
        double alpha = 0.4;
        iterator = result.iterator();
        while (iterator.hasNext()){
             Object object = iterator.next();
             System.out.println(((Map.Entry<String, Integer>)object).getValue()/(commonWordNumber*0.1));
            if(((Map.Entry<String, Integer>)object).getValue()/(commonWordNumber*0.1) >= alpha){
                finalResult.put(object);
            }
        }
        return finalResult;
    }

}
