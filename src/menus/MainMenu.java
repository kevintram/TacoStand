package menus;

import util.request.*;
import util.FoodBaseType;
import util.Order;
import navigation.Menu;
import navigation.MenuController;
import navigation.MenuOption;
import orderable.Combo;
import orderable.Orderable;

import java.util.ArrayList;
import java.util.LinkedList;

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
                    LinkedList<OrderableRequest> requests = new LinkedList<>();

                    requests.add(new FoodRequest(FoodBaseType.TACO, "first taco in the taco salad", combo::add));
                    requests.add(new FoodRequest(FoodBaseType.TACO, "second taco in the taco salad", combo::add));
                    requests.add(new FoodRequest(FoodBaseType.TACO, "third taco in the taco salad", combo::add));

                    ComboRequest comboRequest = new ComboRequest(combo, requests, Order::insertOrderable);

                    navigateToMultiChooseSignatureOrCustomMenu(comboRequest);
                }
        ));

        options.add(new MenuOption(
                "Double-decker Taco",
                "taco inside a taco",
                () -> {
                    DoubleDeckerTacoRequest doubleDeckerTacoRequest = new DoubleDeckerTacoRequest(Order::insertOrderable);
                    navigateToMultiChooseSignatureOrCustomMenu(doubleDeckerTacoRequest);
                }
        ));

        options.add(new MenuOption(
                "Order of Tacos",
                "3 tacos",
                () -> {
                    Combo combo = new Combo("Order of Tacos", "3 tacos");

                    LinkedList<OrderableRequest> requests = new LinkedList<>();

                    requests.add(new FoodRequest(FoodBaseType.TACO, "first taco in the order of tacos", combo::add));
                    requests.add(new FoodRequest(FoodBaseType.TACO, "second taco in the order of tacos", combo::add));
                    requests.add(new FoodRequest(FoodBaseType.TACO, "third taco in the order of tacos", combo::add));

                    ComboRequest comboRequest = new ComboRequest(combo, requests, Order::insertOrderable);

                    navigateToMultiChooseSignatureOrCustomMenu(comboRequest);
                }
        ));

        options.add(new MenuOption(
                "Traveler's Pack",
                "2 tacos, 1 burrito",
                () -> {
                    Combo combo = new Combo("Traveler's Pack","2 tacos and 1 burrito");

                    LinkedList<OrderableRequest> requests = new LinkedList<>();
                    requests.add(new FoodRequest(FoodBaseType.TACO, "first taco in the traveler's pack", combo::add));
                    requests.add(new FoodRequest(FoodBaseType.TACO, "second taco in the traveler's pack", combo::add));
                    requests.add(new FoodRequest(FoodBaseType.BURRITO, "burrito in the traveler's pack", combo::add));

                    ComboRequest comboRequest = new ComboRequest(combo, requests, Order::insertOrderable);

                    // insert into the Order now because don't have to worry about adding a decorator
                    comboRequest.onRequestFinishedListener.onFinish(comboRequest.getOrderable());

                    navigateToMultiChooseSignatureOrCustomMenu(comboRequest);
                }
        ));

        options.add(new MenuOption(
                "Sampler Pack",
                "1 taco, 1 burrito, 1 bowl",
                () -> {
                    Combo combo = new Combo("Sampler","1 taco, 1 burrito, 1 bowl");

                    LinkedList<OrderableRequest> requests = new LinkedList<>();
                    requests.add(new FoodRequest(FoodBaseType.TACO, "taco in the sampler pack", combo::add));
                    requests.add(new FoodRequest(FoodBaseType.BURRITO, "burrito in the sampler pack", combo::add));
                    requests.add(new FoodRequest(FoodBaseType.BOWL, "bowl in the sampler pack", combo::add));

                    ComboRequest comboRequest = new ComboRequest(combo, requests, Order::insertOrderable);

                    navigateToMultiChooseSignatureOrCustomMenu(comboRequest);
                }
        ));

        options.add(new MenuOption(
                "Party Platter",
                "3 orders of tacos, 2 burritos, 1 bowl",
                () -> {
                    Combo combo = new Combo("Party Platter", "3 Orders of Tacos, 2 Burritos, 1 Bowl");
                    LinkedList<OrderableRequest> comboRequests = new LinkedList<>();

                    for (int i = 0; i < 3; i++) {
                        Combo order = new Combo("Order of Tacos", "3 tacos");

                        LinkedList<OrderableRequest> orderRequests = new LinkedList<>();

                        orderRequests.add(new FoodRequest(FoodBaseType.TACO, "first taco in the order", order::add));
                        orderRequests.add(new FoodRequest(FoodBaseType.TACO, "second taco in the order", order::add));
                        orderRequests.add(new FoodRequest(FoodBaseType.TACO, "third taco in the order", order::add));

                        ComboRequest orderManager = new ComboRequest(order, orderRequests ,combo::add);

                        comboRequests.add(orderManager);
                    }

                    comboRequests.add(new FoodRequest(FoodBaseType.BURRITO, "first burrito in the traveler's pack", combo::add));
                    comboRequests.add(new FoodRequest(FoodBaseType.BURRITO, "second burrito in the traveler's pack", combo::add));

                    comboRequests.add(new FoodRequest(FoodBaseType.BOWL, "bowl in the traveler's pack", combo::add));

                    ComboRequest comboRequest = new ComboRequest(combo, comboRequests, Order::insertOrderable);

                    navigateToMultiChooseSignatureOrCustomMenu(comboRequest);
                }
        ));

        options.add(new MenuOption(
                "Finish Order",
                () -> {
                    System.out.println("Here is your order: ");
                    float total = 0f;
                    StringBuilder sb = new StringBuilder();

                    for (Orderable o : Order.getOrder()) {
                        total += o.getPrice();
                        sb.append(o.getString()).append("\n");
                    }

                    System.out.println("Total: $" + String.format("%.2f",total));
                    System.out.println(sb);

                    MenuController.getInstance().popBackStack();
                }
        ));
        return options;
    }

    private void navigateToMultiChooseSignatureOrCustomMenu(MultiRequest comboRequest) {
        MenuController.getInstance().navigate(new MultiChooseSignatureOrCustomMenu(comboRequest));
    }


    @Override
    public boolean isPopBackStackInclusive() {
        return false;
    }
}
