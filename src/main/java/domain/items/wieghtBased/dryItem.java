package domain.items.wieghtBased;

import domain.items.Item;
import lombok.NoArgsConstructor;

/**
 * Class for Items not sensitive to temperature.
 * @author DaanishShk
 * @version 1.0
 */
// No use of using Lombok annotations here as no fields
@NoArgsConstructor
public class dryItem extends weightBased {

    private final int type = 1;

    public dryItem(String name, double weight) {
        super(name, weight);
    }

    @Override
    public int getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Name: "+name+"\tType: dry"+"\tWeight: "+weight;
    }
}
