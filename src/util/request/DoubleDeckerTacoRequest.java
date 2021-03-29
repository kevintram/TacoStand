package util.request;

import orderable.*;
import util.FoodBaseType;

/**
 * Food request for a double decker taco. onFinish does not need to be called here, it will be called when the last
 * request is finished.
 */
public class DoubleDeckerTacoRequest extends MultiRequest {
    private FoodBase doubleDeckerTaco; // nullable
    private FoodBase outerTaco; // nullable
    private FoodRequest innerTacoRequest; // nullable
    private FoodRequest outerTacoRequest; // nullable

    public DoubleDeckerTacoRequest(OnRequestFinishedListener onRequestFinishedListener) {
        super(onRequestFinishedListener);

        outerTacoRequest = new FoodRequest(FoodBaseType.TACO, (taco) -> outerTaco = (FoodBase) taco);

        innerTacoRequest  = new FoodRequest(FoodBaseType.TACO, (taco) -> {
            doubleDeckerTaco = new DoubleDeckerTaco((FoodBase) taco, outerTaco.getProtein());

            // add outerTaco's toppings if outerTaco is decorated
            if (outerTaco instanceof ToppingDecorator) {
                Topping[] toppings = ((ToppingDecorator) outerTaco).getToppings();

                for (Topping t : toppings) {
                    doubleDeckerTaco = new ToppingDecorator(doubleDeckerTaco, t);
                }
            }
            // finally call on finish
            onRequestFinishedListener.onFinish(doubleDeckerTaco);
        });
    }

    @Override
    public FoodRequest dequeueNextFoodRequest() {
        FoodRequest tacoRequest = null;

        if (outerTacoRequest != null) {
            tacoRequest = outerTacoRequest;
            outerTacoRequest = null;
        } else if (innerTacoRequest != null) {
            tacoRequest = innerTacoRequest;
            innerTacoRequest = null;
        }

        return tacoRequest;
    }

    @Override
    public boolean queueIsEmpty() {
        return innerTacoRequest == null && outerTacoRequest == null;
    }

    @Override
    public Orderable getOrderable() {
        return doubleDeckerTaco;
    }

    @Override
    public void setOrderable(Orderable orderable) {
        doubleDeckerTaco = (FoodBase) orderable;
    }
}
