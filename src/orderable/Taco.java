package orderable;

import java.util.UUID;

/**
 * Class that represents a Taco
 */
public class Taco implements FoodBase {
    private final Protein protein;
    private UUID id;

    public Taco(Protein protein) {
        this.protein = protein;
        this.id = UUID.randomUUID();
    }

    @Override
    public Protein getProtein() {
        return protein;
    }

    @Override
    public String getString() {
        return "$" + getPrice() + " Taco with " + protein.getName();
    }

    @Override
    public float getPrice() {
        return protein.getPrice() + 3.99f;
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
