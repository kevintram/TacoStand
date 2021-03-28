package menus;

import Util.FoodDirectory;
import Util.Request.FoodRequest;
import navigation.Menu;
import navigation.MenuController;
import navigation.MenuOption;
import orderable.*;

import java.util.ArrayList;

public class ChooseProteinMenu extends Menu {
    FoodRequest foodRequest;

    ChooseProteinMenu(FoodRequest foodRequest) {
        this.foodRequest = foodRequest;
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
                        foodRequest.initFood(p);
                        navigateToAddOrRemoveToppingsMenu();
                    }
            ));
        }
        return options;
    }

    private void navigateToAddOrRemoveToppingsMenu() {
        MenuController.getInstance().navigate(new AddOrRemoveToppingsMenu(foodRequest));
    }

    @Override
    public boolean isPopBackStackInclusive() {
        return true;
    }
}
