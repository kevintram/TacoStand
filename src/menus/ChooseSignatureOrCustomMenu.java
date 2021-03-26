package menus;

import navigation.Menu;
import navigation.MenuOption;
import orderable.FoodBase;
import java.util.ArrayList;

public class ChooseSignatureOrCustomMenu extends Menu {
    FoodBase foodBase;

    ChooseSignatureOrCustomMenu(FoodBase foodBase) {
        super();
        this.foodBase = foodBase;
    }

    @Override
    protected void onSetPrompt() {
        prompt = "Choose a signature or build your own";
    }

    @Override
    protected void onSetOptions() {
        options = new ArrayList<>();

        options.add(new MenuOption(
                "Bada Beef Bada Boom",
                "steak, lettuce, corn, guac",
                () -> {

                }
        ));

        options.add(new MenuOption(
                "The Big Bean",
                "beans, lettuce, salsa, corn",
                () -> {

                }
        ));

        options.add(new MenuOption(
                "The Shrimp Shack",
                "shrimp, chili sauce, red onion",
                () -> {

                }
        ));

        options.add(new MenuOption(
                "Build your own",
                () -> {

                }
        ));
    }

    @Override
    public boolean isPopBackStackInclusive() {
        return false;
    }
}
