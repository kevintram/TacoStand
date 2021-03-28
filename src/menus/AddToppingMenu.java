package menus;

import Util.FoodDirectory;
import Util.Request.FoodRequest;
import navigation.Menu;
import navigation.MenuController;
import navigation.MenuOption;
import orderable.Topping;
import orderable.ToppingDecorator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class AddToppingMenu extends Menu {
    FoodRequest foodRequest;

    AddToppingMenu(FoodRequest foodRequest) {
        this.foodRequest = foodRequest;
    }

    @Override
    protected String getPrompt() {
        return "Choose a topping to add";
    }

    @Override
    protected ArrayList<MenuOption> getOptions() {
        ArrayList<MenuOption> options = new ArrayList<>();

        Set<Topping> unaddedToppings = new HashSet<>(Set.of(FoodDirectory.TOPPINGS));

        Set<Topping> addedToppings =
                (foodRequest.getOrderable() instanceof ToppingDecorator)? Set.of(((ToppingDecorator) foodRequest.getOrderable()).getToppings()) : Set.of();

        unaddedToppings.removeAll(addedToppings);

        for (Topping t : unaddedToppings) {
            options.add(new MenuOption(
                    t.getString(),
                    () -> {
                        foodRequest.setOrderable(new ToppingDecorator(foodRequest.getOrderable(), t));
                        MenuController.getInstance().popBackStack();
                    }
            ));
        }

        options.add(new MenuOption(
                "Cancel",
                () -> MenuController.getInstance().popBackStack()
        ));

        return options;
    }

    @Override
    public boolean isPopBackStackInclusive() {
        return false;
    }
}
