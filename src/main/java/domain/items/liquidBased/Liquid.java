package domain.items.liquidBased;

import domain.items.Item;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Liquid extends Item {

    public Liquid(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Name: "+name+"\tType: liquid";
    }

    public int getType() {
        return 3;
    }
}
