package textprepare;

import entity.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextPrepared {

    List<Preparing> preparedSet;

    public TextPrepared (Preparing...preparings){
        preparedSet = new ArrayList<>();
        preparedSet.addAll(Arrays.asList(preparings));
    }

    public void prepare(Text textEntity){
        String text = textEntity.getText();
        String[] words = TextTokenizer.tokenize(text);
        for (Preparing preparing: preparedSet){
            words = preparing.prepare(words);
        }
        textEntity.setPreparedText(words);
    }

}
