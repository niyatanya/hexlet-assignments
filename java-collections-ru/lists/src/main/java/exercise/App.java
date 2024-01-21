package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(String chars, String word) {
        List<String> charsArr = new ArrayList<>(Arrays.asList(chars.split("")));
        String normalizedWord = word.toLowerCase();
        List<String> wordArr = new ArrayList<>(Arrays.asList(normalizedWord.split("")));

        for (String letter : charsArr) {
            if (wordArr.contains(letter)) {
                wordArr.remove(wordArr.indexOf(letter));
            }
        }
        return wordArr.isEmpty();
    }
}
//END
