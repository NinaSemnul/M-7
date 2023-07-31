public class Main {

    public static void main(String[] args){

        String rez = HttpStatusChecker.getStatusImage(200);
        String rez2 = HttpStatusChecker.getStatusImage(1000);

        HttpStatusImageDownloader.downloadStatusImage(200);
        HttpStatusImageDownloader.downloadStatusImage(1000);

        HttpImageStatusCli.askStatus();
    }
}
