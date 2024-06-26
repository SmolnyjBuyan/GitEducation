package patterns.behavioral.pubsub.solution.impl.event;

import patterns.behavioral.pubsub.solution.Event;

import java.time.LocalDateTime;

public class Video implements Event<Video> {
    private final LocalDateTime startTime;
    private final String name;
    private final int duration;

    public Video(LocalDateTime startTime, String name, int duration) {
        this.startTime = startTime;
        this.name = name;
        this.duration = duration;
    }

    @Override
    public Video appear() {
        return this;
    }

    public int getDuration() {
        return duration;
    }
}
