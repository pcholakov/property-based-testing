package demo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExamplesTest_3 {

    @Test
    public void produces_empty_sequence() {
        assertThat(FizzBuzzes.fizzBuzz(0)).containsExactly();
    }

    @Test
    public void produces_one_element() {
        assertThat(FizzBuzzes.fizzBuzz(1)).containsExactly("1");
    }

    @Test
    public void produces_fizzes_and_buzzes() {
        assertThat(FizzBuzzes.fizzBuzz(15)).containsExactly(
                "1", "2", "Fizz", "4", "Buzz", "Fizz", "7",
                "8", "Fizz", "Buzz", "11", "Fizz", "13", "14",
                "FizzBuzz");
    }

}
