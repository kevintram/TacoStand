package menus;

import orderable.Combo;
import orderable.Orderable;

import java.util.LinkedList;
import java.util.Queue;

public class ComboManager extends OrderableManager {
    private Combo combo;
    private Queue<OrderableManager> orderableManagers;

    ComboManager(Combo combo, OnOrderableFinishedListener onOrderableFinishedListener) {
        super(onOrderableFinishedListener);
        this.combo = combo;
        orderableManagers = new LinkedList<>();
    }

    @Override
    public Orderable getOrderable() {
        return combo;
    }

    @Override
    public void setOrderable(Orderable orderable) {
        combo = (Combo) orderable;
    }

    public void queue(OrderableManager orderableManager) {
        orderableManagers.add(orderableManager);
    }

    /**
     * Returns and removes the next FoodManager from the queue.
     * @return the next FoodManager
     */
    public FoodManager dequeue() {
        OrderableManager peek = orderableManagers.peek();

        if (peek == null) {
            return null;
        }

        if (peek instanceof ComboManager) {
           if (((ComboManager) peek).queueIsEmpty()) {
               orderableManagers.poll();
               return dequeue();
           } else {
               return ((ComboManager) peek).dequeue();
           }
        } else if (peek instanceof FoodManager) {
           orderableManagers.poll();
           return (FoodManager) peek;
       } else {
            throw new IllegalStateException("Peek needs to be a Food Manager!");
        }
    }

    public boolean queueIsEmpty() {
        return orderableManagers.isEmpty();
    }
}
