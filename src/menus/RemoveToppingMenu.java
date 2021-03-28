package menus;

import navigation.Menu;
import navigation.MenuController;
import navigation.MenuOption;
import orderable.Combo;
import orderable.FoodBase;
import orderable.Topping;
import orderable.ToppingDecorator;

import java.util.ArrayList;
import java.util.UUID;

public class RemoveToppingMenu extends Menu {
    FoodBase food;
    Combo combo;

    RemoveToppingMenu(UUID id) {
        this.food = (FoodBase) Order.getOrderable(id);
        this.combo = null;
    }

    RemoveToppingMenu(FoodBase food, Combo combo) {
        this.food = food;
        this.combo = combo;
    }

    @Override
    protected String getPrompt() {
        return "Choose a topping to remove";
    }

    @Override
    public void printPrefix() {
        if (!(food instanceof ToppingDecorator)) {
            System.out.println("You don't have any toppings!");
        }
    }

    @Override
    protected ArrayList<MenuOption> getOptions() {
        ArrayList<MenuOption> options = new ArrayList<>();

        if (food instanceof ToppingDecorator) {
            Topping[] toppings = ((ToppingDecorator) food).getToppings();

            for (Topping t : toppings) {
                options.add(new MenuOption(
                        t.getString(),
                        () -> {
                            food = ((ToppingDecorator) food).remove(t);
                            updateFood(food);
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

    private void updateFood(FoodBase food) {
        if (combo != null) {
            combo.update(food);
        } else {
            Order.updateOrderable(food);
        }
    }

    @Override
    public boolean isPopBackStackInclusive() {
        return false;
    }
}
