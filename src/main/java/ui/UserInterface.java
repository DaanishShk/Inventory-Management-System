package ui;

import java.util.Scanner;

import domain.containers.Box;
import domain.containers.Container;
import domain.items.Item;
import logic.Warehouse;
import ui.buffer.ItemBuffer;

public class UserInterface {

    private Scanner scanner;
    private Warehouse warehouse;
    private BufferInterface bufferUI;

    public UserInterface(Scanner scanner, Warehouse warehouse) {
        this.scanner = scanner;
        this.warehouse = warehouse;
        this.bufferUI = new BufferInterface(scanner);
    }

    public void start() {
        System.out.println("\t\t-------Inventory Management System-------");

        while(true) {
            System.out.println();
            this.menu();
            int option = Integer.parseInt(scanner.nextLine());
            System.out.println();

            if(option == 6) {
                break;
            }

            if(option == 1) {
                this.addContainer();
            } else if(option == 2) {
                this.bufferMenu();
            } else if(option == 3){
                this.transferItems();
            } else if(option == 4) {
                this.containerContents();
            } else if(option == 5) {
                this.warehouseContents();
            } else {
                System.out.println("Wrong choice entered. Try again.");
            }
        }
        System.out.println();
        System.out.println("GOOD BYE...");
    }

    private void menu() {
        System.out.println("1. Create new container");
        System.out.println("2. Item buffer menu");
        System.out.println("3. Add items to container");
        System.out.println("4. Check contents of container");
        System.out.println("5. View Warehouse contents");
        System.out.println("6. Exit");
        System.out.print("Enter choice(num):");
    }

    private void addContainer() {
        System.out.print("Enter maximum weight:");
        int maxWeight = Integer.parseInt(scanner.nextLine());
        this.warehouse.addContainer(new Box(maxWeight));
    }

    private void bufferMenu() {
        this.bufferUI.start();
    }

    private void transferItems() {
        System.out.print("Enter container ID:");
        int id = Integer.parseInt(scanner.nextLine());
        Container c = this.warehouse.getContainer(id);
        this.bufferUI.transferToContainer(c);
    }

    private void containerContents() {
        System.out.print("Enter container ID:");
        int id = Integer.parseInt(scanner.nextLine());
        this.warehouse.getContainer(id).printContents();
    }

    private void warehouseContents() {
        this.warehouse.printContainers();
    }
}
