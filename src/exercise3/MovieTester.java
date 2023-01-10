package exercise3;

import java.io.IOException;
import java.util.*;

public class MovieTester {
    public static void main(String[] args) {

        MovieDatabaseReader movieDatabaseReader = new MovieDatabaseReader();

        try {
            Set<Movie> allMovies = movieDatabaseReader.readMovieDatabase();
            System.out.println("Baza danych wczytana. Liczba elementów: " + allMovies.size());

            Map<String, Set<Movie>> moviesByCategory = getMoviesByCategory(allMovies);

            System.out.println("Lista kategorii");
            for (String name : moviesByCategory.keySet()) {
                System.out.println(name);
            }

            System.out.println("\n");
            System.out.println("Liczba filmów w kategorii");
            for (Map.Entry<String, Set<Movie>> entry : moviesByCategory.entrySet()) {
                String genre = entry.getKey();
                Set<Movie> movies = entry.getValue();

                System.out.println("Gatunek " + genre + ", liczba filmów: " + movies.size());
            }

            System.out.println("\n");
            System.out.println("Podaj kategorię");
            Scanner input = new Scanner(System.in);
            String category = input.nextLine();

            Set<Movie> moviesForCategory = moviesByCategory.get(category);
            for (Movie movie : moviesForCategory) {
                System.out.println(movie);
            }

            System.out.println("\n");
            System.out.println("Liczba filmów w danym roku");
            Map<Integer, Set<Movie>> moviesByYear = getMoviesByYear(allMovies);
            for (Map.Entry<Integer, Set<Movie>> entry : moviesByYear.entrySet()) {
                Integer year = entry.getKey();
                Set<Movie> moviesInYear = entry.getValue();

                System.out.println("Rok " + year + ", liczba filmów: " + moviesInYear.size());
            }

            System.out.println("\n");
            System.out.println("Podaj rok");
            int year = input.nextInt();
            input.nextLine();

            Set<Movie> moviesForYear = moviesByYear.get(year);
            for (Movie movie : moviesForYear) {
                System.out.println(movie);
            }

        } catch (IOException e) {
            System.out.println("Nie udało się odczytać bazy filmów.");
        }

    }

    private static Map<String, Set<Movie>> getMoviesByCategory(Set<Movie> allMovies) {
        Map<String, Set<Movie>> moviesByCategory = new TreeMap<>();

        for (Movie movie : allMovies) {
            Set<String> genres = movie.getGenre();
            for (String genre : genres) {
                Set<Movie> moviesInGivenGenre;
                if (moviesByCategory.containsKey(genre)) {
                    moviesInGivenGenre = moviesByCategory.get(genre);
                } else {
                    moviesInGivenGenre = new HashSet<>();
                    moviesByCategory.put(genre, moviesInGivenGenre);
                }
                moviesInGivenGenre.add(movie);
            }
        }
        return moviesByCategory;
    }

    private static Map<Integer, Set<Movie>> getMoviesByYear(Set<Movie> allMovies) {
        Map<Integer, Set<Movie>> moviesByYear = new TreeMap<>();
        for (Movie movie : allMovies) {
            int movieYear = movie.getYear();
            Set<Movie> moviesInGivenYear;
            if (moviesByYear.containsKey(movieYear)) {
                moviesInGivenYear = moviesByYear.get(movieYear);
            } else {
                moviesInGivenYear = new HashSet<>();
                moviesByYear.put(movieYear, moviesInGivenYear);
            }
            moviesInGivenYear.add(movie);
        }
        return moviesByYear;
    }
}
