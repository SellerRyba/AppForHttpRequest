import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusImageDownloader {

    public static void downloadStatusImage(int code) throws Exception {

        String imageUrl = HttpStatusChecker.getStatusImage(code);

        URL url = new URL(imageUrl);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        int responseCode = httpConn.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            String fileName = "http_cat_" + code + ".jpg";
            String saveFilePath = "./" + fileName;

            InputStream inputStream = httpConn.getInputStream();
            FileOutputStream outputStream = new FileOutputStream(saveFilePath);

            int bytesRead = -1;
            byte[] buffer = new byte[4096];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            outputStream.close();
            inputStream.close();

            System.out.println("Image downloaded: " + saveFilePath);
        } else {
            throw new IOException("No image found for status code " + code);
        }

        httpConn.disconnect();
    }
}
