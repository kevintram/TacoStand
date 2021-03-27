package menus;

import orderable.Orderable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * Global state for the order.
 */
public class Order {
    private static final HashMap<UUID, Orderable> order = new HashMap<>();

    /**
     * Get the order.
     *
     * @return the order as an ArrayList.
     */
    public static ArrayList<Orderable> getOrder() {
        return new ArrayList<>(order.values());
    }

    /**
     * Insert the orderable into the order. If the orderable already existed,
     * it will be replaced.
     *
     * @param orderable the orderable to be inserted.
     */
    public static void insertOrderable(Orderable orderable) {
        order.put(orderable.getId(), orderable);
    }

    /**
     * Update the orderable in the order.
     *
     * @param orderable the orderable to be updated.
     */
    public static void updateOrderable(Orderable orderable) {
        order.put(orderable.getId(), orderable);
    }

    /**
     * Get the orderable with the corresponding id
     *
     * @param id the orderable's id
     * @return the orderable with the id
     */
    public static Orderable getOrderable(UUID id) {
        return order.get(id);
    }


    /**
     * Deletes the orderable from order.
     *
     * @param orderable the orderable to be deleted
     * @return the deleted orderable or null if it did not exist
     */
    public static Orderable deleteOrderable(Orderable orderable) {
        return deleteOrderable(orderable.getId());
    }

    /**
     * Deletes the orderable with the corresponding id from order.
     *
     * @param id the id of the orderable to be deleted
     * @return the deleted orderable or null if it did not exist
     */
    public static Orderable deleteOrderable(UUID id) {
        return order.remove(id);
    }
}
