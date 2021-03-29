package menus;

import util.request.MultiRequest;

public class MultiChooseSignatureOrCustomMenu extends ChooseSignatureOrCustomMenu {
    private MultiRequest multiRequest;

    MultiChooseSignatureOrCustomMenu(MultiRequest multiRequest) {
        super(null); // pass null for constructor because don't want to double call dequeue
        this.multiRequest = multiRequest;
    }

    @Override
    public void printPrefix() {
        StringBuilder sb = new StringBuilder();

//        sb.append("For the ")
//                .append(foodRequest.getFoodBaseType().name().toLowerCase())
//                .append(" in the ")
//                .append(((Combo) multiRequest.getOrderable()).getName());

        System.out.println(sb);
    }

    @Override
    public void onNavigated() {
        foodRequest = multiRequest.dequeueNextFoodRequest();
        super.onNavigated();
    }

    @Override
    public boolean isPopBackStackInclusive() {
        return multiRequest.queueIsEmpty();
    }
}
