package textprepare.impl;

import textprepare.Preparing;

public class IrrelevantSymbolDeleter implements Preparing {

    @Override
    public String[] prepare(String[] text) {
        int n = text.length;
        String[] temp = new String[n];
        for (int i = 0; i < n; i++){
            String str = text[i].replaceAll("\\.|\\,|\\!|\\?|\\-|\\+|\\(|\\)", "");
            text[i] = str;
        }
        int emptyWordCount = 0;
        for (String word: text){
            if (word.isEmpty()){
                emptyWordCount++;
            }
        }
        String[] prepare = new String[n - emptyWordCount];
        int i = 0;
        for (String word: text){
            if (!word.isEmpty()){
                prepare[i] = word;
                i++;
            }
            //System.out.println(word);
        }
        return prepare;
    }
}
