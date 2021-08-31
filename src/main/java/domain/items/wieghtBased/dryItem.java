package domain.items.wieghtBased;

import domain.items.Item;
import lombok.NoArgsConstructor;

// No use of using Lombok annotations here as no fields
@NoArgsConstructor
public class dryItem extends weightBased {

    public dryItem(String name, double weight) {
        super(name, weight);
    }

    @Override
    public String toString() {
        return "Name: "+name+"\tType: dry"+"\tWeight: "+weight;
    }
}
