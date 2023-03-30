package api;

import api.enums.Topic;
import entities.Content;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class APIConsumer {
    private final String URL;

    public APIConsumer(Topic topic, String key) {
        this.URL = "https://imdb-api.com/en/API/" + topic.toString() + "/" + key;
    }

    //Make an HTTP request and return the content list of specified topic.
    public List<Content> getContentList() {
        try {
            return JsonParser.parseToContentList(getResponseBody());
        } catch(InterruptedException | IOException e) {
            throw new RuntimeException("ERROR: " + e.getMessage());
        }
    }

    public void createStickers(int quantity) {
        try {
            List<Map<String, String>> mapList = JsonParser.parseToMapList(getResponseBody());
            for(int i = 0; i < quantity; i++) {
                String title = mapList.get(i).get("title");
                String imageUrl = mapList.get(i).get("image");
                double imdbRating = Double.parseDouble(mapList.get(i).get("imDbRating"));

                String text;
                if(imdbRating >= 8.0)
                    text = "COOL !";
                else
                    text = "HMM...";
                StickerGenerator.create(imageUrl, title, text);
            }
        } catch(InterruptedException | IOException e) {
            throw new RuntimeException("ERROR: " + e.getMessage());
        }
    }

    private String getResponseBody() throws IOException, InterruptedException {
        URI uri = URI.create(URL); //can't be String (URL)
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}