package menus;

import navigation.Menu;
import navigation.MenuController;
import navigation.MenuOption;
import orderable.Combo;
import orderable.Orderable;

import java.util.ArrayList;

public class MainMenu extends Menu {

    @Override
    protected String getPrompt() {
        return "Choose something from the menu";
    }

    @Override
    protected ArrayList<MenuOption> getOptions() {
        ArrayList<MenuOption> options = new ArrayList<>();

        options.add(new MenuOption(
                "Taco, Burrito, Bowl",
                () -> MenuController.getInstance().navigate(new ChooseBaseMenu())
        ));

        options.add(new MenuOption(
                "Taco Salad",
                "bowl with 3 crushed tacos" ,
                () -> {
                    Combo combo = new Combo("Taco Salad","bowl with 3 crushed tacos");
                    ComboManager comboManager = new ComboManager(combo, Order::insertOrderable);

                    for (int i = 0; i < 3; i++) {
                        comboManager.queue(new FoodManager(FoodBaseType.TACO, combo::add));
                    }

                    navigateToComboChooseSignatureOrCustomMenu(comboManager);
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
                    Combo combo = new Combo("Order of Tacos", "3 tacos");
                    ComboManager comboManager = new ComboManager(combo, Order::insertOrderable);

                    for (int j = 0; j < 3; j++) {
                        comboManager.queue(new FoodManager(FoodBaseType.TACO, combo::add));
                    }

                    navigateToComboChooseSignatureOrCustomMenu(comboManager);
                }
        ));

        options.add(new MenuOption(
                "Traveler's Pack",
                "2 tacos, 1 burrito",
                () -> {
                    Combo combo = new Combo("Traveler's Pack","2 tacos and 1 burrito");
                    ComboManager comboManager = new ComboManager(combo, Order::insertOrderable);

                    comboManager.queue(new FoodManager(FoodBaseType.TACO, combo::add));
                    comboManager.queue(new FoodManager(FoodBaseType.TACO, combo::add));
                    comboManager.queue(new FoodManager(FoodBaseType.BURRITO, combo::add));

                    navigateToComboChooseSignatureOrCustomMenu(comboManager);
                }
        ));

        options.add(new MenuOption(
                "Sampler Pack",
                "1 taco, 1 burrito, 1 bowl",
                () -> {
                    Combo combo = new Combo("Sampler","1 taco, 1 burrito, 1 bowl");
                    ComboManager comboManager = new ComboManager(combo, Order::insertOrderable);

                    comboManager.queue(new FoodManager(FoodBaseType.TACO, combo::add));
                    comboManager.queue(new FoodManager(FoodBaseType.BURRITO, combo::add));
                    comboManager.queue(new FoodManager(FoodBaseType.BOWL, combo::add));

                    navigateToComboChooseSignatureOrCustomMenu(comboManager);
                }
        ));

        options.add(new MenuOption(
                "Party Platter",
                "3 orders of tacos, 2 burritos, 1 bowl",
                () -> {
                    Combo combo = new Combo("Party Platter", "3 Orders of Tacos, 2 Burritos, 1 Bowl");
                    ComboManager comboManager = new ComboManager(combo, Order::insertOrderable);

                    for (int i = 0; i < 3; i++) {
                        Combo order = new Combo("Order of Tacos", "3 tacos");
                        ComboManager orderManager = new ComboManager(order, combo::add);
                        for (int j = 0; j < 3; j++) {
                            orderManager.queue(new FoodManager(FoodBaseType.TACO, order::add));
                        }
                        comboManager.queue(orderManager);
                    }

                    for (int i = 0; i < 2; i++) {
                        comboManager.queue(new FoodManager(FoodBaseType.BURRITO, combo::add));
                    }

                    comboManager.queue(new FoodManager(FoodBaseType.BOWL, combo::add));

                    navigateToComboChooseSignatureOrCustomMenu(comboManager);
                }
        ));

        options.add(new MenuOption(
                "Finish Order",
                () -> {
                    System.out.println("Here is your order: ");
                    for (Orderable o : Order.getOrder()) {
                        System.out.println(o.getString());
                    }
                    MenuController.getInstance().popBackStack();
                }
        ));
        return options;
    }

    private void navigateToComboChooseSignatureOrCustomMenu(ComboManager comboManager) {
        // insert into the Order now because don't have to worry about adding a decorator
        comboManager.onOrderableFinishedListener.onOrderableFinished(comboManager.getOrderable());
        MenuController.getInstance().navigate(new ComboChooseSignatureOrCustomMenu(comboManager));
    }


    @Override
    public boolean isPopBackStackInclusive() {
        return false;
    }
}
