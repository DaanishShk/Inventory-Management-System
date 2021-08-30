package ui;

import domain.containers.Container;
import domain.items.Item;
import domain.items.wieghtBased.dryItem;
import ui.buffer.ItemBuffer;

import java.util.Scanner;

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
        System.out.print("Enter name:");
        String name = scanner.nextLine();
        System.out.print("Weight(1) or liquid(2) type item:");

        Item item;
        try {
            int i = Integer.parseInt(scanner.nextLine().trim());
            if(i == 1) {
                System.out.println("Dry(1) or Cold(2) item:");
                i = Integer.parseInt(scanner.nextLine().trim());
                if(i == 1) item = new dryItem()
            }
        }
        System.out.print("Enter item value:");
        try {
            double weight = Double.parseDouble(scanner.nextLine().trim());
            this.itemBuffer.add(new dryItem(name, weight));
            System.out.println("Item added to buffer.\n");
        } catch (NumberFormatException e) {
            System.out.print("Input error. Try again.");
        }
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
        for(Item i: this.itemBuffer.getList()) {
            System.out.print("Enter quantity for item "+i.getName()+": ");
            while(true) {
                try {
                    int qty = Integer.parseInt(scanner.nextLine().trim());
                    if(qty>0) container.addItem(i, qty);
                    break;
                } catch (NumberFormatException e) {
                    System.out.print("Input error. Try again.");
                }
            }
        }
    }
}
