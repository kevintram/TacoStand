package menus;

import navigation.Menu;
import navigation.MenuController;
import navigation.MenuOption;
import orderable.Topping;
import orderable.ToppingDecorator;

import java.util.ArrayList;

public class RemoveToppingMenu extends Menu {
    FoodManager foodManager;

    RemoveToppingMenu(FoodManager foodManager) {
        this.foodManager = foodManager;
    }

    @Override
    protected String getPrompt() {
        return "Choose a topping to remove";
    }

    @Override
    public void printPrefix() {
        if (!(foodManager.getOrderable() instanceof ToppingDecorator)) {
            System.out.println("You don't have any toppings!");
        }
    }

    @Override
    protected ArrayList<MenuOption> getOptions() {
        ArrayList<MenuOption> options = new ArrayList<>();

        if (foodManager.getOrderable() instanceof ToppingDecorator) {
            Topping[] toppings = ((ToppingDecorator) foodManager.getOrderable()).getToppings();

            for (Topping t : toppings) {
                options.add(new MenuOption(
                        t.getString(),
                        () -> {
                            foodManager.setOrderable(((ToppingDecorator) foodManager.getOrderable()).remove(t));
                            MenuController.getInstance().popBackStack();
                        }
                ));
            }

        }

        options.add(new MenuOption(
                "Go Back",
                () -> MenuController.getInstance().popBackStack()
        ));

        return options;
    }

    @Override
    public boolean isPopBackStackInclusive() {
        return false;
    }
}
