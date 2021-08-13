package domain.containers;

import domain.items.Item;

import java.util.List;

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
