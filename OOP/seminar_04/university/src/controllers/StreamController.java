package controllers;

import models.Stream;
import services.StreamService;
import models.StudentGroup;
import services.StudentGroupService;

import java.util.List;

public class StreamController {
    StreamService streamService;

    public StreamController(StreamService streamService) {
        this.streamService = streamService;
    }

    public void addStudentGroup(StudentGroup studentGroup) {
        streamService.addStudentGroup(studentGroup);
    }

    public void sortStreamsByGroupCount(List<Stream> stream) {
        streamService.sortStreams(stream);
    }
}
