package Util.Request;

import orderable.Combo;
import orderable.Orderable;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class for managing a request for a combo order and what occurs when it is "finished."
 */
public class ComboRequest extends OrderableRequest {
    private Combo combo;
    private Queue<OrderableRequest> requests; // requests this request needs to fulfill

    public ComboRequest(Combo combo, OnRequestFinishedListener onRequestFinishedListener) {
        super(onRequestFinishedListener);
        this.combo = combo;
        requests = new LinkedList<>();
    }

    @Override
    public Orderable getOrderable() {
        return combo;
    }

    @Override
    public void setOrderable(Orderable orderable) {
        combo = (Combo) orderable;
    }

    /**
     * Queue a request into the requests.
     * @param request the request to be queued.
     */
    public void queue(OrderableRequest request) {
        requests.add(request);
    }

    /**
     * Returns and removes the next FoodRequest from the queue.
     * @return the next FoodManager
     */
    public FoodRequest dequeue() {
        OrderableRequest peek = requests.peek();

        if (peek == null) {
            return null;
        }

        if (peek instanceof ComboRequest) {
           if (((ComboRequest) peek).queueIsEmpty()) {
               requests.poll();
               return dequeue();
           } else {
               return ((ComboRequest) peek).dequeue();
           }
        } else if (peek instanceof FoodRequest) {
           requests.poll();
           return (FoodRequest) peek;
       } else {
            throw new IllegalStateException("Peek needs to be a Food Request!");
        }
    }

    public boolean queueIsEmpty() {
        return requests.isEmpty();
    }
}
