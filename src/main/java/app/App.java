package app;

import api.APIConsumer;

public class App {
    public static void main(String[] args) {
        //Connect to API.
        APIConsumer api = new APIConsumer("k_h163zvxx");

        //Show data
        api.getTop250Movies().forEach(System.out::println);
    }
}