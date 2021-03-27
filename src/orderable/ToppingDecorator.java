package orderable;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Decorator for adding toppings to a FoodBase.
 */
public class ToppingDecorator implements FoodBase {

    FoodBase inner;
    Topping topping;
    private UUID id;

    public ToppingDecorator(FoodBase inner, Topping topping) {
        this.inner = inner;
        this.id = inner.getId();
        this.topping = topping;
    }

    @Override
    public Protein getProtein() {
        return inner.getProtein();
    }

    public Topping getTopping() { return topping; }

    /**
     * Removes the topping.
     *
     * @param topping the topping to be removed.
     * @return the new foodbase.
     */
    public FoodBase remove(Topping topping) {
        if (this.topping == topping) {
            return inner;
        }

        if (!(inner instanceof ToppingDecorator)) {
            throw new IllegalArgumentException("Error: This topping does not exist in the topping stack!");
        }

        inner = ((ToppingDecorator) inner).remove(topping);
        return this;
    }

    public Topping[] getToppings() {
        ArrayList<Topping> toppings = new ArrayList<>();

        toppings.add(topping);

        FoodBase inner = this.inner;

        while (inner instanceof ToppingDecorator) {
            toppings.add(0, ((ToppingDecorator) inner).topping);
            inner = ((ToppingDecorator) inner).inner;
        }

        Topping[] arr = new Topping[toppings.size()];
        return toppings.toArray(arr);
    }

    @Override
    public String getString() {
        return inner.getString() + ", " + topping.getName();
    }

    @Override
    public float getPrice() {
        return inner.getPrice() + topping.getPrice();
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }
}
