package menus;

import navigation.Menu;
import navigation.MenuController;
import navigation.MenuOption;

import java.util.ArrayList;

public class AddOrRemoveToppingsMenu extends Menu {
    FoodManager foodManager;
    AddOrRemoveToppingsMenu(FoodManager foodManager) {
        this.foodManager = foodManager;
    }

    @Override
    public void onNavigated() {
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
                () -> MenuController.getInstance().navigate(new RemoveToppingMenu(foodManager))
        ));

        options.add(new MenuOption(
                "Add a topping",
                () -> MenuController.getInstance().navigate(new AddToppingMenu(foodManager))
        ));

        options.add(new MenuOption(
                "Finish",
                () -> {
                    foodManager.onOrderableFinishedListener.onOrderableFinished(foodManager.getOrderable());
                    MenuController.getInstance().popBackStack();
                }
        ));

        return options;
    }

    @Override
    public void printPrefix() {
        System.out.println("Here's what you have so far: ");
        System.out.println(foodManager.getOrderable().getString());
        System.out.println();
    }

    @Override
    public boolean isPopBackStackInclusive() {
        return false;
    }
}