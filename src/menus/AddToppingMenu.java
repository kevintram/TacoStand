package menus;

import orderable.Orderable;
import util.FoodDirectory;
import util.request.FoodRequest;
import navigation.Menu;
import navigation.MenuController;
import navigation.MenuOption;
import orderable.Topping;
import orderable.ToppingDecorator;

import java.util.*;

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

        Set<Topping> unaddedToppings = new HashSet<>(Arrays.asList(FoodDirectory.TOPPINGS));


        Set<Topping> addedToppings;

        Orderable orderable = foodRequest.getOrderable();
        if (orderable instanceof ToppingDecorator) {
            addedToppings = new HashSet<>(Arrays.asList(((ToppingDecorator) orderable).getToppings()));
        } else {
            addedToppings = Collections.emptySet();
        }

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
