import org.jsoup.Jsoup;
import java.io.IOException;

public class HttpStatusChecker {
    public static String getStatusImage(int code) throws StatusImageException {

        String url = "https://http.cat/" + code + ".jpg";
        String json = null;
        try {
            json = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .get()
                    .body()
                    .text();
            return url ;

        } catch (IOException e) {
            throw new StatusImageException("There is not image for HTTP status: " + code);
        }
    }

    public static class StatusImageException extends Exception {
        public StatusImageException(String message) {
            super(message);
        }
    }
}
