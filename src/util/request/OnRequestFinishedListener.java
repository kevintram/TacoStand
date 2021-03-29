package util.request;

import orderable.Orderable;

/**
 * Interface definition for a callback to be invoked when an orderable is "finished".
 */
public interface OnRequestFinishedListener {
    void onFinish(Orderable orderable);
}
