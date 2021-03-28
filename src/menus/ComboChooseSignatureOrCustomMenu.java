package menus;

import orderable.Combo;
import util.request.ComboRequest;

public class ComboChooseSignatureOrCustomMenu extends ChooseSignatureOrCustomMenu {
    private ComboRequest comboRequest;

    ComboChooseSignatureOrCustomMenu(ComboRequest comboRequest) {
        super(null); // pass null for constructor because don't want to double call dequeue
        this.comboRequest = comboRequest;
    }

    @Override
    public void printPrefix() {
        StringBuilder sb = new StringBuilder();

        sb.append("For the ")
                .append(foodRequest.getFoodBaseType().name().toLowerCase())
                .append(" in the ")
                .append(((Combo) comboRequest.getOrderable()).getName());

        System.out.println(sb);
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
