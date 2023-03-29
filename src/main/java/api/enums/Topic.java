package api.enums;

public enum Topic {
    TOP_250_MOVIES("Top250Movies"),
    MOST_POPULAR_MOVIES("MostPopularMovies"),
    MOST_POPULAR_TVS("MostPopularTVs");

    private final String name;
    Topic(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}