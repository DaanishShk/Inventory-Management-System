package ui.buffer;

import domain.items.wieghtBased.Item;

import java.util.ArrayList;

public class ItemBuffer {

    private Buffer<Item> buffer;

    public ItemBuffer() {
        this.buffer = new Buffer<>();
    }

    public void add(Item item) {
        this.buffer.add(item);
    }

    public void remove(String name) {
        Item i = this.getItem(name);
        if(i!=null) this.buffer.remove(i);
    }

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


