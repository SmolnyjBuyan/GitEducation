package clients;

public interface ActorBehavior {

    void setReadyToOrder(boolean ready);
    void setReceivedAnOrder(boolean received);

    boolean isReadyToOrder();
    boolean isReceivedAnOrder();

}
