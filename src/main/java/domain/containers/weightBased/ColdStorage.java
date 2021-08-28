package domain.containers.weightBased;

import domain.items.wieghtBased.coldItem;

public class ColdStorage extends weightBasedContainer<coldItem> {

    private double temperature;

    public ColdStorage(double maxWeight) {
        super(maxWeight, "Insulated");
    }

    @Override
    public String toString() {
        return "ID: "+this.id+"\tContainer Type: "+super.type+"\tTemperature: "+this.temperature+"\tMaximum Capacity: "+
                this.maxWeight+" kgs"+"\tCurrent Weight: "+ this.getTotalWeight()+" kgs";
    }

}
