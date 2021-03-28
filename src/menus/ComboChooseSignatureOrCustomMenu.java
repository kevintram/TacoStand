package menus;

import navigation.MenuController;
import orderable.Combo;
import orderable.FoodBase;

import java.util.Queue;

public class ComboChooseSignatureOrCustomMenu extends ChooseSignatureOrCustomMenu {
    private Queue<FoodBaseType> foodQueue; // the queued food types for the combo
    private Combo combo;

    ComboChooseSignatureOrCustomMenu(Queue<FoodBaseType> foodQueue, Combo combo) {
        super(foodQueue.peek());
        this.combo = combo;
        this.foodQueue = foodQueue;
    }

    @Override
    protected void navigateToRemoveOrAddToppings(FoodBase food) {
        combo.add(food);
        MenuController.getInstance().navigate(new AddOrRemoveToppingsMenu(food, combo));
    }

    @Override
    protected void navigateToChooseProteinMenu(FoodBaseType foodBaseType) {
        MenuController.getInstance().navigate(new ChooseProteinMenu(foodBaseType, combo));
    }

    @Override
    public void onNavigated() {
        foodBaseType = foodQueue.poll();
        super.onNavigated();
    }

    @Override
    public void printPrefix() {
        System.out.println("For the " + capitalize(foodBaseType.name()) + ":");
    }

    private String capitalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }

    @Override
    public boolean isPopBackStackInclusive() {
        return foodQueue.isEmpty(); // will only pop when foodQueue is empty
    }
}
