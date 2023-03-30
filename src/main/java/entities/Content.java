package entities;

public class Content {
    private final String title;
    private final String imageUrl;
    private final String imdbRating;

    public Content(String title, String imageUrl, String imdbRating) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.imdbRating = imdbRating;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TITLE: ").append(title).append("\t");
        sb.append("IMAGE URL: ").append(imageUrl).append("\t");
        sb.append("IMDB RATING: ").append(imdbRating);
        return sb.toString();
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getImdbRating() {
        return imdbRating;
    }
}