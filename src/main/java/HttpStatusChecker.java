import org.jsoup.Jsoup;
import java.io.IOException;

public class HttpStatusChecker {
    public static String getStatusImage(int code){

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
            System.out.println(e.getMessage());
            return null;
        }

    }
}
