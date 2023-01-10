package exercise3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MovieDatabaseReader {

    private Set<Movie> allMovies;

    Set<Movie> readMovieDatabase() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("movies.csv"));
        reader.readLine();
        String line;

        allMovies = new HashSet<>();

        while ((line = reader.readLine()) != null) {
            parseLine(line);
        }

        return allMovies;
    }

    private void parseLine(String line) {
        if (line.contains("\"")) {
            parseLineWithQuotationMark(line);
        } else {
            parseLineWithoutQuotationMark(line);
        }
    }

    private void parseLineWithoutQuotationMark(String line) {
        String[] split = line.split(",");

        long id = Long.parseLong(split[0]);
        String titleWithYear = split[1].trim();

        HashSet<String> genres = parseGenres(split[2]);

        TitleAndYear titleAndYear = parseTitleAndYear(titleWithYear);
        Movie movie = new Movie(id, titleAndYear.getTitle(), titleAndYear.getYear(), genres);
        allMovies.add(movie);
    }

    private void parseLineWithQuotationMark(String line) {
        String[] split = line.split("\"");

        String genresString = "";
        String titleWithYear = split[1];
        if (split.length == 5) {
            titleWithYear = split[1] + split[2] + split[3];
            genresString = split[4].substring(1);
        } else if (split.length == 3) {
            genresString = split[2].substring(1);
        } else {
            throw new RuntimeException("Split lenght " + split.length);
        }

        TitleAndYear titleAndYear = parseTitleAndYear(titleWithYear);

        long id = Long.parseLong(split[0].substring(0, split[0].length() - 1));

        HashSet<String> genres = parseGenres(genresString);

        Movie movie = new Movie(id, titleAndYear.getTitle(), titleAndYear.getYear(), genres);
        allMovies.add(movie);
    }

    private HashSet<String> parseGenres(String genresString) {
        String[] genresArray = genresString.split("\\|");
        List<String> strings = Arrays.asList(genresArray);
        return new HashSet<>(strings);
    }

    private TitleAndYear parseTitleAndYear(String titleWithYear) {
        String title = titleWithYear;
        String yearAsString = "0";
        if (titleWithYear.contains("(")) {
            int length = titleWithYear.length();
            yearAsString = titleWithYear.substring(length - 5, length - 1);
            title = titleWithYear.substring(0, length - 7);
        }
        return new TitleAndYear(title, Integer.parseInt(yearAsString));
    }

}