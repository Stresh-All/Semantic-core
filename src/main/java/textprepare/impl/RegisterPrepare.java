package textprepare.impl;

import textprepare.Preparing;

public class RegisterPrepare implements Preparing {
    @Override
    public String[] prepare(String[] text) {
        String[] prepare = new String[text.length];
        for (int i = 0; i < text.length; i++){
            prepare[i] = text[i].toLowerCase();
        }
        return prepare;
    }
}
