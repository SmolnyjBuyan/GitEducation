package patterns.behavioral.pubsub.solution;

public interface Publisher<T> {
    void registerSubscriber(Listener<T> subscriber);
    void unregisterSubscriber(Listener<T> subscriber);
    void notifySubscribers(Event<T> event);
}
