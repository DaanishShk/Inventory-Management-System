package ui;

import domain.containers.Container;
import domain.items.Item;
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
        while(true) {
            System.out.println();
            this.menu();
            int option = Integer.parseInt(scanner.nextLine());
            System.out.println();

            if(option == 4) {
                break;
            }

            if(option == 1) {
                this.newItem();
            } else if(option == 2) {
                this.removeItem();
            } else if(option == 3){
                this.clearItems();
            } else {
                System.out.println("Wrong choice entered. Try again.");
            }
        }
    }

    private void menu() {
        System.out.println("1. Create new item");
        System.out.println("2. Remove existing item");
        System.out.println("3. Clear items from buffer");
        System.out.println("4. Go back");
        System.out.print("Enter choice(num):");
    }

    private void newItem() {
        System.out.print("Enter name:");
        String name = scanner.nextLine();
        System.out.print("Enter type of item value (Weight or Volume):");
        String type;
        while(true) {
            type = scanner.nextLine();
            if(type.equalsIgnoreCase("weight") || type.equalsIgnoreCase("volume")) break;
            System.out.print("Wrong type. Enter again:");
        }
        System.out.print("Enter item value:");
        int val = Integer.parseInt(scanner.nextLine());
        this.itemBuffer.add(new Item(name, val, type));
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

    public void transferToContainer(Container container) {
        System.out.println("Enter 0 to skip item.");
        for(Item i: this.itemBuffer.getList()) {
            System.out.print("Enter quantity for item "+i.getName()+": ");
            int qty = Integer.parseInt(scanner.nextLine());
            if(qty>0) container.addItem(i, qty);
        }
    }
}
