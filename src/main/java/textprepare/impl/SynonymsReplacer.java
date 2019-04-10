package textprepare.impl;

import action.Porter;
import synonym.Synonym;
import synonym.SynonymAnalyzer;
import synonym.SynonymCreator;
import textprepare.Preparing;

public class SynonymsReplacer implements Preparing {

    @Override
    public String[] prepare(String[] text) {
        Synonym synonym = SynonymCreator.createSynonym("Synonym.txt", "[\\s,]+");
        synonym.stemDictionary(new Porter());
        SynonymAnalyzer synonymAnalyzer = new SynonymAnalyzer(synonym);
        return synonymAnalyzer.analyze(text);
    }
}
