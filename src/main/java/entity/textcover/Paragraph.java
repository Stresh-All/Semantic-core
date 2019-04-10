package entity.textcover;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Paragraph extends TextCover {

    private static final String REGEX = "([^(\\.|!|\\?)]+)(\\.|!|\\?)";

    public Paragraph(String paragraph){
        DELIVERY = " ";
        son = new ArrayList<>();
        chainPrepare(paragraph);
    }

    @Override
    protected void chainPrepare(String paragraph)
    {
        List<String> sentences = new ArrayList<>();

        //System.out.println("Paragraph: "+paragraph);

        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(paragraph);

        while(matcher.find())
        {
            sentences.add(matcher.group().trim());
           // System.out.println("Sentence:  "+matcher.group());
        }

        System.out.println("Sentence:  "+sentences);

        for (String s: sentences){
            son.add(new Sentence(s));
        }
    }
}
