package ui;

import domain.containers.Container;
import domain.items.Item;
import domain.items.liquidBased.Liquid;
import domain.items.wieghtBased.coldItem;
import domain.items.wieghtBased.dryItem;
import domain.items.wieghtBased.weightBased;
import ui.buffer.ItemBuffer;

import java.util.Scanner;

import static ui.Input.input;

public class BufferInterface {

    private ItemBuffer itemBuffer;
    private Scanner scanner;

    public BufferInterface( Scanner scanner) {
        this.itemBuffer = new ItemBuffer();
        this.scanner = scanner;
    }

    public void start() {
        System.out.println("---Item Buffer---");
        while(true) {
            System.out.println();
            this.menu();
            String option = scanner.nextLine().trim();
            System.out.println();

            if(option.equals("5")) {
                break;
            }

            if(option.equals("1")) {
                this.newItem();
            } else if(option.equals("2")) {
                this.removeItem();
            } else if(option.equals("3")){
                this.clearItems();
            } else if(option.equals("4")){
                this.viewItems();
            } else {
                System.out.println("Wrong choice entered. Try again.");
            }
        }
    }

    private void menu() {
        System.out.println("1. Create new item");
        System.out.println("2. Remove existing item");
        System.out.println("3. Clear items from buffer");
        System.out.println("4. View items in buffer");
        System.out.println("5. Go back");
        System.out.print("Enter choice(num):");
    }

    private void newItem() {
        System.out.print("Weight(1) or liquid(2) type item:");

        String i = scanner.nextLine().trim();

        if(i.equals("1")) {
            this.weightBasedItem();
        } else if (i.equals("2")) {
            this.liquidBasedItem();
        } else {
            System.out.println("Wrong choice. Try again.");
        }
    }

    private void weightBasedItem() {
        weightBased item;

        System.out.print("Enter name:");
        String name = scanner.nextLine().trim();

        System.out.print("Dry(1) or Cold(2) item:");
        String i = scanner.nextLine().trim();

        if(i.equals("1")) {
            item = new dryItem();
        } else if(i.equals("2")) {
            System.out.print("Enter temperature:");
            item = new coldItem(input(scanner));
        } else {
            System.out.println("Wrong choice. Try again.");
            return;
        }

        System.out.print("Enter weight:");
        double weight = input(scanner);

        item.setName(name);
        item.setWeight(weight);

        this.itemBuffer.add(item);
        System.out.println("Item added to buffer.\n");
    }

    private void liquidBasedItem() {
        System.out.print("Enter name:");
        String name = scanner.nextLine().trim();

        this.itemBuffer.add(new Liquid(name));
        System.out.println("Item added to buffer.\n");
    }

    private void removeItem() {
        System.out.print("Enter name:");
        String name = scanner.nextLine();
        this.itemBuffer.remove(name);
    }

    private void clearItems() {
        this.itemBuffer.clear();
    }

    private void viewItems() {
        this.itemBuffer.print();
    }

    public void transferToContainer(Container container) {
        System.out.println("Enter 0 to skip item.");

        int type = TypeChecker.containerType(container.getType());
        //System.out.println("Type is "+type);
        for(Item i: this.itemBuffer.getList()) {
            //System.out.println("item type = "+i.getType());
            if(i.getType() != type) {
                System.out.println(i.getName()+" skipped as incompatible");
                continue;
            }
            System.out.print("Enter quantity(or volume) for item "+i.getName()+": ");
            container.addItem(i, input(scanner));
        }
    }

}
