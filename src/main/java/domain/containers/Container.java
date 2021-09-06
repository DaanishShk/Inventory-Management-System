package domain.containers;

import domain.items.Item;

/**
 * Abstract Container class for interfacing with Warehouse objects (storage & removal).
 * Implemented by all container objects
 * @see weightBasedContainer
 * @see liquidBasedContainer
 *
 * @param <ItemType>
 *                  Accepts only objects of type Item.
 *
 * @author DaanishShk
 * @version 1.0
 *
 */
public interface Container<ItemType extends Item> {
    boolean addItem(ItemType item, double qty);  //Make int qty to double qty for liquid container//Conflicting with abstract container class
    void printContents();
    int getId();
    String getType();
}
