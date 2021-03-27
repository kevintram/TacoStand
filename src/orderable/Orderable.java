package orderable;

import java.util.UUID;

/**
 * Interface to be extended for items that a customer can order.
 */
public interface Orderable {
    String getString();
    float getPrice();
    UUID getId();
    void setId(UUID id);
}
