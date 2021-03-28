package menus;

import navigation.Menu;
import navigation.MenuController;
import navigation.MenuOption;
import orderable.Combo;
import orderable.FoodBase;

import java.util.ArrayList;
import java.util.UUID;

public class AddOrRemoveToppingsMenu extends Menu {
    private FoodBase food;
    private Combo combo;

    AddOrRemoveToppingsMenu(UUID foodId) {
        food = (FoodBase) Order.getOrderable(foodId);
        combo = null;
    }

    AddOrRemoveToppingsMenu(FoodBase food, Combo combo) {
        this.food = food;
        this.combo = combo;
    }

    @Override
    public void onNavigated() {
        if (combo == null) {
            food = (FoodBase) Order.getOrderable(food.getId());
        } else {
            food = (FoodBase) combo.get(food.getId());
        }
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
                this::navigateToRemoveToppingsMenu
        ));

        options.add(new MenuOption(
                "Add a topping",
                this::navigateToAddToppingsMenu
        ));

        options.add(new MenuOption(
                "Finish",
                () -> {
                    if (combo != null) {
                        Order.insertOrderable(combo);
                    }
                    MenuController.getInstance().popBackStack();
                }
        ));

        return options;
    }

    private void navigateToRemoveToppingsMenu() {
        if (combo != null) {
            MenuController.getInstance().navigate(new RemoveToppingMenu(food, combo));
        } else {
            MenuController.getInstance().navigate(new RemoveToppingMenu(food.getId()));
        }
    }

    private void navigateToAddToppingsMenu() {
        if (combo != null) {
            MenuController.getInstance().navigate(new AddToppingMenu(food, combo));
        } else {
            MenuController.getInstance().navigate(new AddToppingMenu(food.getId()));
        }
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