package streams;

import java.util.List;

public class StreamService {
    public void sortStreams(List<Stream> streams) {
        streams.sort(new StreamComparator());
    }
}
