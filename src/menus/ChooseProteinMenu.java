package menus;

import navigation.Menu;
import navigation.MenuController;
import navigation.MenuOption;
import orderable.*;

import java.util.ArrayList;

public class ChooseProteinMenu extends Menu {
    FoodBaseType foodBaseType;
    Combo combo;

    ChooseProteinMenu(FoodBaseType foodBaseType) {
        this(foodBaseType, null);
    }

    ChooseProteinMenu(FoodBaseType foodBaseType, Combo combo) {
        this.foodBaseType = foodBaseType;
        this.combo = combo;
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
                    () -> navigateToAddOrRemoveToppingsMenu(getFood(foodBaseType, p))
            ));
        }

        return options;
    }

    private FoodBase getFood(FoodBaseType foodBaseType, Protein protein) {
        return switch (foodBaseType) {
            case TACO -> new Taco(protein);
            case BURRITO -> new Burrito(protein);
            case BOWL -> new Bowl(protein);
        };
    }

    private void navigateToAddOrRemoveToppingsMenu(FoodBase food) {
        if (combo != null) {
            combo.add(food);
            MenuController.getInstance().navigate(new AddOrRemoveToppingsMenu(food, combo));
        } else {
            Order.insertOrderable(food);
            MenuController.getInstance().navigate(new AddOrRemoveToppingsMenu(food.getId()));
        }

    }

    @Override
    public boolean isPopBackStackInclusive() {
        return true;
    }
}
