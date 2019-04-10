package entity.textcover;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentence  extends TextCover {
    private static final String REGEX = "([^(\\s)]*)(\\s)*";

    public Sentence(String sentence){
        DELIVERY = " ";
        son = new ArrayList<>();
        chainPrepare(sentence);
    }

    @Override
    protected void chainPrepare(String sentence) {
        List<String> words = new ArrayList<>();

        //System.out.println("Sentence: "+sentence);

        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(sentence);

        while(matcher.find())
        {
            words.add(matcher.group().trim());
           // System.out.println("Word:  "+matcher.group());
        }
        System.out.println("Word:  "+words);
        for (String w: words){
            son.add(new Word(w));
        }
    }
}
