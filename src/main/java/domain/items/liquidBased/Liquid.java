package domain.items.liquidBased;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Liquid {
    private String name;
    private double volume;

    @Override
    public String toString() {
        return "Name: "+name+"\tType: liquid"+"\tVolume: "+volume;
    }
}
