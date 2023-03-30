package app;

import api.APIConsumer;
import api.enums.Topic;

public class App {
    public static void main(String[] args) {
        //Connect to API.
        APIConsumer api = new APIConsumer(Topic.MOST_POPULAR_TVS, "k_h163zvxx");

        //Show data
        api.getContentList().forEach(System.out::println);

        //Generate stickers with API contents.
        api.createStickers(4);
    }
}