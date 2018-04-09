package demo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExamplesTest_1 {

    @Test
    public void produces_empty_sequence() {
        assertThat(FizzBuzzes.fizzBuzz(0)).containsExactly();
    }

}
