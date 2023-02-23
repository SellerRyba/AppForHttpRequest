import java.util.Scanner;

public class HttpImageStatusCli {
    private final Scanner scanner;
    private final HttpStatusImageDownloader downloader;

    public HttpImageStatusCli() {
        this.scanner = new Scanner(System.in);
        this.downloader = new HttpStatusImageDownloader();
    }

    public void askStatus() {
        while (true) {
            System.out.print("Enter HTTP status code: ");
            String input = scanner.nextLine().trim();
            int code;

            try {
                code = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter valid number");
                continue;
            }

            try {
                downloader.downloadStatusImage(code);
                System.out.println("Image for status code " + code + " was downloaded successfully");
                break;
            } catch (Exception e) {
                System.out.println("There is no image for HTTP status " + code);
            }
        }
    }

}
