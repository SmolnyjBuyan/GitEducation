package patterns.structural.wrappers.proxy.solution;

import patterns.structural.wrappers.proxy.task.downloaders.validators.PictureComparator;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PictureDownloadServiceForSolution implements Downloader {
    private final PictureDownloaderServiceProxy downloader = new PictureDownloaderServiceProxy();
    private final PictureComparator comparator = new PictureComparator();

    @Override
    public void download(String path, String filename) {
        long startTime = System.currentTimeMillis();
        if (comparator.arePictureEqual(path)) {
            System.err.println("Start download");
            long endTime = System.currentTimeMillis();
            System.err.printf("Load finished with time %s %s%n", (endTime - startTime) / 1000, "seconds");
        } else {
            downloader.download(path, filename);
        }
    }

}
