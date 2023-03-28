package app;

import api.APIConsumer;

public class App {
    public static void main(String[] args) {
        //Connect to API.
        APIConsumer api = new APIConsumer("k_h163zvxx");

        //Show data
        api.getTop250Movies().forEach(System.out::println);

//        TO REMEMBER: Each map contains multiple keys!
//        Map<String, String> test = new HashMap<>();
//        test.put("title", "TITLEtest");
//        test.put("image", "IMAGEtest");
//        test.put("imdbRating", "IMDBtest");
//
//        System.out.println(test.get("title") + "\n");
//        System.out.println(test.get("image") + "\n");
//        System.out.println(test.get("imdbRating"));
    }
}