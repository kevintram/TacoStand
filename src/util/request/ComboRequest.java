package util.request;

import orderable.Combo;
import orderable.Orderable;

import java.util.LinkedList;

/**
 * Class for managing a request for a combo order. OnFinish will not need to be called, it will be called when the last
 * request is finished.
 */
public class ComboRequest extends MultiRequest {
    private Combo combo;
    private final LinkedList<OrderableRequest> requests;

    public ComboRequest(Combo combo, LinkedList<OrderableRequest> requests, OnRequestFinishedListener onRequestFinishedListener) {
        super(onRequestFinishedListener);
        this.combo = combo;
        this.requests = requests;

        // when last request is done, this is finished
        OnRequestFinishedListener lastOnRequestFinishedListener = requests.getLast().onRequestFinishedListener;
        requests.getLast().onRequestFinishedListener = (orderable) -> {
            lastOnRequestFinishedListener.onFinish(orderable);
            this.onRequestFinishedListener.onFinish(combo);
        };
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
     * Returns and removes the next FoodRequest from the queue.
     * @return the next FoodManager
     */
    @Override
    public FoodRequest dequeueNextFoodRequest() {
        OrderableRequest peek = requests.peek();

        if (peek == null) {
            return null;
        }

        if (peek instanceof ComboRequest) {
           if (((ComboRequest) peek).queueIsEmpty()) {
               requests.poll();
               return dequeueNextFoodRequest();
           } else {
               return ((ComboRequest) peek).dequeueNextFoodRequest();
           }
        } else if (peek instanceof FoodRequest) {
           requests.poll();
           return (FoodRequest) peek;
       } else {
            throw new IllegalStateException("Peek needs to be a Food Request!");
        }
    }

    @Override
    public boolean queueIsEmpty() {
        return requests.isEmpty();
    }
}
