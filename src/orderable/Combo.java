package orderable;

import java.util.ArrayList;
import java.util.UUID;

/**
 * A class that represents a combination of orderables.
 */
public class Combo implements Orderable {

    private UUID id;
    private final ArrayList<Orderable> children;
    private String name;
    private String description;

    public Combo() {
        this("", "");
    }

    public Combo(String name, String description) {
        children = new ArrayList<>();
        id = UUID.randomUUID();
        this.name = name;
        this.description = description;
    }

    public void add(Orderable orderable) {
        children.add(orderable);
    }

    /**
     * Updates the orderable in this combo.
     *
     * @param orderable the orderable to be updated.
     * @throws IllegalArgumentException when the orderable is not found.
     */
    public void update(Orderable orderable) throws IllegalArgumentException {
        for (int i = 0; i < children.size(); i++) {
            if (children.get(i).getId() == orderable.getId()) {
                children.remove(i);
                children.add(i, orderable);
                return;
            }
        }
        throw new IllegalArgumentException("Error: Orderable not found in children!");
    }

    /**
     * Returns the orderable in children with the corresponding id.
     * @param id the id of the desired orderable
     * @return the orderable with the id
     */
    public Orderable get(UUID id) {
        for (Orderable o : children) {
            if (o.getId() == id) {
                return o;
            }
        }
        throw new IllegalArgumentException("Error: Id not found in children!");
    }

    public boolean remove(Orderable orderable) {
        return children.remove(orderable);
    }

    @Override
    public String getString() {
        StringBuilder sb = new StringBuilder();
        sb.append("$").append(String.format("%.2f", getPrice())).append(" ");
        sb.append(name).append(" ");
        sb.append("(").append(description).append(")").append("\n");
        for (Orderable orderable : children) {
            sb.append("\t- ").append(orderable.getString()).append("\n");
        }
        sb.setLength(sb.length() - 1); // remove last new line
        return sb.toString();
    }

    @Override
    public float getPrice() {
        float p = 0f;
        for (Orderable orderable : children) {
            p += orderable.getPrice();
        }
        return p;
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
