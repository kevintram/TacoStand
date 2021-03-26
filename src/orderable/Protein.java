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

    String getString() { return name; }
    float getPrice() { return price; }
}