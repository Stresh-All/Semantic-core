package entity.textcover;

import action.DictionaryAnalyzer;
import action.TextCreator;
import entity.Text;
import entity.Union;
import textprepare.TextPrepared;
import util.IdUnionTypeGenerator;

import java.util.List;

abstract public class TextCover {

    protected List<TextCover> son;
    protected TextCover parent;
    protected boolean isTheMostCommon;
    protected int type;
    protected String DELIVERY;
    protected List<Union> unions;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("type: "+type+" isThemostCommon "+isTheMostCommon);
        for (TextCover text: son){
            stringBuilder.append(text.toString()+DELIVERY);
        }
        return stringBuilder.toString();
    }

    abstract protected void chainPrepare(String text);


    public void setUnions(List<Union> unions) {
        this.unions = unions;
        if (son != null){
            for (TextCover textCover: son){
                textCover.setUnions(unions);
            }
        }
    }

    public int setType(TextPrepared textPrepared){
        if (unions == null){
            return IdUnionTypeGenerator.UNKNOWN_TYPE;
        }
        int type = IdUnionTypeGenerator.UNKNOWN_TYPE;
        boolean isAllCommon = true;
        boolean isCommon = true;
        boolean isLeaf = true;
        if (son != null) {
            isLeaf = false;
            for (TextCover textCover : son) {
                isAllCommon = isAllCommon & textCover.isTheMostCommon;
                int currentType = textCover.setType(textPrepared);
                if (type == IdUnionTypeGenerator.UNKNOWN_TYPE){
                    type = currentType;
                }
                if (type != currentType){
                    isCommon = false;
                }
            }
        }
        TextCreator textCreator = new TextCreator();
        Text text = textCreator.textCreator(toString());
        textCreator.textFieldFill(text, textPrepared);
        double max = 0;
        int currentType = IdUnionTypeGenerator.UNKNOWN_TYPE;
        for (Union union: unions){
            DictionaryAnalyzer dictionaryAnalyzer = new DictionaryAnalyzer();
            double currentCover = dictionaryAnalyzer.coveringPerCent(text.getDictionary(), union.getDictionary());
            if (currentCover > max){
                max = currentCover;
                currentType = union.getId();
            }
        }
        if (isLeaf || (currentType == type && isAllCommon && isCommon)){
            isTheMostCommon = true;
        }
        return currentType;
    }

    public int setTypeTrash(TextPrepared textPrepared, int mainType){
        if (unions == null){
            return IdUnionTypeGenerator.UNKNOWN_TYPE;
        }
        int type = IdUnionTypeGenerator.UNKNOWN_TYPE;
        boolean isCommon = true;
        boolean isLeaf = true;
        if (son != null) {
            isLeaf = false;
            for (int i = 0; i < son.size(); i++) {
                TextCover textCover = son.get(i);
                int currentType = textCover.setTypeTrash(textPrepared, mainType);
                if (type == IdUnionTypeGenerator.UNKNOWN_TYPE){
                    type = currentType;
                }
                if (type != currentType && (currentType == mainType || (type == mainType))){
                    isCommon = false;
                }
            }
        }
        TextCreator textCreator = new TextCreator();
        Text text = textCreator.textCreator(toString());
        textCreator.textFieldFill(text, textPrepared);
        double max = 0;
        int currentType = IdUnionTypeGenerator.UNKNOWN_TYPE;
        for (Union union: unions){
            DictionaryAnalyzer dictionaryAnalyzer = new DictionaryAnalyzer();
           // System.out.println(text.getDictionary() +" "+union.getDictionary());
            double currentCover = dictionaryAnalyzer.coveringPerCent(text.getDictionary(), union.getDictionary());
            if (currentCover > max){
                //System.out.println(currentCover);
                max = currentCover;
                //System.out.println(currentType);
                currentType = union.getId();
            }
        }
        this.type = currentType;
        if (isLeaf || (currentType == type && isCommon)){
            isTheMostCommon = true;
        }
        return currentType;
    }



    public String withoutTrash(int type){
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("type: "+this.type+" isThemostCommon "+isTheMostCommon);
        for (TextCover text: son){
            if (type != text.type){
                continue;
            }
            stringBuilder.append(text.withoutTrash(type)+DELIVERY);
        }
        return stringBuilder.toString();
    }

    public String withoutTrash(){
        StringBuilder stringBuilder = new StringBuilder();
        for (TextCover text: son){
            if (text.isTheMostCommon){
                continue;
            }
            stringBuilder.append(text.withoutTrash(type)+DELIVERY);
        }
        return stringBuilder.toString();
    }
}
