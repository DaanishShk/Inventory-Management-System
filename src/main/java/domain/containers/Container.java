package domain.containers;

import domain.items.wieghtBased.Item;


public interface Container<ItemType extends Item> {
    boolean addItem(ItemType item, int qty);  //Conflicting with abstract container class
    void printContents();
    int getId();
}
