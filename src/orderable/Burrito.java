package orderable;

/**
 * Class that represents a Burrito
 */
public final class Burrito implements FoodBase {
    private final Protein protein;

    Burrito(Protein protein) {
        this.protein = protein;
    }

    @Override
    public Protein getProtein() {
        return protein;
    }

    @Override
    public String getString() {
        return "$" + getPrice() + " Burrito with " + protein;
    }

    @Override
    public float getPrice() {
        return protein.getPrice() + 3.99f;
    }
}
