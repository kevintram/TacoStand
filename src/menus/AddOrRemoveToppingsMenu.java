package menus;

import navigation.Menu;
import navigation.MenuController;
import navigation.MenuOption;
import orderable.FoodBase;

import java.util.ArrayList;
import java.util.UUID;

public class AddOrRemoveToppingsMenu extends Menu {
    private FoodBase food;

    AddOrRemoveToppingsMenu(UUID foodId) {
        food = (FoodBase) Order.getOrderable(foodId);
    }

    @Override
    public void onNavigated() {
        food = (FoodBase) Order.getOrderable(food.getId());
        super.onNavigated();
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
                () -> MenuController.getInstance().navigate(new RemoveToppingMenu(food.getId()))
        ));

        options.add(new MenuOption(
                "Add a topping",
                () -> MenuController.getInstance().navigate(new AddToppingMenu(food.getId()))
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