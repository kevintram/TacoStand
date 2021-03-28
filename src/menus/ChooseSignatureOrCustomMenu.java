package menus;

import Util.FoodDirectory;
import Util.Request.FoodRequest;
import navigation.Menu;
import navigation.MenuController;
import navigation.MenuOption;
import orderable.*;

import java.util.ArrayList;

public class ChooseSignatureOrCustomMenu extends Menu {
    FoodRequest foodRequest;

    ChooseSignatureOrCustomMenu(FoodRequest foodRequest) {
        super();
        this.foodRequest = foodRequest;
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
                    foodRequest.initFood(FoodDirectory.STEAK);
                    foodRequest.setOrderable(getToppingDecorator(FoodDirectory.LETTUCE));
                    foodRequest.setOrderable(getToppingDecorator(FoodDirectory.CORN));
                    foodRequest.setOrderable(getToppingDecorator(FoodDirectory.GUAC));
                    navigateToRemoveOrAddToppings();
                }
        ));

        options.add(new MenuOption(
                "The Big Bean",
                "beans, lettuce, salsa, corn",
                () -> {
                    foodRequest.initFood(FoodDirectory.BEANS);
                    foodRequest.setOrderable(getToppingDecorator(FoodDirectory.LETTUCE));
                    foodRequest.setOrderable(getToppingDecorator(FoodDirectory.SALSA));
                    foodRequest.setOrderable(getToppingDecorator(FoodDirectory.CORN));
                    navigateToRemoveOrAddToppings();
                }
        ));

        options.add(new MenuOption(
                "The Shrimp Shack",
                "shrimp, chili sauce, red onion",
                () -> {
                    foodRequest.initFood(FoodDirectory.SHRIMP);
                    foodRequest.setOrderable(getToppingDecorator(FoodDirectory.CHILI_SAUCE));
                    foodRequest.setOrderable(getToppingDecorator(FoodDirectory.RED_ONION));
                    navigateToRemoveOrAddToppings();
                }
        ));

        options.add(new MenuOption(
                "Build your own",
                () -> MenuController.getInstance().navigate(new ChooseProteinMenu(foodRequest))
        ));

        return options;
    }

    private ToppingDecorator getToppingDecorator(Topping topping) {
        return new ToppingDecorator(foodRequest.getOrderable(), topping);
    }

    private void navigateToRemoveOrAddToppings() {
        MenuController.getInstance().navigate(new AddOrRemoveToppingsMenu(foodRequest));
    }

    @Override
    public boolean isPopBackStackInclusive() {
        return true;
    }
}
