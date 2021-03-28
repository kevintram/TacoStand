package menus;

public class ComboChooseSignatureOrCustomMenu extends ChooseSignatureOrCustomMenu {
    private ComboManager comboManager;

    ComboChooseSignatureOrCustomMenu(ComboManager comboManager) {
        super(null); // pass null for constructor because don't want to double call dequeue
        this.comboManager = comboManager;
    }

    @Override
    public void printPrefix() {
        System.out.println("For your " + foodManager.getFoodBaseType().name().toLowerCase() + "...");
    }

    @Override
    public void onNavigated() {
        foodManager = comboManager.dequeue();
        super.onNavigated();
    }

    @Override
    public boolean isPopBackStackInclusive() {
        return comboManager.queueIsEmpty();
    }
}
