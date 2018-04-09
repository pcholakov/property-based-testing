package demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class ExamplesTest_4 {

    @Parameters(name = "{index}: fizzBuzz({0}) -> {1}")
    public static Collection<Object[]> examples() {
        return Arrays.asList(new Object[][]{
                {0, new String[]{}},
                {1, new String[]{"1"}},
                {15, new String[]{
                        "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8",
                        "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"}}
        });
    }

    @Parameter
    public int n;

    @Parameter(1)
    public String[] expected;

    @Test
    public void produces_correct_sequence() {
        assertThat(FizzBuzzes.fizzBuzz(n)).containsExactly(expected);
    }

}
