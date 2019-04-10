package doubleprepare;

import entity.Text;
import entity.Union;
import entity.textcover.TextCommon;
import entity.textcover.TextCover;
import textprepare.TextPrepared;
import util.IdUnionTypeGenerator;

import java.util.List;

public class ParallelTypeClassificator {

    private Text text;
    private TextPrepared textPrepared;

    public ParallelTypeClassificator(Text text, TextPrepared textPrepared) {
        this.text = text;
        this.textPrepared = textPrepared;
    }

    public void deleteTrash(List<Union> unions){
        int type = IdUnionTypeGenerator.UNKNOWN_TYPE;
        for (Union union: unions){
            if (union.contains(text)){
                type = union.getId();
            }
        }
        TextCover textCover = new TextCommon(text.getText());
        textCover.setUnions(unions);
        textCover.setTypeTrash(textPrepared, type);
        String kernel = textCover.withoutTrash(type);
        text.setKernel(kernel);
    }
}
