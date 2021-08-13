package domain.containers;

import domain.items.Item;

import java.util.List;

public class ColdStorage implements Container {

    private double maxWeight;

    public ColdStorage(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    @Override
    public double getMaxCapacity() {
        return maxWeight;
    }

    @Override
    public String getType() {
        return "Cold Storage";
    }

    @Override
    public void addItem(Item item) {

    }

    @Override
    public Item getItem(String name) {
        return null;
    }

    @Override
    public List<Item> getContents() {
        return null;
    }


}
