import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HttpStatusImageDownloader {
    public static void downloadStatusImage(int code){
        String imageUrl = HttpStatusChecker.getStatusImage(code);

        if (imageUrl == null) {
            System.out.println("Image not found for status code: " + code);
            return;
        }

        try {
            Path filePath = Paths.get(imageUrl.substring(imageUrl.lastIndexOf('/') + 1));
            InputStream inputStream = new java.net.URL(imageUrl).openStream();
            Files.copy(inputStream, filePath);
            System.out.println("Image downloaded and saved as: " + filePath.toString());
        } catch (IOException e) {
            System.out.println("There is not image for HTTP status: " + code);
        }
    }

}

