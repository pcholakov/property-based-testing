package demo;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitQuickcheck.class)
public class PropertyTest_1 {

    @Property
    public void fizzBuzzSequence(@InRange(min = "2", max = "1000") int length) {
        var sequence = FizzBuzzes.fizzBuzz(length);

        assertThat(sequence.size()).as("generated sequence size").isEqualTo(length);

        for (int i = 1; i <= sequence.size(); i++) {
            var s = sequence.get(i - 1);
            if (i % 3 == 0) assertThat(s).as("element %s", i).contains("Fizz");
            if (i % 5 == 0) assertThat(s).as("element %s", i).contains("Buzz");
            if (i % 3 == 0 && i % 5 == 0)
                assertThat(s).as("element %s", i).isEqualTo("FizzBuzz");
            if (i % 3 != 0 && i % 5 != 0)
                assertThat(s).as("element %s", i).isEqualTo(Integer.toString(i));
        }
    }

}
