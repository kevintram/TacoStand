package util.request;

import util.FoodBaseType;
import orderable.*;

/**
 * Class for managing a request for a food order and what occurs when it is "finished."
 */
public class FoodRequest extends OrderableRequest {
    private FoodBase food;
    private FoodBaseType foodBaseType;
    private String whatItIs;

    // take in a foodBaseType because we won't know the protein the user wants until later
    public FoodRequest(FoodBaseType foodBaseType, String whatItIs, OnRequestFinishedListener onRequestFinishedListener) {
        super(onRequestFinishedListener);
        this.foodBaseType = foodBaseType;
        this.whatItIs = whatItIs;
    }

    public void initFood(Protein protein) {
       switch (foodBaseType) {
           case TACO: food =  new Taco(protein);
           case BURRITO: food =  new Burrito(protein);
           case BOWL: food =  new Bowl(protein);
        };
    }

    public FoodBaseType getFoodBaseType() {
        return foodBaseType;
    }

    public String getWhatItIs() {
        return whatItIs;
    }

    @Override
    public FoodBase getOrderable() {
        if (food != null) {
            return food;
        } else {
            throw new IllegalStateException("Food has not been initialized!");
        }
    }

    @Override
    public void setOrderable(Orderable orderable) {
        food = (FoodBase) orderable;
    }
}
