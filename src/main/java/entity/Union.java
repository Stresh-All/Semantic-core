package entity;

import action.DictionaryAnalyzer;
import action.TextManager;
import util.IdUnionTypeGenerator;

import java.util.List;

public class Union {
    private TextManager textManager;
    private Dictionary dictionary;
    private int id;

    public Union (List<Text> texts){
        textManager = new TextManager(texts);
        fillDictionary();
        id = IdUnionTypeGenerator.getCurrentType();
    }

    private void fillDictionary(){
        DictionaryAnalyzer dictionaryAnalyzer = new DictionaryAnalyzer();
        dictionary = dictionaryAnalyzer.unionAll(textManager.getAllDictionaries());
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public TextManager getTextManager() {
        return textManager;
    }

    @Override
    public String toString() {
        return "Union{" +
                "textManager=" + textManager +
                '}'+'\n';
    }

    public int getId() {
        return id;
    }

    public boolean contains(Text text){
        return textManager.getTexts().contains(text);
    }
}
