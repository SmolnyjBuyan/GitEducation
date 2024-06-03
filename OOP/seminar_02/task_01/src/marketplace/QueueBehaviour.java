package marketplace;

import clients.Actor;

public interface QueueBehaviour {

    void getInQueue(Actor actor);

    void makeAnOrder();
    void pickupAnOrder();

    void getOutQueue();
}
