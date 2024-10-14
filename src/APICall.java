import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.NoSuchElementException;

public class APICall {

    public Currency getCurrency (String code) {

        URI uri = URI.create("https://v6.exchangerate-api.com/v6/483e7d509d62336645f3956b/latest/"
                + code);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Currency.class);
        } catch (Exception e) {
            throw new NoSuchElementException("Couldn't found currency: %s".formatted(code));
        }
    }
}
