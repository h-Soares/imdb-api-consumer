package api;

import entities.Film;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class APIConsumer {
    private final String URL;
    private final HttpClient CLIENT;
    private final URI API_URI;

    public APIConsumer(String key) {
        this.URL = "https://imdb-api.com/en/API/Top250Movies/" + key;
        this.CLIENT = HttpClient.newHttpClient();
        this.API_URI = URI.create(URL); //can't be String (URL)
    }

    //Make an HTTP request and return the top 250 movies.
    public List<Film> getTop250Movies() {
        try {
            HttpRequest request = HttpRequest.newBuilder(API_URI).GET().build();
            HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            return JsonParser.JsonToFilmList(response.body());
        } catch(InterruptedException | IOException e) {
            throw new RuntimeException("ERROR: " + e.getMessage());
        }
    }

    public String getURL() {
        return URL;
    }

    public HttpClient getCLIENT() {
        return CLIENT;
    }

    public URI getAPI_URI() {
        return API_URI;
    }
}