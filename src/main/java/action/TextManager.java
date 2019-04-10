package action;

import entity.Dictionary;
import entity.Text;
import textprepare.TextPrepared;

import java.util.*;

public class TextManager {
    private List<Text> texts;

    public TextManager(List<String> texts, TextPrepared textPrepared) {
        TextCreator textCreator = new TextCreator();
        this.texts = textCreator.textCreator(texts);
        textCreator.textFieldFill(this.texts, textPrepared);
    }

    public TextManager(List<Text> texts) {
        this.texts = texts;
    }

    public List<Dictionary> getAllDictionaries(){
        List<Dictionary> dictionaries = new ArrayList<>();
        for (Text text: texts){
            dictionaries.add(text.getDictionary());
        }
        return dictionaries;
    }

    public List<Text> getTexts() {
        return texts;
    }

    @Override
    public String toString() {
        return "TextManager{" +
                "texts=" + texts +
                '}';
    }
}
