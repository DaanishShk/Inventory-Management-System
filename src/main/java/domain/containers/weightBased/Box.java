package domain.containers.weightBased;

import domain.items.wieghtBased.dryItem;
import lombok.NoArgsConstructor;

// Do not extend Container here, use the abstract class itself
@NoArgsConstructor
public class Box extends weightBasedContainer<dryItem> {

    public Box(double maxWeight) {
        super(maxWeight, "Box");
    }

    @Override
    public String toString() {
        return "ID: "+this.id+"\tContainer Type: "+super.type+"\tMaximum Capacity: "+this.maxWeight+" kgs"+"\tCurrent Weight: "+
                this.getTotalWeight()+" kgs";
    }
}
