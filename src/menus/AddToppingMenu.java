package menus;

import navigation.Menu;
import navigation.MenuController;
import navigation.MenuOption;
import orderable.FoodBase;
import orderable.Topping;
import orderable.ToppingDecorator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class AddToppingMenu extends Menu {
    FoodBase food;

    AddToppingMenu(UUID id) {
        food = (FoodBase) Order.getOrderable(id);
    }

    @Override
    protected String getPrompt() {
        return "Choose a topping to add";
    }

    @Override
    protected ArrayList<MenuOption> getOptions() {
        ArrayList<MenuOption> options = new ArrayList<>();

        if (food instanceof ToppingDecorator) {
            Set<Topping> unaddedToppings = new HashSet<>(Set.of(FoodDirectory.TOPPINGS));

            Set<Topping> addedToppings =
                    (food instanceof ToppingDecorator)? Set.of(((ToppingDecorator) food).getToppings()) : Set.of();

            unaddedToppings.removeAll(addedToppings);

            for (Topping t : unaddedToppings) {
                options.add(new MenuOption(
                        t.getString(),
                        () -> {
                            food = new ToppingDecorator(food, t);
                            Order.updateOrderable(food);
                            MenuController.getInstance().popBackStack();
                        }
                ));
            }
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
