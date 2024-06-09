package services;

import models.Stream;
import models.StreamComparator;
import models.StudentGroup;

import java.util.List;

public class StreamService {
    private Stream stream;

    public StreamService(Stream stream) {
        this.stream = stream;
    }

    public void addStudentGroup(StudentGroup studentGroup) {
        stream.getStudentGroupList().add(studentGroup);
    }

    public void sortStreams(List<Stream> streams) {
        streams.sort(new StreamComparator());
    }
}
