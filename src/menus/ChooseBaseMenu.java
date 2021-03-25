package menus;

import navigation.Menu;
import navigation.MenuOption;

import java.util.ArrayList;

public class ChooseBaseMenu extends Menu {

    @Override
    protected String onSetPrompt() {
        return "Choose a base";
    }

    @Override
    protected ArrayList<MenuOption> onSetOptions() {
        ArrayList<MenuOption> options = new ArrayList<>();

        options.add(new MenuOption(
                "Taco",
                () -> {}
        ));

        options.add(new MenuOption(
                "Burrito",
                () -> {}
        ));

        options.add(new MenuOption(
                "Bowl",
                () -> {}
        ));

        return options;
    }

    @Override
    public boolean isPopBackStackInclusive() {
        return false;
    }
}
