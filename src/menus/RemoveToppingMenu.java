package menus;

import util.request.FoodRequest;
import navigation.Menu;
import navigation.MenuController;
import navigation.MenuOption;
import orderable.Topping;
import orderable.ToppingDecorator;

import java.util.ArrayList;

public class RemoveToppingMenu extends Menu {
    FoodRequest foodRequest;

    RemoveToppingMenu(FoodRequest foodRequest) {
        this.foodRequest = foodRequest;
    }

    @Override
    protected String getPrompt() {
        return "Choose a topping to remove";
    }

    @Override
    public void printPrefix() {
        if (!(foodRequest.getOrderable() instanceof ToppingDecorator)) {
            System.out.println("You don't have any toppings!");
        }
    }

    @Override
    protected ArrayList<MenuOption> getOptions() {
        ArrayList<MenuOption> options = new ArrayList<>();

        if (foodRequest.getOrderable() instanceof ToppingDecorator) {
            Topping[] toppings = ((ToppingDecorator) foodRequest.getOrderable()).getToppings();

            for (Topping t : toppings) {
                options.add(new MenuOption(
                        t.getString(),
                        () -> {
                            foodRequest.setOrderable(((ToppingDecorator) foodRequest.getOrderable()).remove(t));
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
