package exercise1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class WordsTest {
    public static void main(String[] args) {
        try {
            List<String> strings = FileImporter.readWordsFromFile("words.txt");
            String longestWord = WordsUtils.findLongestWord(strings);
            String shortestWord = WordsUtils.findShortestWord(strings);
            System.out.println(strings);
            System.out.println("Najdłuższy wyraz: " + longestWord);
            System.out.println("Najkrótszy wyraz: " + shortestWord);
            System.out.println("Łączna długość napisów: " + WordsUtils.countLetters(strings));
        } catch (IOException e) {
            System.err.println("Nie udało się odczytać pliku");
        }
    }
}


