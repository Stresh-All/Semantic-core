import action.TextManager;
import doubleprepare.DoublePreparer;
import entity.Union;
import entity.textcover.TextCommon;
import file.TextFinder;
import synonym.Synonym;
import synonym.SynonymCreator;
import textprepare.TextPrepared;
import textprepare.impl.*;
import unsupervised.UnsupervisedSetClassificator;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo {
    public static void main(String[] args){
        /*Dictionary dictionary = new Dictionary();
        Map <String, Integer> map = new HashMap<>();
        map.put("john", 1);
        Map.Entry <String, Integer> entry = map.entrySet().iterator().next();
        System.out.println(dictionary.put(entry));*/
        Synonym synonym = SynonymCreator.createSynonym("Synonym.txt", "[\\s,]+");
        //TextFinder textFinder = new TextFinder("text1.txt", "text2.txt", "text3.txt", "text4.txt", "text5.txt", "text6.txt","text7.txt");
        TextFinder textFinder = new TextFinder("text1.txt", "text2.txt", "text3.txt", "text4.txt", "text5.txt", "text6.txt","text7.txt","text8.txt","text9.txt","text10.txt","text11.txt","text12.txt","text13.txt","text14.txt");
        //TextFinder textFinder = new TextFinder("text5.txt");
        List<String> texts = textFinder.getTexts();
       // TextCommon textCommon = new TextCommon(texts.get(0));
       // System.out.println(textCommon.toString());
        TextPrepared textPrepared = new TextPrepared(new IrrelevantSymbolDeleter(), new RegisterPrepare(), new IrrelevantWordDeleter(), new ErrorWordCorrector(), new StemmingText(), new SynonymsReplacer());
        TextManager textManager = new TextManager(texts, textPrepared);
        UnsupervisedSetClassificator unsupervisedSetClassificator = new UnsupervisedSetClassificator(textManager);
        List <Union> unions = unsupervisedSetClassificator.separateOnSet();
        System.out.println(unions);
        System.out.println(textManager.getTexts());
        DoublePreparer doublePreparer = new DoublePreparer(textManager, unions);
        doublePreparer.secondStep(textPrepared);
        System.out.println(textManager.getTexts());
    }
}
