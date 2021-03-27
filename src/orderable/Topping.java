package orderable;

/**
 * Class that represents a topping (Salsa, Guac, etc).
 */
public final class Topping {
    private final String name;
    private final float price;

    public Topping(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getString() {
        return "$" + String.format("%.2f", price) + " " + name;
    }

    public String getName() { return name; }
    public float getPrice() { return price; }
}


