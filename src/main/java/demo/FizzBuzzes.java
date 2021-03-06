package demo;

import com.google.common.collect.Iterables;
import com.google.common.collect.Streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class FizzBuzzes {

    private FizzBuzzes() {
    }

    /**
     * @param length desired size of sequence
     * @return a FizzBuzz sequence with specified size starting from 1, e.g. for {@code length} == 15:
     * <code>["1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14",
     * "FizzBuzz"]</code>
     */
    static List<String> fizzBuzz(int length) {
        return fizzBuzz().limit(length).collect(Collectors.toList());
    }

    static Stream<String> fizzBuzz() {
        var fizzBuzzes = Streams.zip(fizzes(), buzzes(), String::concat);

        return Streams.zip(fizzBuzzes,
                positiveInts().mapToObj(Integer::toString),
                FizzBuzzes::nonEmptyFirstOrElseSecond
        );
    }

    private static Stream<String> fizzes() {
        return Streams.stream(Iterables.cycle("", "", "Fizz"));
    }

    private static Stream<String> buzzes() {
        return Streams.stream(Iterables.cycle("", "", "", "", "Buzz"));
    }

    private static String nonEmptyFirstOrElseSecond(String first, String second) {
        //if (Integer.parseInt(second) == 42) return "\uD83D\uDCA3";
        return !first.isEmpty() ? first : second;
    }

    private static IntStream positiveInts() {
        return IntStream.iterate(1, i -> i + 1);
    }

}
