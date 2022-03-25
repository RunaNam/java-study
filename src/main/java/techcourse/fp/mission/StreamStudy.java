package techcourse.fp.mission;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamStudy {

    public static long countWords() throws IOException {
        String contents = Files.readString(Paths
            .get("src/main/resources/fp/war-and-peace.txt"));

        return Arrays.stream(contents.split("[\\P{L}]+"))
            .filter(word -> word.length() > 12)
            .count();
    }

    public static List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream()
            .map(integer -> integer * 2)
            .collect(Collectors.toList());
    }

    public static long sumAll(List<Integer> numbers) {
        return numbers.stream()
            .mapToInt(num -> num)
            .sum();
    }

    public static long sumOverThreeAndDouble(List<Integer> numbers) {
        return numbers.stream()
            .mapToLong(num -> num)
            .filter(num -> num > 3)
            .map(num -> num * 2)
            .sum();
    }

    public static void printLongestWordTop100() throws IOException {
        String contents = Files.readString(Paths
            .get("src/main/resources/fp/war-and-peace.txt"));

        List<String> words = Arrays.stream(contents.split("[\\P{L}]+"))
            .filter(word -> word.length() > 12)
            .distinct()
            .limit(100)
            .collect(Collectors.toList());

        System.out.println(words);
        System.out.println(words.size());
    }
}
