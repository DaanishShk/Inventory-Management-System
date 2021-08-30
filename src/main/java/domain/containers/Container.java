package domain.containers;

import domain.items.Item;


public interface Container<ItemType extends Item> {
    boolean addItem(ItemType item, double qty);  //Make int qty to double qty for liquid container//Conflicting with abstract container class
    void printContents();
    int getId();
    String getType();
}
