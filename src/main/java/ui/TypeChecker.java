package ui;

public class TypeChecker {

    private static String[] weightContainers = {"box", "coldstorage"};
    private static String[] liquidContainers = {"barrel"};

    public static int containerType(String type) {
        for(String s: weightContainers) {
            if(s.equals(type)) return 1;
        }

        for(String s: liquidContainers) {
            if(s.equals(type)) return 2;
        }

        return -1;
    }

    public static int itemType(String type) {

    }
}
