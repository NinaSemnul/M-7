import java.util.InputMismatchException;
import java.util.Scanner;

public class HttpImageStatusCli {
    public static void main(String[] args) throws Exception {
        askStatus();
    }

    public static void askStatus() throws Exception {
        int num = 0;
        num = askStatusAgain();

        while (num == 0){
            num = askStatusAgain();
        }

        try {
            HttpStatusImageDownloader.downloadStatusImage(num);
            System.out.println("File uploaded successfully.");
        }catch (HttpStatusImageDownloader.downloadImageException e){
            System.out.println(e.getMessage());
        }

    }

    public static int askStatusAgain(){
        int num = 0;

        try {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter HTTP status code: ");
            num = in.nextInt();
            in.close();

        }catch (InputMismatchException e) {
            System.out.println("Please enter valid number");
        }
      return num;
    }

}
