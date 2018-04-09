package demo;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitQuickcheck.class)
public class PropertyTest_2 {

    public static class FizzBuzzGenerator extends Generator<List> {
        public FizzBuzzGenerator() {
            super(List.class);
        }

        @Override
        public List<String> generate(SourceOfRandomness random, GenerationStatus status) {
            return FizzBuzzes.fizzBuzz(status.size());
        }

        @Override
        public List<List> doShrink(SourceOfRandomness random, List larger) {
            return IntStream.rangeClosed(0, larger.size() - 1)
                    .mapToObj(maxIdx -> larger.subList(0, maxIdx))
                    .collect(Collectors.toList());
        }
    }

    @Property
    public void fizzes(@From(PropertyTest_2.FizzBuzzGenerator.class) List<String> sequence) {
        for (int i = 3; i <= sequence.size(); i += 3) {
            assertThat(sequence.get(i - 1)).as("element %s", i).contains("Fizz");
        }
    }

    @Property
    public void buzzes(@From(PropertyTest_2.FizzBuzzGenerator.class) List<String> sequence) {
        for (int i = 5; i <= sequence.size(); i += 5) {
            assertThat(sequence.get(i - 1)).as("element %s", i).contains("Buzz");
        }
    }

    @Property
    public void numbers(@From(PropertyTest_2.FizzBuzzGenerator.class) List<String> sequence) {
        for (int i = 1; i <= sequence.size(); i += 1) {
            if (i % 3 != 0 && i % 5 != 0)
                assertThat(sequence.get(i - 1)).as("element %s", i).isEqualTo(String.valueOf(i));
        }
    }

    @Property
    public void size(@InRange(min = "2", max = "1000") int length) {
        var sequence = FizzBuzzes.fizzBuzz(length);

        assertThat(sequence.size()).as("generated sequence size").isEqualTo(length);
    }

}
