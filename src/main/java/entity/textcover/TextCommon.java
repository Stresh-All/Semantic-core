package entity.textcover;

import sun.misc.Regexp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextCommon extends TextCover {

    private static final String REGEX = "([^(\\r\\n)]+)((\\r\\n)|\\z)";

    public TextCommon(String text){
        DELIVERY = "\n";
        son = new ArrayList<>();
        chainPrepare(text);
    }

    @Override
    protected void chainPrepare(String text) {
        List<String> paragraphs = new ArrayList<>();

        //System.out.println("Text: "+text);

        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(text);

        while(matcher.find())
        {
            paragraphs.add(matcher.group().trim());
            //System.out.println("Paragraph:  "+matcher.group());
        }

       System.out.println("Paragraph: "+paragraphs);

        for (String p: paragraphs){
            son.add(new Paragraph(p));
        }
    }
}
