package textprepare;

public class TextTokenizer {
    public static String[] tokenize(String text){
        if (text == null){
            return null;
        }
        return text.split("\\s+");
    }
}
