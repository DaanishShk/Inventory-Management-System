package ui.buffer;

import domain.items.Item;

/**
 * Buffer class specifically for Item objects. Utilizes the Buffer generic class.
 * Methods added to handle Item related operations on Buffer.
 * @see Item
 * @see Buffer
 *
 * @param buffer Used as staging area for item transfer to container.
 *
 * @author DaanishShk
 * @version 1.0
 */

import java.util.ArrayList;

public class ItemBuffer {

    private Buffer<Item> buffer;

    public ItemBuffer() {
        this.buffer = new Buffer<>();
    }

    public void add(Item item) {
        this.buffer.add(item);
    }

    /**
     * Removal of Item using a passed name attribute
     * @param name string name of the item object to be removed
     */
    public void remove(String name) {
        Item i = this.getItem(name);
        if(i!=null) this.buffer.remove(i);
    }

    /**
     * Gets Item from buffer object.
     * @param name
     * @return returns Item if found, otherwise null
     */
    private Item getItem(String name) {
        for(Item i: this.buffer.getList()) {
            if(i.getName().equalsIgnoreCase(name)) return i;
        }
        return null;
    }

    public void clear() {
        this.buffer.flush();
    }

    public void print() {
        this.buffer.printContents();
    }

    public ArrayList<Item> getList() {
        return this.buffer.getList();
    }
}


