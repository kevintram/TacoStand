package menus;

import util.request.FoodRequest;
import navigation.Menu;
import navigation.MenuController;
import navigation.MenuOption;

import java.util.ArrayList;

public class AddOrRemoveToppingsMenu extends Menu {
    FoodRequest foodRequest;
    AddOrRemoveToppingsMenu(FoodRequest foodRequest) {
        this.foodRequest = foodRequest;
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
                () -> MenuController.getInstance().navigate(new RemoveToppingMenu(foodRequest))
        ));

        options.add(new MenuOption(
                "Add a topping",
                () -> MenuController.getInstance().navigate(new AddToppingMenu(foodRequest))
        ));

        options.add(new MenuOption(
                "Finish",
                () -> {
                    foodRequest.onRequestFinishedListener.onFinish(foodRequest.getOrderable());
                    MenuController.getInstance().popBackStack();
                }
        ));

        return options;
    }

    @Override
    public void printPrefix() {
        System.out.println("Here's what you have so far: ");
        System.out.println(foodRequest.getOrderable().getString());
        System.out.println();
    }

    @Override
    public boolean isPopBackStackInclusive() {
        return false;
    }
}