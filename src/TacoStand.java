import menus.MainMenu;
import navigation.Menu;
import navigation.MenuController;

import java.util.Scanner;

public class TacoStand {
    public static void main(String[] args) {
        MenuController menuController = MenuController.getInstance();
        menuController.navigate(new MainMenu());

        Scanner scan = new Scanner(System.in);

        while (!menuController.isBackStackEmpty()) {
            Menu menu = menuController.getCurrMenu();

            menu.print();

            int response;

            try {
                response = Integer.parseInt(scan.nextLine());
                menu.choose(response);
                System.out.println();
            } catch(NumberFormatException  e) {
                System.out.println("Error: Please input a number.");
                System.out.println();
            }

        }
    }
}
