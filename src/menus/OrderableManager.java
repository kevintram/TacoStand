package menus;

import orderable.Orderable;

public abstract class OrderableManager {
    public OnOrderableFinishedListener onOrderableFinishedListener;

    OrderableManager(OnOrderableFinishedListener onOrderableFinishedListener) {
        this.onOrderableFinishedListener = onOrderableFinishedListener;
    }

    public abstract Orderable getOrderable();
    public abstract void setOrderable(Orderable orderable);
}
