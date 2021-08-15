package domain.containers;

import domain.items.Item;

import java.util.Map;

public class Misc implements Container {

    private double maxQuantity;

    public Misc(double maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    @Override
    public double getMaxCapacity() {
        return this.maxQuantity;
    }

    @Override
    public String getType() {
        return "Custom Container";
    }

    @Override
    public void addItem(Item item, int qty) {

    }

    @Override
    public Item getItem(String name) {
        return null;
    }

    @Override
    public Map<Item, Integer> getContents() {
        return null;
    }

    @Override
    public void printContents() {

    }

    @Override
    public int getID() {
        return 0;
    }
}
