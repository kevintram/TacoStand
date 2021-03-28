package menus;

import Util.Request.ComboRequest;
import Util.FoodBaseType;
import Util.Request.FoodRequest;
import Util.Order;
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
                    ComboRequest comboRequest = new ComboRequest(combo, Order::insertOrderable);

                    for (int i = 0; i < 3; i++) {
                        comboRequest.queue(new FoodRequest(FoodBaseType.TACO, combo::add));
                    }

                    navigateToComboChooseSignatureOrCustomMenu(comboRequest);
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
                    ComboRequest comboRequest = new ComboRequest(combo, Order::insertOrderable);

                    for (int j = 0; j < 3; j++) {
                        comboRequest.queue(new FoodRequest(FoodBaseType.TACO, combo::add));
                    }

                    navigateToComboChooseSignatureOrCustomMenu(comboRequest);
                }
        ));

        options.add(new MenuOption(
                "Traveler's Pack",
                "2 tacos, 1 burrito",
                () -> {
                    Combo combo = new Combo("Traveler's Pack","2 tacos and 1 burrito");
                    ComboRequest comboRequest = new ComboRequest(combo, Order::insertOrderable);

                    comboRequest.queue(new FoodRequest(FoodBaseType.TACO, combo::add));
                    comboRequest.queue(new FoodRequest(FoodBaseType.TACO, combo::add));
                    comboRequest.queue(new FoodRequest(FoodBaseType.BURRITO, combo::add));

                    navigateToComboChooseSignatureOrCustomMenu(comboRequest);
                }
        ));

        options.add(new MenuOption(
                "Sampler Pack",
                "1 taco, 1 burrito, 1 bowl",
                () -> {
                    Combo combo = new Combo("Sampler","1 taco, 1 burrito, 1 bowl");
                    ComboRequest comboRequest = new ComboRequest(combo, Order::insertOrderable);

                    comboRequest.queue(new FoodRequest(FoodBaseType.TACO, combo::add));
                    comboRequest.queue(new FoodRequest(FoodBaseType.BURRITO, combo::add));
                    comboRequest.queue(new FoodRequest(FoodBaseType.BOWL, combo::add));

                    navigateToComboChooseSignatureOrCustomMenu(comboRequest);
                }
        ));

        options.add(new MenuOption(
                "Party Platter",
                "3 orders of tacos, 2 burritos, 1 bowl",
                () -> {
                    Combo combo = new Combo("Party Platter", "3 Orders of Tacos, 2 Burritos, 1 Bowl");
                    ComboRequest comboRequest = new ComboRequest(combo, Order::insertOrderable);

                    for (int i = 0; i < 3; i++) {
                        Combo order = new Combo("Order of Tacos", "3 tacos");
                        ComboRequest orderManager = new ComboRequest(order, combo::add);
                        for (int j = 0; j < 3; j++) {
                            orderManager.queue(new FoodRequest(FoodBaseType.TACO, order::add));
                        }
                        comboRequest.queue(orderManager);
                    }

                    for (int i = 0; i < 2; i++) {
                        comboRequest.queue(new FoodRequest(FoodBaseType.BURRITO, combo::add));
                    }

                    comboRequest.queue(new FoodRequest(FoodBaseType.BOWL, combo::add));

                    navigateToComboChooseSignatureOrCustomMenu(comboRequest);
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

    private void navigateToComboChooseSignatureOrCustomMenu(ComboRequest comboRequest) {
        // insert into the Order now because don't have to worry about adding a decorator
        comboRequest.onRequestFinishedListener.onRequestFinished(comboRequest.getOrderable());
        MenuController.getInstance().navigate(new ComboChooseSignatureOrCustomMenu(comboRequest));
    }


    @Override
    public boolean isPopBackStackInclusive() {
        return false;
    }
}
