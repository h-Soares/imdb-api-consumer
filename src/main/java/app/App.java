package app;

import api.APIConsumer;
import api.enums.Topic;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException { //change this later
        //Connect to API.
        APIConsumer api = new APIConsumer(Topic.MOST_POPULAR_TVS, "k_h163zvxx");

        //Show data
        //api.getTop250Movies().forEach(System.out::println);

        //Generate stickers with API films.
        api.createStickers(4);
    }
}