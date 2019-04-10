package textprepare.impl;

import action.Porter;
import textprepare.Preparing;

public class StemmingText implements Preparing {
    @Override
    public String[] prepare(String[] text) {
        Porter porter = new Porter();
        String[] prepare = new String[text.length];
        for (int i = 0; i < text.length; i++){
            prepare[i] = porter.stem(text[i]);
        }
        return prepare;
    }
}
