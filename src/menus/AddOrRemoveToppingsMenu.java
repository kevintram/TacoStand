package menus;

import navigation.Menu;
import navigation.MenuOption;
import orderable.FoodBase;

import java.util.ArrayList;

public class AddOrRemoveToppingsMenu extends Menu {
    FoodBase food;

    AddOrRemoveToppingsMenu(FoodBase food) {
        this.food = food;
    }

    @Override
    protected String getPrompt() {
        return "Remove or add any toppings?";
    }

    @Override
    protected ArrayList<MenuOption> getOptions() {
        ArrayList<MenuOption> options = new ArrayList<>();

        options.add(new MenuOption(
                "Remove a topping",
                () -> {}
        ));

        options.add(new MenuOption(
                "Add a topping",
                () -> {}
        ));

        options.add(new MenuOption(
                "Finish",
                () -> {}
        ));

        return options;
    }

    @Override
    public void printPrefix() {
        System.out.println("Here's what you have so far: ");
        System.out.println(food.getString());
        System.out.println();
    }

    @Override
    public boolean isPopBackStackInclusive() {
        return false;
    }
}