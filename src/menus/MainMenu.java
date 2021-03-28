package menus;

import navigation.Menu;
import navigation.MenuController;
import navigation.MenuOption;
import orderable.Combo;
import orderable.Orderable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MainMenu extends Menu {

    @Override
    protected String getPrompt() {
        return "Choose something from the menu";
    }

    @Override
    protected ArrayList<MenuOption> getOptions() {
        ArrayList<MenuOption> options = new ArrayList<>();

        options.add(new MenuOption(
                "Taco, Burrito, Bowl",
                () -> MenuController.getInstance().navigate(new ChooseBaseMenu())
        ));

        options.add(new MenuOption(
                "Taco Salad",
                "bowl with 3 crushed tacos" ,
                () -> {
                    Queue<FoodBaseType> foodQueue = new LinkedList<>();
                    for (int i = 0; i < 3; i++) {
                        foodQueue.add(FoodBaseType.TACO);
                    }

                    Combo combo = new Combo("Taco Salad","bowl with 3 crushed tacos");
                    MenuController.getInstance().navigate(new ComboChooseSignatureOrCustomMenu(foodQueue, combo));
                }
        ));

        options.add(new MenuOption(
                "Double-decker Taco",
                "taco inside a taco",
                () -> {

                }
        ));

        options.add(new MenuOption(
                "Order of Tacos",
                "3 tacos",
                () -> {

                }
        ));

        options.add(new MenuOption(
                "Traveler's Pack",
                "2 tacos, 1 burrito",
                () -> {

                }
        ));

        options.add(new MenuOption(
                "Sample Pack",
                "1 taco, 1 burrito, 1 bowl",
                () -> {

                }
        ));

        options.add(new MenuOption(
                "Party Platter",
                "3 orders of tacos, 2 burritos, 1 bowl",
                () -> {

                }
        ));

        options.add(new MenuOption(
                "Finish Order",
                () -> {
                    System.out.println("Here is your order: ");
                    for (Orderable o : Order.getOrder()) {
                        System.out.println(o.getString());
                    }
                    MenuController.getInstance().popBackStack();
                }
        ));

        return options;
    }

    @Override
    public boolean isPopBackStackInclusive() {
        return false;
    }
}
