package app;

//import api.APIConsumer;
import api.StickerGenerator;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException { //change this later
        //Connect to API.
        //APIConsumer api = new APIConsumer("k_h163zvxx");

        //Show data
        //api.getTop250Movies().forEach(System.out::println);

        //Test sticker generator
        StickerGenerator stickerGenerator = new StickerGenerator();
        String URL = "https://m.media-amazon.com/images/M/MV5BNDE3ODcxYzMtY2YzZC00NmNlLWJiNDMtZDViZWM2MzIxZDYwXkEyXkFqcGdeQXVyNjAwNDUxODI@.jpg";
        stickerGenerator.create(URL,"testing");

        //Generate stickers with API films.
    }
}