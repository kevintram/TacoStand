package menus;

import navigation.Menu;
import navigation.MenuController;
import navigation.MenuOption;
import orderable.*;

import java.util.ArrayList;

public class ChooseSignatureOrCustomMenu extends Menu {
    FoodManager foodManager;

    ChooseSignatureOrCustomMenu(FoodManager foodManager) {
        super();
        this.foodManager = foodManager;
    }

    @Override
    protected String getPrompt() {
        return "Choose a signature or build your own";
    }

    @Override
    protected ArrayList<MenuOption> getOptions() {
        ArrayList<MenuOption> options = new ArrayList<>();

        options.add(new MenuOption(
                "Bada Beef Bada Boom",
                "steak, lettuce, corn, guac",
                () -> {
                    foodManager.initFood(FoodDirectory.STEAK);
                    foodManager.setOrderable(getToppingDecorator(FoodDirectory.LETTUCE));
                    foodManager.setOrderable(getToppingDecorator(FoodDirectory.CORN));
                    foodManager.setOrderable(getToppingDecorator(FoodDirectory.GUAC));
                    navigateToRemoveOrAddToppings();
                }
        ));

        options.add(new MenuOption(
                "The Big Bean",
                "beans, lettuce, salsa, corn",
                () -> {
                    foodManager.initFood(FoodDirectory.BEANS);
                    foodManager.setOrderable(getToppingDecorator(FoodDirectory.LETTUCE));
                    foodManager.setOrderable(getToppingDecorator(FoodDirectory.SALSA));
                    foodManager.setOrderable(getToppingDecorator(FoodDirectory.CORN));
                    navigateToRemoveOrAddToppings();
                }
        ));

        options.add(new MenuOption(
                "The Shrimp Shack",
                "shrimp, chili sauce, red onion",
                () -> {
                    foodManager.initFood(FoodDirectory.SHRIMP);
                    foodManager.setOrderable(getToppingDecorator(FoodDirectory.CHILI_SAUCE));
                    foodManager.setOrderable(getToppingDecorator(FoodDirectory.RED_ONION));
                    navigateToRemoveOrAddToppings();
                }
        ));

        options.add(new MenuOption(
                "Build your own",
                () -> MenuController.getInstance().navigate(new ChooseProteinMenu(foodManager))
        ));

        return options;
    }

    private ToppingDecorator getToppingDecorator(Topping topping) {
        return new ToppingDecorator(foodManager.getOrderable(), topping);
    }

    private void navigateToRemoveOrAddToppings() {
        MenuController.getInstance().navigate(new AddOrRemoveToppingsMenu(foodManager));
    }

    @Override
    public boolean isPopBackStackInclusive() {
        return true;
    }
}
