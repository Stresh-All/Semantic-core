package doubleprepare;

import action.TextManager;
import entity.Text;
import entity.Union;
import textprepare.TextPrepared;

import java.util.List;

public class DoublePreparer {

    private TextManager textManager;
    private List<Union> unions;

    public DoublePreparer(TextManager textManager, List<Union> unions) {
        this.textManager = textManager;
        this.unions = unions;
    }

    public void secondStep(TextPrepared textPrepared){
        List<Text> texts = textManager.getTexts();
        for (int i = 0; i < texts.size(); i++){
            ParallelTypeClassificator parallelTypeClassificator = new ParallelTypeClassificator(texts.get(i), textPrepared);
            parallelTypeClassificator.deleteTrash(unions);
        }
    }
}
