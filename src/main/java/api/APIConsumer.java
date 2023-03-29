package api;

import api.enums.Topic;
import entities.Film;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class APIConsumer {
    private final String URL;
    private final HttpClient CLIENT;
    private final URI API_URI;

    public APIConsumer(Topic topic, String key) {
        this.URL = "https://imdb-api.com/en/API/" + topic.toString() + "/" + key;
        this.CLIENT = HttpClient.newHttpClient();
        this.API_URI = URI.create(URL); //can't be String (URL)
    }

    //Make an HTTP request and return the list of topic specified.
    public List<Film> getTopicList() {
        try {
            return JsonParser.JsonToFilmList(getResponse().body());
        } catch(InterruptedException | IOException e) {
            throw new RuntimeException("ERROR: " + e.getMessage());
        }
    }

    public void createStickers(int quantity) {
        try {
            List<Map<String, String>> mapList = JsonParser.parse(getResponse().body());
            for(int i = 0; i < quantity; i++) {
                String title = mapList.get(i).get("title");
                String URL = mapList.get(i).get("image");
                double imdbRating = Double.parseDouble(mapList.get(i).get("imDbRating"));

                String text;
                if(imdbRating >= 8.0)
                    text = "COOL !";
                else
                    text = "HMM...";
                StickerGenerator.create(URL, title, text);
            }
        } catch(InterruptedException | IOException e) {
            throw new RuntimeException("ERROR: " + e.getMessage());
        }
    }

    private HttpResponse<String> getResponse() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(API_URI).GET().build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return response;
    }

    public String getURL() {
        return URL;
    }

    public URI getAPI_URI() {
        return API_URI;
    }
}