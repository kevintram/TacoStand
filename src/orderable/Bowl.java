package orderable;

import java.util.UUID;

/**
 * Class that represents a bowl
 */
public class Bowl implements FoodBase {
    private final Protein protein;
    private UUID id;

    public Bowl(Protein protein) {
        this.protein = protein;
        id = UUID.randomUUID();
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

    @Override
    public UUID getId() {
        return null;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }
}
