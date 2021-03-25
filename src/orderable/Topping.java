package orderable;

/**
 * Class that represents a topping (Salsa, Guac, etc).
 */
public final class Topping {
    private final String name;
    private final float price;

    Topping(String name, float price) {
        this.name = name;
        this.price = price;
    }

    String getString() { return name; }
    float getPrice() { return price; }
}


