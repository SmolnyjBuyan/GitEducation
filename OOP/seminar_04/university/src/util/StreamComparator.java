package util;

import models.Stream;

import java.util.Comparator;

public class StreamComparator implements Comparator<Stream> {
    @Override
    public int compare(Stream o1, Stream o2) {
        return o1.getStudentGroupList().size() - o2.getStudentGroupList().size();
    }
}
