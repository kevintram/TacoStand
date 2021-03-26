package orderable;

/**
 * Class that represents a Taco
 */
public final class Taco implements FoodBase {
    private final Protein protein;

    public Taco(Protein protein) {
        this.protein = protein;
    }

    @Override
    public Protein getProtein() {
        return protein;
    }

    @Override
    public String getString() {
        return "$" + getPrice() + " Taco with " + protein.getString();
    }

    @Override
    public float getPrice() {
        return protein.getPrice() + 3.99f;
    }
}
