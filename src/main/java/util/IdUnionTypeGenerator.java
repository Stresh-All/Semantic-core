package util;

public class IdUnionTypeGenerator {
    public static final int UNKNOWN_TYPE = 0;
    private static int CURRENT_TYPE = UNKNOWN_TYPE;


    public static int getCurrentType() {
        return ++CURRENT_TYPE;
    }
}
