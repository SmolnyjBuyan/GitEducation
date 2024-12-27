package org.example;


public class Course {
    private Long id;

    private String title;
    private int durationInDays;

    public Course() {
    }

    public Course(String title, int durationInDays) {
        this.title = title;
        this.durationInDays = durationInDays;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(int durationInDays) {
        this.durationInDays = durationInDays;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", durationInDays=" + durationInDays +
                '}';
    }
}
