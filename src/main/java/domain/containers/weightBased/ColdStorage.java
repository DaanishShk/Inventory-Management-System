package domain.containers.weightBased;

import domain.items.wieghtBased.coldItem;


public class ColdStorage extends weightBasedContainer<coldItem> {

    private double temperature;

    public ColdStorage(double temperature) {
        super(0, "Insulated");
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "ID: "+this.id+"\t\tContainerType: "+super.type+"\t\tTemperature: "+this.temperature
                +"\t\tMaximum Capacity: "+ this.maxWeight+" kgs"+"\t\tCurrent Weight: "+ this.getTotalWeight()+" kgs";
    }

}
