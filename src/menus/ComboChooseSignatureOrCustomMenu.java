package menus;

import Util.Request.ComboRequest;

public class ComboChooseSignatureOrCustomMenu extends ChooseSignatureOrCustomMenu {
    private ComboRequest comboRequest;

    ComboChooseSignatureOrCustomMenu(ComboRequest comboRequest) {
        super(null); // pass null for constructor because don't want to double call dequeue
        this.comboRequest = comboRequest;
    }

    @Override
    public void printPrefix() {
        System.out.println("For your " + foodRequest.getFoodBaseType().name().toLowerCase() + "...");
    }

    @Override
    public void onNavigated() {
        foodRequest = comboRequest.dequeue();
        super.onNavigated();
    }

    @Override
    public boolean isPopBackStackInclusive() {
        return comboRequest.queueIsEmpty();
    }
}
