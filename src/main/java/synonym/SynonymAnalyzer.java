package synonym;

public class SynonymAnalyzer {
    private Synonym synonyms;

    public SynonymAnalyzer(Synonym synonyms) {
        this.synonyms = synonyms;
    }

    public String[] analyze(String[] text){
        String[] result = new String[text.length];
        for (int i = 0; i < text.length; i++){
            String synonym = synonyms.get(text[i]);
            if (synonym != null){
                result[i] = synonym;
                continue;
            }
            result[i] = text[i];
        }
        return result;
    }
}
