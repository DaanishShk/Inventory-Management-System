package ui;

import java.util.ArrayList;
import java.util.Scanner;

import domain.containers.Box;
import domain.containers.Container;
import domain.items.Item;
import logic.Warehouse;

public class UserInterface {

    private Scanner scanner;
    private Warehouse warehouse;
    private ArrayList<Item> itemBuffer;

    public UserInterface(Scanner scanner, Warehouse warehouse) {
        this.scanner = scanner;
        this.warehouse = warehouse;
        this.itemBuffer = new ArrayList<>();
    }

    public void start() {
        System.out.println("\t\t-------Inventory Management System-------");

        while(true) {
            System.out.println();
            this.menu();
            int option = Integer.parseInt(scanner.nextLine());
            System.out.println();

            if(option == '6') {
                break;
            }

            if(option == 1) {
                this.addContainer();
            } else if(option == 2) {
                this.addToBuffer();
            } else if(option == 3){
                this.flushBuffer();
            } else if(option == 4) {
                this.warehouse.printContainers();
            } else if(option == 5) {
                this.containerContents();
            } else {
                System.out.println("Wrong choice entered. Try again.");
            }
        }
    }

    private void menu() {
        System.out.println("1. Create new container");
        System.out.println("2. Add new item to buffer");
        System.out.println("3. Put buffer items in container");
        System.out.println("4. View contents of Warehouse");
        System.out.println("5. Display contents of container");
        System.out.println("6. Exit");
        System.out.print("Enter choice(num):");
    }

    private void addContainer() {
        System.out.print("Enter maximum weight:");
        int maxWeight = Integer.parseInt(scanner.nextLine());
        this.warehouse.addContainer(new Box(maxWeight));
    }

    private void addToBuffer() {
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

    private void flushBuffer() {
        System.out.print("Enter container ID:");
        int id = Integer.parseInt(scanner.nextLine());
        Container c = this.warehouse.getContainer(id);

        for(Item i: this.itemBuffer) {
            System.out.print("Enter quantity for item "+i.getName()+": ");
            int qty = Integer.parseInt(scanner.nextLine());
            c.addItem(i, qty);
        }
    }

    private void containerContents() {
        System.out.print("Enter container ID:");
        int id = Integer.parseInt(scanner.nextLine());
        this.warehouse.getContainer(id).printContents();
    }
}
