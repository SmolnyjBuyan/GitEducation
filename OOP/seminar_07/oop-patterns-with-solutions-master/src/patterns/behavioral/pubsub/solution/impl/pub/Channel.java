package patterns.behavioral.pubsub.solution.impl.pub;
import patterns.behavioral.pubsub.solution.Event;
import patterns.behavioral.pubsub.solution.Listener;
import patterns.behavioral.pubsub.solution.Publisher;
import patterns.behavioral.pubsub.solution.impl.event.Video;
import patterns.behavioral.pubsub.solution.impl.sub.ChannelAdministrator;

import java.util.ArrayList;
import java.util.List;

public class Channel implements Publisher<Video> {
    private final List<Listener<Video>> subscribers;
    private final List<Video> videos;
    private ChannelAdministrator admin;

    public Channel() {
        this(new ChannelAdministrator("Rob"));
    }

    public Channel(ChannelAdministrator admin) {
        this.subscribers = new ArrayList<>();
        this.videos = new ArrayList<>();
        this.admin = admin;
    }

    public void addVideo(Video video) {
        videos.add(video);

    }

    public ChannelAdministrator getAdmin() {
        return admin;
    }

    public void setAdmin(ChannelAdministrator admin) {
        this.admin = admin;
    }

    @Override
    public void registerSubscriber(Listener<Video> subscriber) {
        subscribers.add(subscriber);
        for (Video video: videos) {
            subscriber.process(() -> video);
        }
    }

    @Override
    public void unregisterSubscriber(Listener<Video> subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers(Event<Video> event) {
        for (Listener<Video> subscriber: subscribers) {
            subscriber.process(event);
        }
    }

}
