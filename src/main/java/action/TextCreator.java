package action;

import entity.Text;
import textprepare.TextPrepared;
import unsupervised.DictionaryCreator;

import java.util.ArrayList;
import java.util.List;

public class TextCreator {

    public Text textCreator(String text){
        return new Text(text);
    }

    public List<Text> textCreator(List <String> texts){
        List<Text> textsList = new ArrayList<>();
        for (String text: texts){
            textsList.add(textCreator(text));
        }
        return textsList;
    }

    public void textFieldFill(List<Text> texts, TextPrepared textPrepared){
        prepareTexts(texts, textPrepared);
        dictionaryCreate(texts);
    }

    public void textFieldFill(Text text, TextPrepared textPrepared){
        textPrepared.prepare(text);
        DictionaryCreator.create(text);
    }

    private void prepareTexts(List<Text> texts, TextPrepared textPrepared){
        for (Text text: texts){
            textPrepared.prepare(text);
        }
    }

    private void dictionaryCreate(List<Text> texts){
        for (Text text: texts){
            DictionaryCreator.create(text);
        }
    }
}
