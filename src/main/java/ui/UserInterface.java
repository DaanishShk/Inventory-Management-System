package ui;

import java.util.Scanner;
import domain.containers.Container;
import logic.Warehouse;

public class UserInterface {

    private Scanner scanner;
    private Warehouse warehouse;

    public UserInterface(Scanner scanner, Warehouse warehouse) {
        this.scanner = scanner;
        this.warehouse = warehouse;
    }

    public void start() {
        System.out.println("\t\t-------Inventory Management System-------\n\n");

        while(true) {
            this.menu();
            int option = Integer.parseInt(scanner.nextLine());

            if(option == 5) {
                break;
            }

//            if(option == 1) {
//
//            }
        }
    }

    private void menu() {
        System.out.println("1. Create new container");
        System.out.println("2. Edit/Create item");
        System.out.println("3. View contents of Warehouse");
        System.out.println("4. Display contents of container");
        System.out.println("5. Exit");
        System.out.print("Enter choice(num):");
    }
}
