public class App {
    public static void main(String[] args) {
        HttpImageStatusCli cli = new HttpImageStatusCli();
        try {
            cli.askStatus();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
