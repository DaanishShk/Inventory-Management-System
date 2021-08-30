package domain.items.wieghtBased;

import domain.items.Item;

// No use of using Lombok annotations here as no fields
public class dryItem extends weightBased {

    public dryItem(String name, double weight) {
        super(name, weight);
    }

    @Override
    public String toString() {
        return "Name: "+name+"\tType: dry"+"\tWeight: "+weight;
    }
}
