import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class HttpStatusChecker {
    private static final String BASE_URL = "https://http.cat/";
    private static final OkHttpClient httpClient = new OkHttpClient();

    public static String getStatusImage(int code) throws Exception {
        String url = BASE_URL + code + ".jpg";

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = httpClient.newCall(request).execute();

        if (!response.isSuccessful()) {
            throw new Exception("Failed to get status image for code " + code);
        }

        return url;
    }
}
