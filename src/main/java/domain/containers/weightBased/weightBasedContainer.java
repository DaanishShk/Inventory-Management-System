package domain.containers.weightBased;

import domain.containers.Container;
import domain.items.wieghtBased.weightBased;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public abstract class weightBasedContainer<ItemType extends weightBased> implements Container<ItemType> {

    double maxWeight;
    Map<ItemType, Integer> items;
    int id;
    String type;

    public weightBasedContainer(double maxWeight, String type) {
        this.maxWeight = maxWeight;
        this.items = new HashMap<>();
        this.type = type;
        this.id = this.hashCode(); // Temporary id using hashcode
    }

    public abstract String toString();

    public boolean addItem(ItemType item, double qty) {

        if(qty <= 0) return false; // qty must be >0

//         Update if item already exists
//        if(this.getItem(item.getName())) {
//            this.items.put(item, this.items.get(item)+1);
//            return true;
//        }      Commented because Items with same name can have different attributes
//         otherwise, add new entry to map after checking weight constraint

        item = this.checkItemInList(item); // If identical object exists update that instead

        if(this.getTotalWeight()+qty*item.getWeight() <= this.maxWeight) {
            this.items.put(item, (int)qty);
            return true;
        }
        return false;
    }

    private ItemType checkItemInList(ItemType item) {
        for(ItemType i: this.items.keySet()) {
            if(i.equals(item)) return i;
        }
        return item;
    }

    // Overloaded item checking function
    public boolean checkItem(String name) {
        for(ItemType i: this.items.keySet()) {
            if(i.getName().equalsIgnoreCase(name)) return true;
        }
        return false;
    }

    public boolean checkItem(ItemType item) {
        for(ItemType i: this.items.keySet()) {
            if(i.equals(item)) return true;
        }
        return false;
    }

    // Overloaded to get requested item
    public ItemType getItem(String name) {
        for(ItemType i: this.items.keySet()) {
            if(i.getName().equalsIgnoreCase(name)) return i;
        }
        return null;
    }

    public ItemType getItem(ItemType item) {
        for(ItemType i: this.items.keySet()) {
            if(i.equals(item)) return i;
        }
        return null;
    }

    public double getTotalWeight() {
        double weight = 0;
        for(ItemType i: this.items.keySet()) {
            weight += i.getWeight() * this.items.get(i);
        }
        return weight;
    }

    public void printContents() {
        System.out.println("Contents of "+this.type+":");
        int cnt = 1;
        for(ItemType i: this.items.keySet()) {
            System.out.println(cnt+". "+i+"\tQuantity: "+this.items.get(i));
            cnt++;
        }
    }
}

