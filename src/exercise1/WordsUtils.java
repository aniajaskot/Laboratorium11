package exercise1;

import java.util.List;

class WordsUtils {

    static String findLongestWord(List<String> words) {
        String longestWord = null;
        int longestWordLetters = 0;
        for (String word : words) {
            int wordLength = word.length();
            if (wordLength > longestWordLetters) {
                longestWordLetters = wordLength;
                longestWord = word;
            }
        }
        return longestWord;
    }

    static String findShortestWord(List<String> words) {
        String shortestWord = null;
        int shortestWordLetters = words.get(0).length();
        for (String word : words) {
            int wordLength = word.length();
            if (wordLength < shortestWordLetters) {
                shortestWordLetters = wordLength;
                shortestWord = word;
            }
        }
        return shortestWord;
    }

    static int countLetters(List<String> words) {
        int counter = 0;
        for (String word : words) {
            counter += word.length();
        }
        return counter;
    }

}
