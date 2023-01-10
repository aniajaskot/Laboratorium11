package exercise1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class FileImporter {
    static List<String> readWordsFromFile(String fileName) throws IOException {

        List<String> result = new ArrayList<>();
        FileReader fileReader = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(fileReader);

        String nextLine = null;
        int lines = 0;
        while ((nextLine = reader.readLine()) != null) {
            result.add(nextLine);
        }

        return result;
    }
}
