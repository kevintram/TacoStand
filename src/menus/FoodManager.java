package menus;

import orderable.*;

public class FoodManager extends OrderableManager {
    private FoodBase food;
    private FoodBaseType foodBaseType;
    // take in a foodBaseType because we won't protein the user wants until later
    FoodManager(FoodBaseType foodBaseType, OnOrderableFinishedListener onOrderableFinishedListener) {
        super(onOrderableFinishedListener);
        this.foodBaseType = foodBaseType;
    }

    public void initFood(Protein protein) {
        food = switch (foodBaseType) {
            case TACO -> new Taco(protein);
            case BURRITO -> new Burrito(protein);
            case BOWL -> new Bowl(protein);
        };
    }

    public FoodBaseType getFoodBaseType() {
        return foodBaseType;
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
