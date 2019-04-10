package action;

import entity.Text;
import entity.Union;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Unioner {
    private TextManager textManager;
    private Map<Text, Boolean> isUsed;
    private double access;

    public Unioner(TextManager textManager, double access){
        this.access = access;
        this.textManager = textManager;
        fillIsUsed();
    }

    private void fillIsUsed(){
        isUsed = new HashMap<>();
        List<Text> texts = textManager.getTexts();
        for (Text text: texts){
            isUsed.put(text, false);
        }
    }

    public List<Union> union(){
        List <Union> union = new ArrayList<>();
        while (isPossible()){
            for (Map.Entry<Text, Boolean> e: isUsed.entrySet()){
                if (e.getValue().equals(Boolean.FALSE)){
                    union.add(new Union(union(e.getKey())));
                }
            }
        }
        return union;
    }

    private List<Text> union(Text text){
        List<Text> union = new ArrayList<>();
        union.add(text);
        isUsed.put(text, true);
        List<Text> texts = textManager.getTexts();
        for (Text t: texts){
            if (!(isUsed.get(t))){
                if (isAccess(text, t)){
                    union.add(t);
                    isUsed.put(t, true);
                }
            }
        }
        return union;
    }

    private boolean isAccess(Text text1, Text text2){
        DictionaryAnalyzer dictionaryAnalyzer = new DictionaryAnalyzer();
        System.out.println(dictionaryAnalyzer.coveringPerCent(text1.getDictionary(), text2.getDictionary()));
        return dictionaryAnalyzer.coveringPerCent(text1.getDictionary(), text2.getDictionary()) >= access;
    }

    private boolean isPossible(){
        return isUsed.containsValue(false);
    }
}
