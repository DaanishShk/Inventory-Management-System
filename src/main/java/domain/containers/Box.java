package domain.containers;

import domain.items.Item;

import java.util.HashMap;
import java.util.Map;

public class Box implements Container {

    private double maxWeight;
    private Map<Item, Integer> items;
    private int id;

    public Box(double maxWeight) {
        this.maxWeight = maxWeight;
        this.items = new HashMap<>();
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
    public int getID() {
        return id;
    }

    @Override
    public void addItem(Item item, int qty) {
        if(!item.getValType().equalsIgnoreCase("weight")) return;

        if(qty <= 0) return;

        Item temp = this.getItem(item.getName());
        if(temp != null) {
            this.items.put(temp, this.items.get(temp)+1);
        }
        if(this.getTotalWeight()+qty*item.getVal() <= this.maxWeight) {
            this.items.put(item, qty);
        }
    }

    @Override
    public Item getItem(String name) {
        for(Item i: this.items.keySet()) {
            if(i.getName().equalsIgnoreCase(name)) return i;
        }
        return null;
    }

    @Override
    public Map<Item, Integer> getContents() {
        return this.items;
    }

    public double getTotalWeight() {
        double weight = 0;
        for(Item i: this.items.keySet()) {
            weight += i.getVal() + this.items.get(i);
        }
        return weight;
    }

    @Override
    public void printContents() {
        System.out.println("Contents of Box:\n");
        int cnt = 1;
        for(Item i: this.items.keySet()) {
            System.out.println(cnt+". "+i+"\tQuantity: "+this.items.get(i));
            cnt++;
        }
    }

    @Override
    public String toString() {
        return "ID: "+this.id+"Container Type: "+this.getType()+"\tMaximum Capacity: "+this.maxWeight+" kgs"+"\tCurrent Weight: "+
                this.getTotalWeight()+" kgs";
    }
}
