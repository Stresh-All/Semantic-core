package entity.textcover;

public class Symbol extends TextCover {

    private String symbol;

    public Symbol(String symbol){
        chainPrepare(symbol);
    }

    @Override
    public String toString(){
        return symbol;
    }


    @Override
    protected void chainPrepare(String text) {
        System.out.println("Symbol: "+text);
       this.symbol = text;
    }

    @Override
    public String withoutTrash(int type) {
        return symbol;
    }
}
