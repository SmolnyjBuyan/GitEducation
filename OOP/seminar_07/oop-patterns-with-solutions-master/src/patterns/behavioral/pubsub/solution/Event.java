package patterns.behavioral.pubsub.solution;

/**
 * This object creates events based on an object of type <T>.
 * @param <T> Type of object on which the event was created.
 */
public interface Event<T> {
    T appear();
}
