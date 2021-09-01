package ui;

import domain.containers.Container;
import domain.containers.liquidBased.Barrel;
import domain.containers.liquidBased.liquidBasedContainer;
import domain.containers.weightBased.Box;
import domain.containers.weightBased.ColdStorage;
import domain.containers.weightBased.weightBasedContainer;
import logic.Warehouse;

import java.util.Scanner;

import static ui.Input.input;

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
        System.out.print("Weight(1) or Liquid(2) type container:");
        String i = scanner.nextLine().trim();

        if(i.equals("1")) {
            this.weightBasedContainer();
        } else if (i.equals("2")) {
            this.liquidBasedContainer();
        } else {
            System.out.println("Wrong choice. Try again.");
        }
    }

    private void weightBasedContainer() {
        weightBasedContainer container;
        System.out.print("Box(1) or ColdStorage(2) item:");
        String i = scanner.nextLine().trim();

        if(i.equals("1")) {
            container = new Box();
        } else if(i.equals("2")) {
            System.out.print("Enter temperature:");
            container = new ColdStorage(input(scanner));
        } else {
            System.out.println("Wrong choice. Try again.");
            return;
        }

        System.out.print("Enter maximum weight:");
        container.setMaxWeight(input(scanner));

        this.warehouse.addContainer(container);
        System.out.println("Container added to warehouse.\n");
    }

    private void liquidBasedContainer() {
        System.out.print("Enter maximum volume:");
        liquidBasedContainer container = new Barrel(input(scanner));

        this.warehouse.addContainer(container);
        System.out.println("Container added to warehouse.\n");
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
