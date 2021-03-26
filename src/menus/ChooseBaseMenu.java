package menus;

import navigation.Menu;
import navigation.MenuController;
import navigation.MenuOption;
import orderable.Protein;
import orderable.Taco;

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
                () -> MenuController.getInstance().navigate(
                        new ChooseSignatureOrCustomMenu(new Taco(new Protein("Steak", 3.50f)))
                )
        ));

        options.add(new MenuOption(
                "Burrito",
                () -> {}
        ));

        options.add(new MenuOption(
                "Bowl",
                () -> {}
        ));
    }

    @Override
    public boolean isPopBackStackInclusive() {
        return false;
    }
}
