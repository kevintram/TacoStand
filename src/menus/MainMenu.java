package menus;

import navigation.Menu;
import navigation.MenuController;
import navigation.MenuOption;
import java.util.ArrayList;

public class MainMenu extends Menu {

    @Override
    protected void onSetPrompt() {
        prompt = "Choose something from the menu";
    }

    @Override
    protected void onSetOptions() {
        options = new ArrayList<>();

        options.add(new MenuOption(
                "Taco, Burrito, Bowl",
                () -> MenuController.getInstance().navigate(new ChooseBaseMenu())
        ));

        options.add(new MenuOption(
                "Taco Salad",
                "bowl with 3 crushed tacos" ,
                () -> {

                }
        ));

        options.add(new MenuOption(
                "Double-decker Taco",
                "taco inside a taco",
                () -> {

                }
        ));

        options.add(new MenuOption(
                "Order of Tacos",
                "3 tacos",
                () -> {

                }
        ));

        options.add(new MenuOption(
                "Traveler's Pack",
                "2 tacos, 1 burrito",
                () -> {

                }
        ));

        options.add(new MenuOption(
                "Sample Pack",
                "1 taco, 1 burrito, 1 bowl",
                () -> {

                }
        ));

        options.add(new MenuOption(
                "Party Platter",
                "3 orders of tacos, 2 burritos, 1 bowl",
                () -> {

                }
        ));

        options.add(new MenuOption(
                "Finish Order",
                () -> MenuController.getInstance().popBackStack()
        ));
    }

    @Override
    public boolean isPopBackStackInclusive() {
        return false;
    }
}
