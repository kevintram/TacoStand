package menus;

import util.FoodBaseType;
import util.request.FoodRequest;
import util.Order;
import navigation.Menu;
import navigation.MenuController;
import navigation.MenuOption;
import java.util.ArrayList;

public class ChooseBaseMenu extends Menu {

    @Override
    protected String getPrompt() {
        return "Choose a base";
    }

    @Override
    protected ArrayList<MenuOption> getOptions() {
        ArrayList<MenuOption> options = new ArrayList<>();

        options.add(new MenuOption(
                "Taco",
                () -> navigateToChooseSignatureOrCustomMenu(FoodBaseType.TACO)
        ));

        options.add(new MenuOption(
                "Burrito",
                () -> navigateToChooseSignatureOrCustomMenu(FoodBaseType.BURRITO)
        ));

        options.add(new MenuOption(
                "Bowl",
                () -> navigateToChooseSignatureOrCustomMenu(FoodBaseType.BOWL)
        ));

        return options;
    }

    private void navigateToChooseSignatureOrCustomMenu(FoodBaseType foodBaseType) {
        FoodRequest foodRequest = new FoodRequest(foodBaseType, Order::insertOrderable);
        MenuController.getInstance().navigate(new ChooseSignatureOrCustomMenu(foodRequest));
    }

    @Override
    public boolean isPopBackStackInclusive() {
        return true;
    }
}
