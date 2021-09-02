package ui;

import domain.containers.Container;
// Class that contains type checking for item storage.
import java.util.HashMap;

public class TypeChecker {

    private static HashMap<String,Integer> typeMap = new HashMap<>();

    static {
        typeMap.put("box", 1);

        typeMap.put("insulated", 2);

        typeMap.put("barrel", 3);
    }

    public static int containerType(String type) {
        return typeMap.getOrDefault(type, -1);
    }
}
