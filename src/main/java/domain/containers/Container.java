package domain.containers;

import domain.items.Item;

import java.util.List;

public interface Container {

    double getMaxCapacity();
    String getType();
    void addItem(Item item);
    Item getItem(String name);
    List<Item> getContents();
}
