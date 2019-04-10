package entity.textcover;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word extends TextCover {

    private static final String REGEX = ".{1}";

    public Word(String word){
        DELIVERY = "";
        son = new ArrayList<>();
        chainPrepare(word);
    }

    @Override
    protected void chainPrepare(String text) {
        List<String> symbols = new ArrayList<>();

        //System.out.println("Word: "+text);

        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(text);

        while(matcher.find())
        {
            symbols.add(matcher.group().trim());
            //System.out.println("Symbol:  "+matcher.group());
        }

        System.out.println("Symbol:  "+symbols);

        for (String s: symbols){
            if (StringUtils.isNotEmpty(s)) {
                son.add(new Symbol(s));
            }
        }
    }

    @Override
    public String withoutTrash(int type) {
        if (type == this.type){
            return toString();
        }
        return StringUtils.EMPTY;
    }
}
