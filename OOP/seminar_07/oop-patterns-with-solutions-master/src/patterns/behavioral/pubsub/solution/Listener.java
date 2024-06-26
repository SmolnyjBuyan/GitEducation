package patterns.behavioral.pubsub.solution;

public interface Listener<T> {
    void process(Event<T> event);
}
