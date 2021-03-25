import menus.MainMenu;
import navigation.Menu;
import navigation.MenuController;
import java.util.Scanner;

public class TacoStand {
    public static void main(String[] args) {
        MenuController menuController = MenuController.getInstance();
        menuController.navigate(new MainMenu());

        Scanner scan = new Scanner(System.in);

        while (!menuController.isEmpty()) {
            Menu menu = menuController.getCurrMenu();

            menu.print();

            int response = scan.nextInt();
            menu.choose(response);

            System.out.println();
        }
    }
}
