package domain.containers;

import domain.items.Item;

import java.util.List;

public class Barrel implements Container{

    private double maxVolume;

    public Barrel(double maxVolume) {
        this.maxVolume = maxVolume;
    }

    @Override
    public double getMaxCapacity() {
        return this.maxVolume;
    }

    @Override
    public String getType() {
        return "Barrel";
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

    @Override
    public int getID() {
        return 0;
    }
}
