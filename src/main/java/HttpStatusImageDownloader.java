import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HttpStatusImageDownloader {
    public static void downloadStatusImage(int code) throws downloadImageException {
        String imageUrl = null;

        try {
            imageUrl = HttpStatusChecker.getStatusImage(code);

            try {
                Path filePath = Paths.get(imageUrl.substring(imageUrl.lastIndexOf('/') + 1));
                InputStream inputStream = new java.net.URL(imageUrl).openStream();
                Files.copy(inputStream, filePath);

            } catch (IOException e) {
                throw new downloadImageException("Failed to upload file : " + e.getMessage() + ". Maybe such a file already exists" );
            }

        } catch (HttpStatusChecker.StatusImageException e) {
            throw new downloadImageException(e.getMessage());
        }
    }

    public static class downloadImageException extends Exception {
        public downloadImageException(String message) {
            super(message);
        }
    }

}

