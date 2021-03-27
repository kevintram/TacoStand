package orderable;

/**
 * Class that presents a protein (Chicken, Steak, etc).
 */
public final class Protein {
    private final String name;
    private final float price;

    public Protein(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getString() {
        return "$" + String.format("%.2f", price) + " " + name;
    }
    public float getPrice() { return price; }
    public String getName() { return name; }
}