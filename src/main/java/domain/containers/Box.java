package domain.containers;

import domain.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Box implements Container {

    private double maxWeight;
    private List<Item> items;
    private int id;

    public Box(double maxWeight) {
        this.maxWeight = maxWeight;
        this.items = new ArrayList<>();
        this.id = this.hashCode();
    }

    @Override
    public double getMaxCapacity() {
        return this.maxWeight;
    }

    @Override
    public String getType() {
        return "Box";
    }

    @Override
    public void addItem(Item item) {
        if(!item.getValType().equalsIgnoreCase("weight")) return;

        if(this.getTotalWeight()+item.getTotalVal() <= this.maxWeight) {
            this.items.add(item);
        }
    }

    public double getTotalWeight() {
        double weight = 0;
        for(Item i: this.items) {
            weight += i.getTotalVal();
        }
        return weight;
    }

    @Override
    public Item getItem(String name) {
        for(Item i: this.items) {
            if(i.getName().equalsIgnoreCase(name)) return i;
        }
        return null;
    }

    @Override
    public List<Item> getContents() {
        return this.items;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public String toString() {
        return "Container Type: "+this.getType()+"\nMaximum Capacity: "+this.maxWeight+" kgs"+"\nCurrent Weight: "+
                this.getTotalWeight()+" kgs";
    }
}
