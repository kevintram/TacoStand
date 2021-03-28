package menus;

import navigation.Menu;
import navigation.MenuController;
import navigation.MenuOption;
import orderable.*;

import java.util.ArrayList;

public class ChooseProteinMenu extends Menu {
    FoodManager foodManager;

    ChooseProteinMenu(FoodManager foodManager) {
        this.foodManager = foodManager;
    }

    @Override
    protected String getPrompt() {
        return "Choose a protein";
    }

    @Override
    protected ArrayList<MenuOption> getOptions() {
        ArrayList<MenuOption> options = new ArrayList<>();

        for (Protein p : FoodDirectory.PROTEINS) {
            options.add(new MenuOption(
                    p.getString(),
                    () -> {
                        foodManager.initFood(p);
                        navigateToAddOrRemoveToppingsMenu();
                    }
            ));
        }
        return options;
    }

    private void navigateToAddOrRemoveToppingsMenu() {
        MenuController.getInstance().navigate(new AddOrRemoveToppingsMenu(foodManager));
    }

    @Override
    public boolean isPopBackStackInclusive() {
        return true;
    }
}
