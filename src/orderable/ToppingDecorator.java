package orderable;

/**
 * Decorator for adding toppings to a FoodBase.
 */
public class ToppingDecorator implements FoodBase {

    FoodBase inner;
    Topping topping;

    public ToppingDecorator(FoodBase inner, Topping topping) {
        this.inner = inner;
        this.topping = topping;
    }

    @Override
    public Protein getProtein() {
        return inner.getProtein();
    }

    @Override
    public String getString() {
        return inner.getString() + " with " + topping.getString();
    }

    @Override
    public float getPrice() {
        return inner.getPrice() + topping.getPrice();
    }
}
