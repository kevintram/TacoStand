package menus;

import navigation.Menu;
import navigation.MenuController;
import navigation.MenuOption;
import menus.ChooseSignatureOrCustomMenu.FoodBaseType;
import java.util.ArrayList;

public class ChooseBaseMenu extends Menu {

    @Override
    protected void onSetPrompt() {
        prompt =  "Choose a base";
    }

    @Override
    protected void onSetOptions() {
       options = new ArrayList<>();

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
    }

    private void navigateToChooseSignatureOrCustomMenu(FoodBaseType foodBaseType) {
        MenuController.getInstance().navigate(new ChooseSignatureOrCustomMenu(foodBaseType));
    }

    @Override
    public boolean isPopBackStackInclusive() {
        return false;
    }
}
