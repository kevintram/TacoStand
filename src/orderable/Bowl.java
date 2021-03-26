package orderable;

/**
 * Class that represents a bowl
 */
public final class Bowl implements FoodBase {
    private final Protein protein;

    public Bowl(Protein protein) {
        this.protein = protein;
    }

    @Override
    public Protein getProtein() {
        return protein;
    }

    @Override
    public String getString() {
        return "$" + getPrice() + " Bowl with " + protein;
    }

    @Override
    public float getPrice() {
        return protein.getPrice() + 3.99f;
    }
}
