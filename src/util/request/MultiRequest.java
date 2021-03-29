package util.request;

/**
 * A request that has multiple requests that need to be fulfilled before it is fulfilled.
 */
public abstract class MultiRequest extends OrderableRequest {
    public MultiRequest(OnRequestFinishedListener onRequestFinishedListener) {
        super(onRequestFinishedListener);
    }

    public abstract void queue(OrderableRequest request);
    public abstract FoodRequest dequeueNextFoodRequest();
    public abstract boolean queueIsEmpty();
}
