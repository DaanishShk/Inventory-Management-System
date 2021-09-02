package domain.containers.weightBased;

import domain.items.wieghtBased.dryItem;
import lombok.NoArgsConstructor;

// Do not extend Container here, use the abstract class itself

public class Box extends weightBasedContainer<dryItem> {

    public Box() {
        super(0, "Box");
    }

    @Override
    public String toString() {
        return "ID: "+this.id+"\t\tContainerType: "+super.type+"\t\tMaximum Capacity: "+this.maxWeight+" kgs"
                +"\t\tCurrent Weight: "+ this.getTotalWeight()+" kgs";
    }
}
