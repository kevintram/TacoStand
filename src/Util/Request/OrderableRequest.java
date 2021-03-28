package Util.Request;

import orderable.Orderable;

/**
 * Class for managing an orderable and what occurs when it is "finished".
 */
public abstract class OrderableRequest {
    public OnRequestFinishedListener onRequestFinishedListener;

    public OrderableRequest(OnRequestFinishedListener onRequestFinishedListener) {
        this.onRequestFinishedListener = onRequestFinishedListener;
    }

    public abstract Orderable getOrderable();
    public abstract void setOrderable(Orderable orderable);
}
