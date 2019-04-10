package unsupervised;

import action.DictionaryAnalyzer;
import action.TextManager;
import action.Unioner;
import entity.Dictionary;
import entity.Text;
import entity.Union;

import java.util.List;

public class UnsupervisedSetClassificator {

    private TextManager textManager;

    public UnsupervisedSetClassificator(TextManager textManager) {
        this.textManager = textManager;
    }

    public List<Union> separateOnSet(){
        deleteTrash();
        /*List <List<Text>> set = new ArrayList<>();
        List<Text> texts = textManager.getTexts();
        int size = texts.size();
        int a = (int) Math.random()*(size - 1); */
        Unioner unioner = new Unioner(textManager, 0.2);
        return unioner.union();
    }

    private void deleteTrash(){
        DictionaryAnalyzer dictionaryAnalyzer = new DictionaryAnalyzer();
        Dictionary dictionary = dictionaryAnalyzer.intersectionAll(textManager.getAllDictionaries());
        dictionaryAnalyzer.residualAll(textManager.getAllDictionaries(), dictionary);
    }


}
