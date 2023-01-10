package exercise3;

import java.util.Set;

public class Movie {

    private Long id;
    private String title;
    private int year;
    private Set<String> genre;

    public Movie(Long id, String title, int year, Set<String> genre) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public Set<String> getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", genre=" + genre +
                '}';
    }
}

