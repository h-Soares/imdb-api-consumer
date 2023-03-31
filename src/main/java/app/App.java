package app;

import api.APIConsumer;
import api.enums.Topic;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //Get key
        System.out.print("KEY: ");
        Scanner scan = new Scanner(System.in);
        String KEY = scan.next();
        scan.close();

        //Warning: maybe API image url can change!
        //Connect to API.
        APIConsumer api = new APIConsumer(Topic.MOST_POPULAR_TVS, KEY);

        //Show data
        api.getContentList().forEach(System.out::println);

        //Generate stickers with API contents.
        api.createStickers(4);
    }
}