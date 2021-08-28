package ui;

import domain.containers.Container;
import domain.containers.weightBased.Box;
import logic.Warehouse;

import java.util.Scanner;

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
            String option = scanner.nextLine().trim();
            System.out.println();

            if(option.equals("6")) {
                break;
            }

            if(option.equals("1")) {
                this.addContainer();
            } else if(option.equals("2")) {
                this.bufferMenu();
            } else if(option.equals("3")){
                this.transferItems();
            } else if(option.equals("4")) {
                this.containerContents();
            } else if(option.equals("5")) {
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
        try {
            double maxWeight = Double.parseDouble(scanner.nextLine().trim());
            this.warehouse.addContainer(new Box(maxWeight));
        } catch (NumberFormatException e) {
            System.out.println("Input error. Try again.");
        }
        System.out.println("Container added to warehouse.");
    }

    private void bufferMenu() {
        this.bufferUI.start();
    }

    private void transferItems() {
        System.out.print("Enter container ID:");
        try {
            int id = Integer.parseInt(scanner.nextLine().trim());
            Container c = this.warehouse.getContainer(id);
            this.bufferUI.transferToContainer(c);
        } catch (NumberFormatException e) {
            System.out.println("Input error. Try again.");
        }
    }

    private void containerContents() {
        try {
            System.out.print("Enter container ID:");
            int id = Integer.parseInt(scanner.nextLine());
            this.warehouse.getContainer(id).printContents();
        } catch (NumberFormatException e) {
            System.out.println("Input error. Try again.");
        }
    }

    private void warehouseContents() {
        this.warehouse.printContainers();
    }
}
