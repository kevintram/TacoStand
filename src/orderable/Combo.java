package orderable;

import java.util.ArrayList;
import java.util.UUID;

/**
 * A class that represents a combination of orderables.
 */
public class Combo implements Orderable {

    private UUID id;

    private final ArrayList<Orderable> children;

    Combo() {
        children = new ArrayList<>();
        id = UUID.randomUUID();
    }

    public void add(Orderable orderable) {
        children.add(orderable);
    }

    public boolean remove(Orderable orderable) {
        return children.remove(orderable);
    }

    @Override
    public String getString() {
        StringBuilder sb = new StringBuilder();
        for (Orderable orderable : children) {
            sb.append(orderable.getString());
            sb.append("\n");
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
