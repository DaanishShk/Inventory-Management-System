import logic.Warehouse;
import ui.UserInterface;

import java.util.Scanner;

public class ApplicationStart {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Warehouse warehouse = new Warehouse(10);

        UserInterface ui = new UserInterface(scan, warehouse);
        ui.start();
    }
}
