package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        if (sentence.length() == 0) {
            return new HashMap<String, Integer>();
        }

        List<String> words = Arrays.asList(sentence.split(" "));

        return words.stream()
                    .collect(Collectors.groupingBy(word -> word, Collectors.reducing(0, e -> 1, Integer::sum)));
    }

    public static String toString(Map<String, Integer> countedWords) {
        if (countedWords.size() == 0) {
            return "{}";
        }

        List<String> wordsCountInArray = new ArrayList<>(countedWords.size());

        for (Map.Entry<String, Integer> entry : countedWords.entrySet()) {
            String entryToString = "  " + entry.getKey() + ": " + entry.getValue();
            wordsCountInArray.add(entryToString);
        }

        String result = wordsCountInArray.stream()
                                         .collect(Collectors.joining("\n", "{\n", "\n}"));

        return result;
    }
}
//END
