package entities;

public class Film {
    private String title;
    private String image;
    private String imdbRating;

    public Film(String title, String image, String imdbRating) {
        this.title = title;
        this.image = image;
        this.imdbRating = imdbRating;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TITLE: ").append(title).append("\t");
        sb.append("IMAGE: ").append(image).append("\t");
        sb.append("IMDB RATING: ").append(imdbRating);
        return sb.toString();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }
}