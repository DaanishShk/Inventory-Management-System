package domain.containers;

import domain.items.Item;

import java.util.Map;

public interface Container {
    double getMaxCapacity();
    String getType();
    void addItem(Item item, int qty);
    Item getItem(String name);
    Map<Item, Integer> getContents();
    void printContents();
    int getID();
}
