package patterns.behavioral.pubsub.solution.impl.sub;

import patterns.behavioral.pubsub.solution.Event;
import patterns.behavioral.pubsub.solution.Listener;
import patterns.behavioral.pubsub.solution.Publisher;
import patterns.behavioral.pubsub.solution.impl.event.Video;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class User implements Listener<Video>, Publisher<Boolean> {
    private final String nickname;
    private boolean isLikeVideo;
    private final List<Listener<Boolean>> channelAdministrators;

    public User(String nickname) {
        this.nickname = nickname;
        this.isLikeVideo = false;
        this.channelAdministrators = new ArrayList<>();
    }

    public String getNickname() {
        return nickname;
    }

    public boolean isLikeVideo() {
        return isLikeVideo;
    }

    public void setLikeVideo(boolean likeVideo) {
        isLikeVideo = likeVideo;
    }

    @Override
    public void process(Event<Video> event) {
        Video video = event.appear();
        Random random = new Random();
        if (video.getDuration() > random.nextInt(100)) {
            System.err.printf("%s: This is a very long! I don't like it!%n", nickname);
            setLikeVideo(false);
            notifySubscribers(() -> isLikeVideo);
        } else {
            System.out.printf("%s: I like it!%n", nickname);
            setLikeVideo(true);
            notifySubscribers(() -> isLikeVideo);
        }
    }

    @Override
    public void registerSubscriber(Listener<Boolean> subscriber) {
        channelAdministrators.add(subscriber);
    }

    @Override
    public void unregisterSubscriber(Listener<Boolean> subscriber) {
        channelAdministrators.remove(subscriber);
    }

    @Override
    public void notifySubscribers(Event<Boolean> event) {
        for (Listener<Boolean> admin: channelAdministrators) {
            admin.process(event);
        }
    }
}
