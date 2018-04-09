package demo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExamplesTest_2 {

    @Test
    public void produces_empty_sequence() {
        assertThat(FizzBuzzes.fizzBuzz(0)).containsExactly();
    }

    @Test
    public void produces_one_element() {
        assertThat(FizzBuzzes.fizzBuzz(1)).containsExactly("1");
    }

}
